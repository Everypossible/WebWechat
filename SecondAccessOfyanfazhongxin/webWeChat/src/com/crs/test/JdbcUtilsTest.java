package com.crs.test;

import com.crs.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

/**
 * @Description: TODO
 * @outhor RS
 * @create 2021-04-24 18:32
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        for (int i = 0; i < 100; i++) {
            Connection conn = JdbcUtils.getConnection();
            System.out.println(conn);
            JdbcUtils.close(conn);
        }


    }
}

