package com.atg.test;

import com.atg.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
        //要及时释放
            JdbcUtils.close(connection);
        }
    }
}
