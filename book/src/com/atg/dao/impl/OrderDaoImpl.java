package com.atg.dao.impl;

import com.atg.dao.OrderDao;
import com.atg.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {


    @Override
    public int saveOrder(Order order) {

        System.out.println("OrderDaoImpl程序在["+Thread.currentThread().getName()+"]");


        String sql = "insert into t_order(order_id,create_time, " +
                "price,status,user_id)values(?,?,?,?,?)";
        return update(sql, order.getOrderId(),
                order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
