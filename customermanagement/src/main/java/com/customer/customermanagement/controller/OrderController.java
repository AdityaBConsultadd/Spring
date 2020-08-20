package com.customer.customermanagement.controller;


import com.customer.customermanagement.Repository.OrderRepo;
import com.customer.customermanagement.exception.ResourceNotFound;
//import com.customer.customermanagement.model.Customer;
import com.customer.customermanagement.model.Order;
import com.customer.customermanagement.service.ServiceOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class OrderController implements Serializable {
    ServiceOrder serviceOrder;
    @Autowired
    public OrderController(ServiceOrder serviceOrder) {
        this.serviceOrder = serviceOrder;
    }

//    @Autowired
//    OrderRepo orderRepo;
    @GetMapping("/order")
    public List<Order> getorder(){
        return serviceOrder.getallOrder();
    }

    @GetMapping("/order/{id}")
    public Optional<Order> getorderOne(@PathVariable(value = "id") long id){

        return serviceOrder.findById(id);
    }

    @PostMapping("/order")
    public Order postorder(@RequestBody Order order){
        return serviceOrder.save(order);
    }

//    @PutMapping("/put/{id}/")
//    public Order putorder(@PathVariable(name = "id") long id,@RequestBody Order order) {
//        Order order1 = orderRepo.findById(id).orElseThrow(() -> new ResourceNotFound("order", "name", id));
//        order1.getName(order.getName());
//        Order update=orderRepo.save(order1);
//        return update;
//    }
    @DeleteMapping("order/{id}/")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        Order order=serviceOrder.findById(id).orElseThrow(() -> new ResourceNotFound("order", "name", id));
        serviceOrder.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
