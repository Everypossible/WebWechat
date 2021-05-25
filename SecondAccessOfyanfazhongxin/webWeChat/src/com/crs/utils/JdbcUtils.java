package com.crs.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Description: 使用Druid数据库连接池技术
 * @author RS
 * @create 2021-04-24 17:25
 */
public class JdbcUtils {
    private static DruidDataSource dataSource;
    static{
        try {
            //读取配置文件
            Properties properties = new Properties();
            //从流中获取数据
//            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            //创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
//            System.out.println("这没问题"+dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取数据库连接
     * @return 如果返回null，说明获取失败;有值则获取连接成功
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭连接，将连接放回数据库连接池
     */
    public static void close(Connection conn) {
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

