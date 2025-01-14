package platform.platformstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import platform.platformstore.Models.User;
import platform.platformstore.services.UserService;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    private final UserService userService;

    @Autowired
    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateProfile(@RequestBody User user) {
        try {
            userService.updateProfile(user);
            return ResponseEntity.ok("Профиль пользователя обновлен успешно");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<String> createUser (@RequestBody User user) {
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());

        return ResponseEntity.ok("Пользователь успешно создан: " + user.getUsername());
    }
/* 
    @GetMapping("/{id}")
    public ResponseEntity<User> getProfile(@PathVariable Long id) {
        try {
            User user = userService.getProfileById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }*/
}