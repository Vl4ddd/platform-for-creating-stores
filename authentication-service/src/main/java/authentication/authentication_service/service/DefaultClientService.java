package authentication.authentication_service.service;

import java.util.Optional;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import authentication.authentication_service.entities.client.Client;
import authentication.authentication_service.entities.client.Role;
import authentication.authentication_service.exception.RegistrationException;
import authentication.authentication_service.exception.LoginException;
import authentication.authentication_service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {

    private final ClientRepository userRepository;

    @Override
    public void register(String login, String password) {
        if(userRepository.findByLogin(login) != null)
            throw new RegistrationException(
                "Client with id: " + login + " already registered");

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());

        Client client = new Client();
        client.setLogin(login);
        client.setPassword(hash);
        client.setRole(Role.ROLE_USER);

        // Сохраняем пользователя в базе данных
        userRepository.save(client);
    }

    @Override
    public void checkCredentials(String login, String password) {
        Optional<Client> userEntity = userRepository
            .findById(login);
        if (userEntity.isEmpty())
            throw new LoginException(
                "Client with id: " + login + " not found");

        Client clientEntity = userEntity.get();

        if (!BCrypt.checkpw(password, clientEntity.getPassword()))
            throw new LoginException("Secret is incorrect");
    }

}
