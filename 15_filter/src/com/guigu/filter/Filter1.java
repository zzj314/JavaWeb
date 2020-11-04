package com.guigu.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter1的前置代码");
        System.out.println(Thread.currentThread().getName());
        chain.doFilter(request, response);
        System.out.println("Filter1的后置代码");
    }

    @Override
    public void destroy() {

    }
}
