package authentication.authentication_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import authentication.authentication_service.exception.RegistrationException;
import authentication.authentication_service.exception.LoginException;
import authentication.authentication_service.model.ErrorResponse;
import authentication.authentication_service.model.TokenResponse;
import authentication.authentication_service.model.User;
import authentication.authentication_service.service.ClientService;
import authentication.authentication_service.service.TokenService;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {

    @Autowired
    private final ClientService clientService;

    @Autowired
    private final TokenService tokenService;

    @Autowired
    public AuthController(ClientService clientService, TokenService tokenService) {
        this.clientService = clientService;
        this.tokenService = tokenService;
    }

    @PostMapping
    public ResponseEntity<String> register(@RequestBody User user) {
        clientService.register(user.getLogin(), user.getPassword());
        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/token")
    public TokenResponse getToken(@RequestBody User user) {
        clientService.checkCredentials(
            user.getLogin(), user.getPassword());
        return new TokenResponse(
            tokenService.generateToken(user.getLogin()));
    }

    @ExceptionHandler({RegistrationException.class, LoginException.class})
    public ResponseEntity<ErrorResponse> handleUserRegistrationException(RuntimeException ex) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }
}
