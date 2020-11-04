package com.atg.test;

import com.atg.pojo.User;
import com.atg.service.UserService;
import com.atg.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();
    @Test
    public void registUser() {
        userService.registUser(new User(null, "bbj168", "66666", "bbj168@qq.com"));
        userService.registUser(new User(null, "abc168", "66666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "wzskf", "123456", "null")));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("wzskf")){
            System.out.println("用户名已存在！");
        }else{
            System.out.println("用户名可用!");
        }

    }
}