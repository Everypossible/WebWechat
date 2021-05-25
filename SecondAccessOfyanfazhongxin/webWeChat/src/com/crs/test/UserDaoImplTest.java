package com.crs.test;

import com.crs.dao.UserDao;
import com.crs.dao.impl.UserDaoImpl;
import com.crs.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-05-09 15:55
 */
public class UserDaoImplTest {
    UserDao userDao = new UserDaoImpl();
    @Test
    public void queryUserByUsername() {
    }

    @Test
    public void saveUser() {
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        User user = userDao.queryUserByUsernameAndPassword("abc", "123");
        System.out.println(user);
    }
}