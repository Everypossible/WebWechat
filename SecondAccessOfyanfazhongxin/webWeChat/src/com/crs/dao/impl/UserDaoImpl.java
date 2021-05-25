package com.crs.dao.impl;

import com.crs.dao.UserDao;
import com.crs.entity.User;

/**
 * @Description: TODO
 * @outhor RS
 * @create 2021-04-24 19:16
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

    @Override
    public User queryUserByUsername(String username) {
        String sql = "select id, username, password from user where username = ?";
        User user = (User)getInstance(sql, username);
        return user;
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into user(username,password,identity)values(?,?,?)";
        int flag = update(sql, user.getUsername(), user.getPassword(), user.getIdentity());
        return flag;
    }

    @Override
    public User queryUserByUsernameAndPassword(String username, String password) {
        String sql = "select id, username, password, identity from user where username = ? and password = ?";
        User user = (User)getInstance(sql, username, password);
        return user;
    }

    @Override
    public int updatePasswordByNickname(String nickname, String password) {
        String sql = "update user set password=? where username=?";
        int flag = update(sql, password, nickname);
        return flag;
    }
}

