package authentication.authentication_service.service;


public interface TokenService {
    String generateToken(String clientId);
}
