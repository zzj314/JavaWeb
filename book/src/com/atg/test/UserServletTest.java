package com.atg.test;

import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("登录");
    }
    public void regist(){
        System.out.println("注册");
    }
    public void updateUser(){
        System.out.println("更新用户");
    }
    public void updateUserPassword(){
        System.out.println("更新密码");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
