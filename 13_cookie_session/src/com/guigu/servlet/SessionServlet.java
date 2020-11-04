package com.guigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void setAtribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("在session中保存了数据");
    }

    protected void getAtribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从session中获取key1的数据是：" + attribute);
    }

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession session = req.getSession();
        //判断当前session会话是否是新的
        boolean isNew = session.isNew();
        //获取session会话唯一标识id
        String id = session.getId();
        resp.getWriter().write("得到的session的id是：" + id + "<br/>");
        resp.getWriter().write("session是新的么：" + isNew + "<br/>");
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长为：" + maxInactiveInterval + "秒");
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取session对象
        HttpSession session = req.getSession();
        //设置当前sessino 3秒后超时
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前session已经设置为3秒后超时");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取session对象
        HttpSession session = req.getSession();
        //session会话马上超时
        session.invalidate();
        resp.getWriter().write("当前session马上销毁");

    }
}
