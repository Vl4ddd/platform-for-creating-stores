package platform.platformstore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import platform.platformstore.Models.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
