package com.crs.service.impl;

import com.crs.dao.UserDao;
import com.crs.dao.UserDetailsDao;
import com.crs.dao.impl.UserDaoImpl;
import com.crs.dao.impl.UserDetailsDaoImpl;
import com.crs.entity.User;
import com.crs.entity.UserDetails;
import com.crs.service.UserDetailsService;

import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-06 21:09
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();

    @Override
    public void userDetailsRegister(UserDetails userDetails) {
        userDetailsDao.saveUserDetails(userDetails);
    }

    @Override
    public List queryUserDetailsByVagueNickname(String vagueNickname) {
        List<UserDetails> userDetailsList = userDetailsDao.queryUserDetailsBySearchNickname(vagueNickname);
        return userDetailsList;
    }

    @Override
    public UserDetails queryUserDetailsByUserId(Integer userId) {
        return userDetailsDao.queryUserDetailsByUserId(userId);
    }

    @Override
    public boolean existsNickname(String nickname) {
        if (userDetailsDao.queryUserDetailsByNickname(nickname) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public UserDetails queryUserDetailsByNickname(String nickname) {
        return userDetailsDao.queryUserDetailsByNickname(nickname);
    }

}

