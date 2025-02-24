package platform.platformstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.platformstore.Exception.UserAlreadyExistsException;
import platform.platformstore.Models.User;
import platform.platformstore.services.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser (@RequestBody User userDTO) {
        try {
            userService.createUser (userDTO);
            return ResponseEntity.ok("Пользователь зарегистрирован успешно");
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser (@RequestBody User userDTO) {
       
        return ResponseEntity.ok("Пользователь успешно вошел в систему");
    }
}
