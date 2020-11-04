package com.guigu.servlet;

import com.google.gson.Gson;
import com.guigu.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {


    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ajax过来了");

        Person person = new Person(1, "过");
        //测试同步
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);

        resp.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery的ajax过来了");
        Person person = new Person(1, "过");
        //json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery的get过来了");
        Person person = new Person(1, "过");
        //json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery的post过来了");
        Person person = new Person(1, "过");
        //json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQueryGetJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery的jQueryGetJSON过来了");
        Person person = new Person(1, "过");
        //json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }

    protected void jQuerySerialize(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("jQuery的jQuerySerialize过来了");

        //怎么知道serialize成功了？
        System.out.println("用户名："+req.getParameter("username"));
        System.out.println("密码："+req.getParameter("password"));
        Person person = new Person(1, "过");
        //json格式的字符串
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        resp.getWriter().write(personJsonString);
    }
}
