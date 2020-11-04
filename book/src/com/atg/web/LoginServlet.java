package com.atg.web;

import com.atg.pojo.User;
import com.atg.service.UserService;
import com.atg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //调用service处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        if (loginUser == null){
            //如果等于null，登录失败
            //错误信息显示
            req.setAttribute("msg", "用户名或密码错误!" );
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }else {
            //登录成功
            //跳转到登录成功页面
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }

    }
}
