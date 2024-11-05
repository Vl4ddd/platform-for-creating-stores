package authentication.authentication_service.UserTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import authentication.authentication_service.entities.client.Client;
import authentication.authentication_service.repository.ClientRepository;

@SpringBootTest
public class UserTest {

     private final ClientRepository clientRepository;

    @Autowired
    UserTest(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

     @Test
    void createTestUser() {
        Client client = new Client();
        client.setLogin("Alex");
        client.setPassword("123");
        clientRepository.save(client);

    }

}
