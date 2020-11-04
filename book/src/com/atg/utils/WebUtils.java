package com.atg.utils;

import org.apache.commons.beanutils.BeanUtils;
import java.util.Map;

public class WebUtils {
//    public static void  copyParamToBean(HttpServletRequest req,Object bean){
    /*
    为什么要改？
    因为DAO和Service层没有HttpServletRequest
    Web层才有，会耦合给DAO和Service层
    而Map的话，大家都有
     */
//    public static Object  copyParamToBean(Map value, Object bean){
    public static <T>  T  copyParamToBean(Map value, T bean){
        try {
            //User user = new User();
            //System.out.println("注入之前"+bean);//测试代码
//            BeanUtils.populate(user, req.getParameterMap());
            BeanUtils.populate(bean, value);
           /* System.out.println("注入之后:"+user);*/
        } catch (Exception e) {
            e.printStackTrace();
        }
        //修改
        return bean;
    }
    /*
    将字符串转为int
     */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        //} catch (NumberFormatException e) {
        } catch (Exception e) {
         // e.printStackTrace();
        }
        return defaultValue;
    }
}
