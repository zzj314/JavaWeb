package com.atg.web;

import com.atg.pojo.Book;
import com.atg.pojo.Cart;
import com.atg.pojo.CartItem;
import com.atg.service.BookService;
import com.atg.service.impl.BookServiceImpl;
import com.atg.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {

    BookService bookService = new BookServiceImpl();

    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id),得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.addItem(cartItem)添加商品项,new相当于每次加商品都换一辆车
        //Cart cart = new Cart();
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);
       // System.out.println(cart);
        // System.out.println("referer的值："+req.getHeader("Referer"));
        //重定向回商品列表页面
        //resp.sendRedirect(req.getContextPath());
        //resp.sendRedirect(req.getHeader("Referer"));
        req.getSession().setAttribute("lastName", cartItem.getName());
        resp.sendRedirect(req.getHeader("Referer"));
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart != null) {
            cart.deleteItem(id);
            //重定向回原来购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //
        if (cart != null) {
            cart.clear();
            //重定向回原来的购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }

    }

    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        int count = WebUtils.parseInt(req.getParameter("count"), 1);
        //获取Cart购物车对象
        Cart cart = (Cart)req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id, count);
            //重定向回原来的购物车展示页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数，商品编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //调用bookService.queryBookById(id),得到图书信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成CartItem商品项
        CartItem cartItem = new CartItem(book.getId(), book.getName(), 1, book.getPrice(), book.getPrice());
        //调用cart.addItem(cartItem)添加商品项,new相当于每次加商品都换一辆车
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }
        cart.addItem(cartItem);

        req.getSession().setAttribute("lastName", cartItem.getName());
       //ajax
        Map<String ,Object> resultMap = new HashMap<>();
        resultMap.put("totalCount", cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());

        Gson gson = new Gson();
        String resultMapJsonString = gson.toJson(resultMap);

        resp.getWriter().write(resultMapJsonString);

    }

}
