package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponeIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //以下会报错，不能同时使用字符流和字节流
//        resp.getWriter();
//        resp.getOutputStream();
        resp.setCharacterEncoding("UTF-8");
        //下面打错了
        //resp.setHeader("Content-Type","text/html;charset=UIF-8");
//        resp.setHeader("Context-Type", "text/html;charset=UTF-8");
//        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
       // writer.write("志杰");
        //System.out.println(resp.getCharacterEncoding());//ISO-8859-1
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println(resp.getCharacterEncoding());//服务器编码
        PrintWriter writer = resp.getWriter();
        writer.write("志杰");//蹇楁澃,只设置了服务器的编码，浏览器的编码还没设置
    }
}
