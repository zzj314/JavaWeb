package com.guigu.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class RegistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        String code = req.getParameter("code");
        //获取用户名
        String username = req.getParameter("username");

        if (token != null && token.equalsIgnoreCase(code)) {
            System.out.println("保存到数据库:" + username);
            resp.sendRedirect(req.getContextPath() + "/ok.jsp");
            //req.getRequestDispatcher("/ok.jsp").forward(req, resp);
        }
        /*try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        else {
            System.out.println("不用重复提交表单");
        }
    }
}
