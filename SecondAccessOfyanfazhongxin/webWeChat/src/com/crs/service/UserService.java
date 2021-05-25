package com.crs.service;

import com.crs.entity.User;

/**
 * @author shkstart
 * @create 2021-04-25 15:04
 */
public interface UserService {
    /**
     * 注册用户
     * @param user
     * @return 返回新插入的用户的主键id
     */
    public int userRegister(User user);

    /**
     * 登录
     * @param user
     * @return 返回null则登录失败，否则代表成功
     */
    public User login(User user);

    /**
     * 检查用户名是否已经存在
     * @return 返回true表示用户名已经存在,false表示不存在
     */
    public boolean existsUsername(String userName);

    /**
     * 通过用户名查找用户主键
     * @param username
     * @return 返回用户主键id
     */
    public Integer queryUserIdByUsername(String username);

    /**
     * 根据邮箱修改密码
     * @param username
     * @param password
     * @return
     */
    public int updatePasswordByUsername(String username, String password);
}
