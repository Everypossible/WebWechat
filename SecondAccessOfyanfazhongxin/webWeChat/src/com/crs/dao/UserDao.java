package com.crs.dao;

import com.crs.entity.User;

import java.sql.Connection;

/**
 * @author shkstart
 * @create 2021-04-24 19:09
 */
public interface UserDao {
    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return 如果返回null,说明没有这个用户,反之亦然
     */
    public User queryUserByUsername(String username);

    /**
     * 保存用户信息
     *
     * @param user
     * @return
     */
    public int saveUser(User user);
    /**
     * 根据用户名和密码查询
     * @param username
     * @param password
     * @return 如果返回null,说明用户名或密码错误,反之亦然
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 根据用户邮箱(用户名)更改密码
     * @param nickname
     * @return
     */
    public int updatePasswordByNickname(String nickname, String password);

}