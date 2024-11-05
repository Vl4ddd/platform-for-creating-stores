package authentication.authentication_service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import authentication.authentication_service.entities.client.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

    Optional<Client> findByLogin(String login);

}
