package platform.platformstore.Controller;

import lombok.RequiredArgsConstructor;
import platform.platformstore.Models.Product;
import platform.platformstore.services.ProductService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products") 
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getProducts(@RequestParam(name = "title", required = false) String title) {
        List<Product> products = productService.listProducts(title);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductInfo(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        return ResponseEntity.ok(product);
    }

    
    @PostMapping("/{id}/addToBucket")
    public ResponseEntity<Void> addToBucket(@PathVariable Long id) {
        productService.addToBucket(id);
        return ResponseEntity.noContent().build(); 
    }

    @GetMapping("/ping")
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok("Pong");
    }
} 