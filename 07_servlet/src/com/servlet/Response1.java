package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.stream.Location;
import java.io.IOException;

public class Response1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("到此");
//        resp.setStatus(302);
//        //Location:设置新的地址
////        resp.setHeader("Location", "http://localhost:8080/07_servlet/response2");
//        resp.setHeader("Location", "http://www.baidu.com");
        resp.sendRedirect("http://www.baidu.com");
    }
}
