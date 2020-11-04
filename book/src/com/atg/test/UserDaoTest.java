package com.atg.test;

import com.atg.dao.UserDao;
import com.atg.dao.impl.UserDaoImpl;
import com.atg.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
       //
//        System.out.println(userDao.queryUserByUsername("admin"));
        if(userDao.queryUserByUsername("admin")==null){
            System.out.println("用户名可用！");
        }else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
       if(userDao.queryUserByUsernameAndPassword("admin", "admin")==null){
           System.out.println("用户名或密码错误，登录失败");
       }else{
           System.out.println("登录成功");
       }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao.saveUser(new User(null, "wzskf", "123456", "wzgdkfjl@com")));
    }
}