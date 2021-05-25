package com.crs.test;

import com.crs.dao.UserDetailsDao;
import com.crs.dao.impl.UserDetailsDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-05-12 19:51
 */
public class UserDetailsDaoImplTest {
    UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();

    @Test
    public void queryUserDetailsByUserId() {
    }

    @Test
    public void saveUserDetails() {
    }

    @Test
    public void queryUserDetailsBySearchNicknameInfo() {
        System.out.println(userDetailsDao.queryUserDetailsByUserId(2).toString());
    }
}