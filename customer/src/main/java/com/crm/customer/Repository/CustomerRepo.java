package com.crm.customer.Repository;

import com.crm.customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
    @Query(value = "SELECT * FROM customer",nativeQuery = true)
    List<Customer> Q1();

    @Query(value = "SELECT * FROM customer WHERE customer.name=?",nativeQuery = true)
    List<Customer> Q2(String s);




}
//JDBC
//    JPQL
//    Native
//    @Query
//    Like
//    where like
