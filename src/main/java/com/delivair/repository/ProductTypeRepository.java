package com.delivair.repository;

import com.delivair.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    ProductType findByIdAndIsDeleted(Long id, Integer isDeleted);
}
