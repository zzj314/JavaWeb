package com.it.web;

import com.it.pojo.User;
import com.it.service.UserService;
import com.it.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User loginUser = userService.loginUser(new User(null, username, password, null));
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
