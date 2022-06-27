package com.amirkenesbay.eshop.repository;

import com.amirkenesbay.eshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Long countById(Long id);
}
