package com.example.service;

import com.example.domain.Page;
import com.example.domain.UserTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public Page<UserTO> listUser(){
        //查询xxxxxx
        return null;
    }


    public List<UserTO> listUser1(){
        return new ArrayList<>();
    }
}
