package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("在Servlet1中查看"+username);
        req.setAttribute("key1", "1给的材料");
        //问到Servlet2
        //路径写的是别名路径
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");
        //不允许出栈
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");
      //  RequestDispatcher requestDispatcher = req.getRequestDispatcher("/");
        requestDispatcher.forward(req, resp);

    }
}
