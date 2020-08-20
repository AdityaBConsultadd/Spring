package com.customer.customermanagement.service;

import com.customer.customermanagement.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderI {
    List<Order> getallOrder();
    Optional<Order> findById(long id);
    Order save(Order order);
    void deleteById(long id);
}
