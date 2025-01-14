package platform.platformstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import platform.platformstore.Exception.UserAlreadyExistsException;
import platform.platformstore.Models.Role;
import platform.platformstore.Models.User;
import platform.platformstore.Repository.UserRepository;

@Service
public class UserService {

     private final UserRepository userRepository; 
                                                 
    private final PasswordEncoder passwordEncoder; 

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


    public User updateProfile(User user) {
        Optional<User> optionalUser  = userRepository.findById(user.getId());
        if (optionalUser .isPresent()) {
            User userbyId = optionalUser.get();
            userbyId.setFirstName(user.getFirstName());
            userbyId.setLastName(user.getLastName());
            userbyId.setEmail(user.getEmail());
            userRepository.save(user); 
            return userbyId; 
        } else {
            throw new RuntimeException("Пользователь не найден"); 
        }
    }

    public boolean isUserExists(User userDTO) {

        return userRepository.existsByUsername(userDTO.getUsername());

    }



}
