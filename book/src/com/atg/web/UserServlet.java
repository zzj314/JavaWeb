package com.atg.web;

import com.atg.pojo.User;
import com.atg.service.UserService;
import com.atg.service.impl.UserServiceImpl;
import com.atg.utils.WebUtils;
import com.google.gson.Gson;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

//public class UserServlet extends HttpServlet {
public class UserServlet extends BaseServlet {
    private  UserService userService = new UserServiceImpl();


    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求
        String username = req.getParameter("username");
        boolean existsUsername = userService.existsUsername(username);
        //
        Map<String ,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        resp.getWriter().write(json);
    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.销毁session用户登录的信息
        req.getSession().invalidate();
        //2.重定向到首页
        resp.sendRedirect(req.getContextPath());
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//        System.out.println(action);

            //1.获取请求的参数
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            //调用service处理业务
            User loginUser = userService.login(new User(null, username, password, null));
            if (loginUser == null){
                //如果等于null，登录失败
                //错误信息显示
                req.setAttribute("msg", "用户名或密码错误!" );
                req.setAttribute("username", username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            }else {
                //登录成功
                //跳转到登录成功页面
                req.getSession().setAttribute("user", loginUser);
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);


        //1.获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        //ctrl+alt+t 以下写成工具类
/*        try {
            User user = new User();
            System.out.println("注入之前"+user);
            BeanUtils.populate(user, req.getParameterMap());
            System.out.println("注入之后:"+user);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //User user = new User();
  /* 测试代码
   Map<String ,String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String ,String[]> entry:
             parameterMap.entrySet()) {
            System.out.println(entry.getKey()+"="+ Arrays.asList(entry.getValue()));
        }*/
//        WebUtils.copyParamToBean(req, user);
//        WebUtils.copyParamToBean(req.getParameterMap(), user);
//       User user = (User) WebUtils.copyParamToBean(req.getParameterMap(), new User());
//       User user = (User) WebUtils.copyParamToBean(req.getParameterMap(), new User());
       User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());

        //2.检查验证码是否正确
        //if ("abcde".equalsIgnoreCase(code)){
        if (token!=null&&token.equalsIgnoreCase(code)){
            //3.检查用户名是否可用
            if (userService.existsUsername(username)){
                req.setAttribute("msg","用户名已存在！");
                req.setAttribute("username", username);
                req.setAttribute("email",email);
                //不可以，跳回注册页面
               // System.out.println("用户名["+username+"]已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            }else {
                //可用，调用service保存到数据库
                userService.registUser(new User(null, username, password, email));
                //跳到注册成功页面
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }

        }else {
            req.setAttribute("msg","验证码错误！");
            req.setAttribute("username", username);
            req.setAttribute("email",email);

            //跳回注册页面
           // System.out.println("验证码["+code+"]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }

  //  @Override
 //   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        String action = req.getParameter("action");
//        if ("login".equals(action)){
//            login(req, resp);
//        }else if("regist".equals(action)){
//            regist(req, resp);
//        }
        try {
            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
            System.out.println(method);
//            method.invoke(new UserServletTest(),req,resp);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    //}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
