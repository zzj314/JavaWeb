package com.atg.service.impl;

import com.atg.dao.BookDao;
import com.atg.dao.OrderDao;
import com.atg.dao.OrderItemDao;
import com.atg.dao.impl.BookDaoImpl;
import com.atg.dao.impl.OrderDaoImpl;
import com.atg.dao.impl.OrderItemDaoImpl;
import com.atg.pojo.*;
import com.atg.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {
        //订单号唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        orderDao.saveOrder(order);

        int i = 12 / 0;

        for (Map.Entry<Integer, CartItem> entry:cart.getItems().entrySet()){
            //获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //转换为每一个订单项
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(),
                    cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //保存订单到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()-cartItem.getCount());
            bookDao.updateBook(book);
        }
        //清空购物车
        cart.clear();
        return orderId;
    }
}
