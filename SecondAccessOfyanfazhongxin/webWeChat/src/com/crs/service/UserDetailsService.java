package com.crs.service;

import com.crs.entity.UserDetails;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-06 21:07
 */
public interface UserDetailsService {
    /**
     * 将用户详细信息存入数据库
     * @param userDetails
     */
    public void userDetailsRegister(UserDetails userDetails);

    /**
     * 根据昵称模糊搜索用户
     * @param vagueNickname
     * @return
     */
    public List queryUserDetailsByVagueNickname(String vagueNickname);

    /**
     * 通过用户的主键id查询用户详细信息
     * @param userId
     * @return
     */
    public UserDetails queryUserDetailsByUserId(Integer userId);

    /**
     * 判断是否已经存在该昵称的用户
     * @param string
     * @return
     */
    public boolean existsNickname(String string);

    /**
     * 根据用户昵称查询用户详细信息
     * @param nickname
     * @return
     */
    public UserDetails queryUserDetailsByNickname(String nickname);
}
