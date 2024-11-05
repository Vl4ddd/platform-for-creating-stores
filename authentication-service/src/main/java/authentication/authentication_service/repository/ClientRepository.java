package authentication.authentication_service.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import authentication.authentication_service.entities.client.Client;

public interface ClientRepository extends CrudRepository<Client, String>{

    List<Client> findByLogin(String login);

}
