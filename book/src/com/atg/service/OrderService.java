package com.atg.service;

import com.atg.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart,Integer userId);
}
