package com.platformstore.productAPI.Repository;

import com.platformstore.productAPI.Entities.Product.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
