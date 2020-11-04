package servletEdit;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        //注意是重写有参数的init时，要将父类的方法给
        //调用了，否则没有实例化config对象
        //父类中的private transient ServletConfig config;
        super.init(config);
        System.out.println("初始化");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method+"方法");
        ServletConfig servletConfig = getServletConfig();
        System.out.println(servletConfig);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method+"方法");
    }
}
