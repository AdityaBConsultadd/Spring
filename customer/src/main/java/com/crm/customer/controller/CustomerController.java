package com.crm.customer.controller;

import com.crm.customer.Repository.CustomerRepo;
import com.crm.customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@ResponseStatus(value = HttpStatus.NOT_FOUND)
@RequestMapping("/")
public class CustomerController implements Serializable {
    @Autowired
    CustomerRepo customerRepo;

    @GetMapping
    public List<Customer> get(){return customerRepo.findAll();}

}
