package authentication.authentication_service.service;

public interface ClientService {
    void register(String login, String clientSecret);
    void checkCredentials(String login, String clientSecret);

}
