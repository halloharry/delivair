package com.delivair.repository;

import com.delivair.common.payload.response.BaseResponse;
import com.delivair.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsDeleted(Integer isDeleted);
}
