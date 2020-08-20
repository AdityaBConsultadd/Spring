package com.crm.customer.service;


import com.crm.customer.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;


@Controller
@RequestMapping("/web")
public class CustomerService implements Serializable {

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/ls")
    public String get(){
        return "ListCustomer";
    }


}
