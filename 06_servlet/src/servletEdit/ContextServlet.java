package servletEdit;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //调用自己的方法，不用实例化，从父类继承过来的
        //System.out.println(getServletConfig().getServletName());
        ServletContext context = getServletConfig().getServletContext();
        System.out.println(context.getInitParameter("username"));
        System.out.println(context.getInitParameter("password"));
        System.out.println(context.getRealPath("/"));
        System.out.println(context.getRealPath("/css"));
        System.out.println(context.getRealPath("/imgs/2.jpg"));


    }
}
