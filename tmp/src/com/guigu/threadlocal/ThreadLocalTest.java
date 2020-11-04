package com.guigu.threadlocal;

import java.util.Hashtable;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {

    //public final static Map<String,Object> data = new ConcurrentHashMap<>();
    //public final static Map<String,Object> data = new Hashtable<>();
    public static ThreadLocal<Object> threadLocal = new ThreadLocal<>();
    private static Random random = new Random();

    public static class Task implements Runnable{

        @Override
        public void run() {
            //在Run方法中
            Integer i = random.nextInt(1001);
            //线程名字
            String name = Thread.currentThread().getName();
            System.out.println("线程["+name+"]生成的随机数："+i);
            //data.put(name, i);
            threadLocal.set(i);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new OrderService().createOrder();
            //Run方法结束之前，打印
            //Object o = data.get(name);
            Object o = threadLocal.get();
            System.out.println("在线程["+name+"]快结束时取出数据是："+o);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Task()).start();
        }
    }
}
