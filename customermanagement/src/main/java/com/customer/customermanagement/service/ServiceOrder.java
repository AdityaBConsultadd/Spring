package com.customer.customermanagement.service;

import com.customer.customermanagement.Repository.OrderRepo;
import com.customer.customermanagement.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceOrder implements OrderI{
    @Autowired
    OrderRepo orderRepo;
    @Override
    public List<Order> getallOrder() {
        return orderRepo.findAll();
    }

    @Override
    public Optional<Order> findById(long id) {
        return orderRepo.findById(id);
    }

    public ServiceOrder(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }


    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void deleteById(long id) {
        orderRepo.deleteById(id);

    }
}
