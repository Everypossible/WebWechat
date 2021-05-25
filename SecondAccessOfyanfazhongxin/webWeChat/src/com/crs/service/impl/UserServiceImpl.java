package com.crs.service.impl;

import com.crs.dao.UserDao;
import com.crs.dao.impl.UserDaoImpl;
import com.crs.entity.User;
import com.crs.service.UserService;

/**
 * @Description: TODO
 * @outhor RS
 * @create 2021-04-25 15:15
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao= new UserDaoImpl();
    @Override
    public int userRegister(User user) {
        return userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String userName) {
        if (userDao.queryUserByUsername(userName) == null){
            //等于null，表示没查到，则该用户名未被注册
            return false;
        }
        return true;
    }

    @Override
    public Integer queryUserIdByUsername(String username) {
        return userDao.queryUserByUsername(username).getId();
    }

    @Override
    public int updatePasswordByUsername(String username, String password) {
        return userDao.updatePasswordByNickname(username, password);
    }
}

