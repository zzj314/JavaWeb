package com.atg.dao.impl;

import com.atg.dao.OrderItemDao;
import com.atg.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {

        System.out.println("OrderServlet程序在["+Thread.currentThread().getName()+"]");


        String sql = "insert into t_order_item(name,count,price,total_price,order_id) values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(), orderItem.getOrderId());
    }
}
