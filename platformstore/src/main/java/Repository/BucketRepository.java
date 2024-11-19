package Repository;

import Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BucketRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);
}
