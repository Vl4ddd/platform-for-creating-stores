package platform.platformstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import platform.platformstore.Models.User;
import platform.platformstore.Repository.UserRepository;

@Service
public class UserService {

     private final UserRepository userRepository; // Предполагается, что у вас есть репозиторий для доступа к данным
                                                 // пользователей
    private final PasswordEncoder passwordEncoder; // Для шифрования паролей

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(User userDTO) {

        if (isUserExists(userDTO)) {
            throw new UserAlreadyExistsException("Пользователь с таким логином уже существует");
        }

        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword())); 
        user.setRole(Role.ROLE_USER);

        return userRepository.save(user);

    }

    public boolean isUserExists(User userDTO) {

        return userRepository.existsByLogin(userDTO.getLogin());

    }

}
