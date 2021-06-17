package com.example.Test;

import com.example.dao.UserDao;
import com.example.domain.User;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("zyx",20);
        userDao.add(user);
    }
}
