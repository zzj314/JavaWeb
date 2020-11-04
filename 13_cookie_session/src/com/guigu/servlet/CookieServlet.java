package com.guigu.servlet;

import com.guigu.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends  BaseServlet{


    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建一个Path路径的Cookie");
    }

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建一个要修改的同名的Cookie对象
        //2.在构造器，同时赋予新的Cookie对象
        /*Cookie cookie = new Cookie("key4", "newValue1");
        //3.调用response.addCookie(Cookie)
        resp.addCookie(cookie);
        resp.getWriter().write("key1的Cookie已经修改好");*/
        Cookie cookie = CookieUtils.findCookie("key5", req.getCookies());
        if (cookie!=null){
            cookie.setValue("newValue5");
            resp.addCookie(cookie);
        }
        resp.getWriter().write("key1的Cookie已经修改好");
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("life3600", "life3600");
        cookie.setMaxAge(60*60);
        resp.addCookie(cookie);
        resp.getWriter().write("已经创建了一个小时的cookie");
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("key4", req.getCookies());
        if (cookie!=null){
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
            resp.getWriter().write("key4的Cookie已经删除");
        }
    }

    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);

    }

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        //Cookie iwantCookie = null;
        /*for (Cookie cookie :
                cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");
            if ("key4".equals(cookie.getName())){
                iwantCookie = cookie;
            }
        }*/
        for (Cookie cookie :
                cookies) {
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "]<br/>");

        }
        //Cookie iwantCookie = null;
        Cookie iwantCookie = CookieUtils.findCookie("key4", cookies);
        /*for (Cookie cookie : cookies) {
            if ("key4".equals(cookie.getName())){
                iwantCookie = cookie;
                break;
            }
        }*/

        if (iwantCookie != null){
            resp.getWriter().write("找到了需要的cookie");
        }
    }

    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.创建Cookie对象
        Cookie cookie = new Cookie("key4", "value4");
        //2.通知客户端保存Cookie
        resp.addCookie(cookie);
        //3.创建Cookie对象
        Cookie cookie1 = new Cookie("key5", "value5");
        //4.通知客户端保存cookie
        resp.addCookie(cookie1);
        resp.getWriter().write("cookie创建成功");
    }
}
