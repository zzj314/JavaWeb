package com.atg.web;

import com.atg.pojo.Cart;
import com.atg.pojo.User;
import com.atg.service.OrderService;
import com.atg.service.impl.OrderServiceImpl;
import com.atg.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet {
    private OrderService orderService = new OrderServiceImpl();

    //生成订单

    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取Cart购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        //获取Userid
        User loginUser = (User)req.getSession().getAttribute("user");
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        System.out.println("OrderServlet程序在["+Thread.currentThread().getName()+"]");

        Integer userId = loginUser.getId();
        //生成订单
        String orderId = orderService.createOrder(cart, userId);
        /*try {
            orderId = orderService.createOrder(cart, userId);
            JdbcUtils.commitAndClose();//提交事务
        } catch (Exception e) {
            JdbcUtils.rollbackAndClose();
            e.printStackTrace();
        }*/

        //req.setAttribute("orderId", orderId);
        //req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
