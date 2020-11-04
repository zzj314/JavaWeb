package com.atg.dao.impl;

import com.atg.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * update()方法用来执行insert,update,delete语句
     * @param sql
     * @param args
     * @return 如果返回-1，
     */
    public int update(String sql, Object... args) {

        System.out.println("BaseDao程序在["+Thread.currentThread().getName()+"]");


        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/* finally {
            JdbcUtils.close(connection);
        }*/
        //return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally {
            JdbcUtils.close(con);
        }
        return null;*/
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection con = JdbcUtils.getConnection();
        try {
            return queryRunner.query(con, sql, new BeanListHandler<T>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally {
            JdbcUtils.close(con);
        }
        return null;*/
    }

    /**
     * 执行返回一行一列的sql语句
     * @param sql
     * @param args
     * @return
     */
    public Object queryForSingleValue(String sql,Object... args){
        Connection conn = JdbcUtils.getConnection();

        try {
           return queryRunner.query(conn,sql, new ScalarHandler(),args);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }/*finally {
            JdbcUtils.close(conn);
        }
        return null;*/
    }

}
