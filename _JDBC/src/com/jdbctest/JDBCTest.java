package com.jdbctest;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try{
            //1、注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取连接
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root");
            //3、创建数据库操作对象
            stmt = conn.createStatement();
            //4、执行sql
            String sql = "select username,password,email from t_user";
            rs = stmt.executeQuery(sql);
            //5、处理查询结果集
            while (rs.next()){
                String username = rs.getString("username");
                String password = rs.getString("password");
                String email = rs.getString("email");
                System.out.println(username+","+password+","+email);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //6、释放资源
            if (rs != null){
                try {
                    rs.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (stmt != null){
                try {
                    stmt.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if (conn != null){
                try {
                    conn.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }
}
