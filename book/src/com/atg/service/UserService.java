package com.atg.service;

import com.atg.pojo.User;

public interface UserService {

    /**
     *  注册用户
     */
    public void registUser(User user);

    /**
     *  登录用户
     */
    public User login(User user);
    /**
     *  用户名是否可用
     */
    public boolean existsUsername(String username);
}
