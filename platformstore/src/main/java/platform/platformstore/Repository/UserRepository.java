package platform.platformstore.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import platform.platformstore.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);
}
