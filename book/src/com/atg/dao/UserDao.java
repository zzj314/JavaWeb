package com.atg.dao;

import com.atg.pojo.User;

public interface UserDao {
    //在当前方法下按ctrl+shift+t 可以生成方法的测试方法

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    public User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return
     */
    public User queryUserByUsernameAndPassword(String username,String password);

    /**
     * 保存用户信息
     */
    public int saveUser(User user);
}
