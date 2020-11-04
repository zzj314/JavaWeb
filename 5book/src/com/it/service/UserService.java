package com.it.service;

import com.it.pojo.User;

public interface UserService {

    public void registUser(User user);

    public User loginUser(User user);

    public boolean existsUsername(String username);
}
