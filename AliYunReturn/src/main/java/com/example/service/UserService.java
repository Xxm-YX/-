package com.example.service;

import com.example.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    public User getById(Long id) {
        User user = new User();
        user.setId(1L);
        user.setName("ztx");
        user.setAge("12");
        return user;
    }

    public Boolean save(User user){
        return true;
    }

}
