package authentication.authentication_service.service;

import org.springframework.stereotype.Service;

public interface TokenService {
    String generateToken(String clientId);
}
