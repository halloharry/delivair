package com.delivair.repository;

import com.delivair.model.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    List<ProductCategory> findByIsDeleted(Integer isDeleted);
    ProductCategory findByIdAndIsDeleted(Long id, Integer isDeleted);
}
