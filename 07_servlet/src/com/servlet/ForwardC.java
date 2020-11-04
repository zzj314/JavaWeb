package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ForwardC extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ForwordC程序");
        req.getRequestDispatcher("/a/b/c.html").forward(req, resp);
        //req.getRequestDispatcher("/").forward(req, resp);
    }
}
