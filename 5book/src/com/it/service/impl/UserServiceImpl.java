package com.it.service.impl;

import com.it.dao.BaseDao;
import com.it.dao.UserDao;
import com.it.dao.impl.UserDaoImpl;
import com.it.pojo.User;
import com.it.service.UserService;

public class UserServiceImpl extends BaseDao implements UserService {
    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User loginUser(User user) {

        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao.queryUserByUsername(username) == null) {
            return false;
        }
        return true;

    }
}
