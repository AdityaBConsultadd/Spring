package com.example.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/")
public class REst implements Serializable {
    @Autowired
    public UserRepo userRepo;
    @GetMapping("/get")
    List<User> get(){
        return userRepo.findAll();
    }
}
