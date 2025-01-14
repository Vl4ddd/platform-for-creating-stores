package platform.platformstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import platform.platformstore.Models.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
