package com.crm.customer.Repository;

import com.crm.customer.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Long>{
    @Query(value = "SELECT * FROM orders WHERE orders.customerid=?",nativeQuery = true)
    List<Order> Q1(int i);

}
