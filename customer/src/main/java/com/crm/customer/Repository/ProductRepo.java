package com.crm.customer.Repository;

import com.crm.customer.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {
    @Query(value = "SELECT * FROM product WHERE product.name LIKE %:custom% ",nativeQuery = true)
    List<Product> Q1(@Param(value = "custom") String s);
}
//@param