package com.it.test;

import com.it.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {

    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 3; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
