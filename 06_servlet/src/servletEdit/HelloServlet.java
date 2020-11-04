package servletEdit;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet implements Servlet {
    public HelloServlet(){
        System.out.println("构造方法");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化了");
        String servletName = servletConfig.getServletName();
        System.out.println(servletName);
        System.out.println(servletConfig.getInitParameter("username"));
        System.out.println(servletConfig.getInitParameter("url"));
        //org.apache.catalina.core.ApplicationContextFacade@1ddaaae2
        System.out.println(servletConfig.getServletContext());

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //System.out.println("被访问了");
        HttpServletRequest hs = (HttpServletRequest)servletRequest;
        String method = hs.getMethod();
//        System.out.println(method);
        if ("GET".equals(method)){
            System.out.println("get");
        }else if ("POST".equals(method)){
            System.out.println("post");
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("销毁了");
    }
}
