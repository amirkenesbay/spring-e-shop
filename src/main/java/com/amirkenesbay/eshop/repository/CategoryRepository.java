package com.amirkenesbay.eshop.repository;

import com.amirkenesbay.eshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
