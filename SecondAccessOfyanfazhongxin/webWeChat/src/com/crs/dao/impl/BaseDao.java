package com.crs.dao.impl;

import com.alibaba.druid.util.JdbcUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

/**
 * 封装针对于数据库的通用的操作,泛型T表示操作的表对应的类
 * @author RS
 *
 */
public abstract class BaseDao<T> {
    //用DbUtils操作数据库

    private Class<T> clazz;

    /**
     * 获取当前BaseDao的子类继承的父类中的泛型
     */
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;

        //获取父类的泛型参数
        Type[] typeArguments = paramType.getActualTypeArguments();
        //泛型的第一个参数
        clazz = (Class<T>) typeArguments[0];
    }

    /**
     * 通用的增删改操作
     * 通用的方法：将变化的放在形参中
     * 区别在于SQL语句和占位符数量
     *
     * @param
     * @return
     */
    public int update(String sql, Object... args) {
        Connection conn = com.crs.utils.JdbcUtils.getConnection();
        PreparedStatement ps = null;
        int flag = 0;
        try {
            //预编译SQL语句，返回PreparedStatement的实例
            ps = conn.prepareStatement(sql);
            //填充占位符(占位符数量与可变形参长度相同)
            for (int i = 0; i < args.length; i++) {
                //SQL语句从1开始，数组从0开始
                ps.setObject(i + 1, args[i]);
            }
            //执行
            flag = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            com.crs.utils.JdbcUtils.close(conn);
            JdbcUtils.close(ps);
        }
        return flag;
    }

    /**
     * 通用的查询操作，用于返回数据表中的一条记录
     */
    public T getInstance(String sql, Object... args) {
        Connection conn = com.crs.utils.JdbcUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetmetadata获取结果集中的列数
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //给t对象指定的columnName属性，赋值columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.crs.utils.JdbcUtils.close(conn);
            JdbcUtils.close(ps);
            JdbcUtils.close(rs);
        }
        return null;
    }

    /**
     * 通用的查询操作，用于返回数据表中的多条记录构成的集合
     */
    public List<T> getForList(String sql, Object... args) {
        Connection conn = com.crs.utils.JdbcUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //通过ResultSetmetadata获取结果集中的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list = new ArrayList<T>();
            while (rs.next()) {
                T t = clazz.newInstance();
                //处理结果集一行数据中的每一列
                for (int i = 0; i < columnCount; i++) {
                    //获取列值
                    Object columnValue = rs.getObject(i + 1);
                    //获取每个列的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //给t对象指定的columnName属性，赋值columnValue，通过反射
                    Field field = clazz.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            com.crs.utils.JdbcUtils.close(conn);
            JdbcUtils.close(ps);
            JdbcUtils.close(rs);
        }
        return null;
    }

    /**
     * 获取一些表的统计数据(如：count(*))
     */
    public <E> E getValue(String sql, Object... args) {
        Connection conn = com.crs.utils.JdbcUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return (E) rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            com.crs.utils.JdbcUtils.close(conn);
            JdbcUtils.close(ps);
            JdbcUtils.close(rs);
        }
        return null;
    }
}

