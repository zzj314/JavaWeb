package com.atg.web;

import com.atg.pojo.User;
import com.atg.service.UserService;
import com.atg.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServelet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //2.检查验证码是否正确
        if ("abcde".equalsIgnoreCase(code)){
        //3.检查用户名是否可用
            if (userService.existsUsername(username)){
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email",email);
                //不可以，跳回注册页面
                System.out.println("用户名["+username+"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else {
                //可用，调用service保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        }else {
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email",email);

            //跳回注册页面
            System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }



    }
}
