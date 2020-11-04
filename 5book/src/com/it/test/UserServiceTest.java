package com.it.test;

import com.it.pojo.User;
import com.it.service.UserService;
import com.it.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService  = new UserServiceImpl();

    @Test
    public void registUser() {
        //userService.registUser(new User(null, "a", "b", "c@qq.com"));
        userService.registUser(new User(null, "abc1668", "66666", "abc168@qq.com"));
        userService.registUser(new User(null, "bbj1668", "66666", "bbj168@qq.com"));

    }

    @Test
    public void loginUser() {
        System.out.println(userService.loginUser(new User(null, "admin", "admin", "b@qq.com")));
    }

    @Test
    public void existsUsername() {
        System.out.println(userService.existsUsername("admin"));
    }
}