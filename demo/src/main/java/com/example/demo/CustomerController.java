package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.PermitAll;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/signup")
    public String signup(Customer customer){
        return "add-customer";
    }

    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("customer",customerRepo.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String add(Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "add-customer";
        }
        customerRepo.save(customer);
        return "redirect:list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(value = "id")Long id,Model model){
        Customer customer = customerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("customerid"+id));
        model.addAttribute("customer",customer);
        return "update-customer";
    }

    @PostMapping("/update/id")
    public String update(Customer customer, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "update-customer";
        }
        customerRepo.save(customer);
        return "redirect:list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id")Long id,Model model){
        Customer customer = customerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("customerid"+id));
        customerRepo.delete(customer);
        model.addAttribute("customer",customerRepo.findAll());
        return "index";
    }



}
