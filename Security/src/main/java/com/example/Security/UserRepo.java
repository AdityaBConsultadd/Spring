package com.example.Security;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface UserRepo extends JpaRepository<com.example.demo.User,Long> {
    public com.example.demo.User findByUserName(String userName);
}
