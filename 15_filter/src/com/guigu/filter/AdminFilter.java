package com.guigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    public AdminFilter() {
        System.out.println("1.filter构造器方法");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("2.filter初始化方法");
        //1.获取Filter的名称filter-name的内容
        System.out.println(filterConfig.getFilterName());
        //2.在web.xml中配置init.param的初始化参数
        System.out.println("初始化username"+filterConfig.getInitParameter("username"));
        System.out.println("初始化url的参数："+filterConfig.getInitParameter("url"));
        //3.获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("3.doFilter的方法");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("4.销毁的方法");
    }
}
