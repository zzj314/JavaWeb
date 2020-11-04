package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

public class ParameterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //要在获取请求参数之前调用才有效
//        request.setCharacterEncoding("UTF-8");
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String[] hobby = request.getParameterValues("hobby");
//
//        System.out.println("username:"+username);
//        System.out.println("password:"+password);
//        System.out.println("hobby:"+ Arrays.asList(hobby));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        String hobby = request.getParameter("hobby");
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("username:"+username);
        System.out.println("password:"+password);
        System.out.println("hobby:"+ Arrays.asList(hobby));
    }
}
