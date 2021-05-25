package com.crs.dao;

import com.crs.entity.UserDetails;

import java.util.List;

/**
 * @Description: UserDetails类的Dao层接口
 * @author RS
 * @create 2021-04-29 7:51
 */
public interface UserDetailsDao {
    /**
     * 通过userId查找对应的UserDetails
     * @param userId
     * @return
     */
    public UserDetails queryUserDetailsByUserId(Integer userId);

    /**
     * 保存用户详细信息
     * @param userDetails
     * @return
     */
    public int saveUserDetails(UserDetails userDetails);

    /**
     * 通过昵称模糊查询用户
     * @param searchNickname
     * @return
     */
    public List queryUserDetailsBySearchNickname(String searchNickname);

    /**
     * 根据昵称查找用户详情
     * @param nickname
     * @return
     */
    public UserDetails queryUserDetailsByNickname(String nickname);
}

