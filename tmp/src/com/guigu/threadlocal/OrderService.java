package com.guigu.threadlocal;

public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        //System.out.println("当前线程中保存的数据是："+ThreadLocalTest.data.get(name));
        System.out.println("当前线程中保存的数据是："+ThreadLocalTest.threadLocal.get());
    }
}
