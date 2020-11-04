package com.atg.test;

import com.atg.dao.OrderItemDao;
import com.atg.dao.impl.OrderItemDaoImpl;
import com.atg.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();

        orderItemDao.saveOrderItem(new OrderItem(null, "java从入门到精通", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "javaScript 从入门到精", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
        orderItemDao.saveOrderItem(new OrderItem(null, "Netty 入门", 1, new BigDecimal(100), new BigDecimal(100), "1234567890"));
    }
}