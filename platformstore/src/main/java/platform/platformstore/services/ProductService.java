package platform.platformstore.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import platform.platformstore.Models.Product;
import platform.platformstore.Repository.BucketRepository;
import platform.platformstore.Repository.ProductRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final BucketRepository bucketRepository;

    public List<Product> listProducts(String title) {
        if (title != null)
            return productRepository.findByTitle(title);
        return productRepository.findAll();
    }

    public Product saveProduct(Product product) {
        log.info("Saving new {}", product);
        return productRepository.save(product);
    }

    public void addToBucket(Long id) {
        bucketRepository.save(productRepository.findById(id).get());
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
