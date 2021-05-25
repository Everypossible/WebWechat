package com.crs.dao.impl;

import com.crs.dao.UserDao;
import com.crs.dao.UserDetailsDao;
import com.crs.entity.Friends;
import com.crs.entity.UserDetails;

import java.util.List;

/**
 * @author RS
 * @Description: UserDetailsDao的实现类
 * @create 2021-04-29 8:07
 */
public class UserDetailsDaoImpl extends BaseDao<UserDetails> implements UserDetailsDao {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public UserDetails queryUserDetailsByUserId(Integer userId) {
        String sql = "select id, headPortrait, nickname, sex, birth, userAddr, userDesc, createTime, userId from userdetails where userId=?";
        UserDetails userDetails = (UserDetails) getInstance(sql, userId);
        return userDetails;
    }

    @Override
    public int saveUserDetails(UserDetails userDetails) {
        String sql = "insert into userdetails(id, headPortrait, nickname, sex, birth, userAddr, userDesc, createTime, userId)values(?,?,?,?,?,?,?,?,?)";
        int flag = update(sql, userDetails.getId(), userDetails.getheadPortrait(), userDetails.getNickname(), userDetails.getSex(), userDetails.getBirth(),
                userDetails.getUserAddr(), userDetails.getUserDesc(), userDetails.getCreateTime(), userDetails.getUserId());
        return flag;
    }

    @Override
    public List queryUserDetailsBySearchNickname(String searchNickname) {
        String sql = "select * from userdetails where nickname like ?";
        List<UserDetails> userDetails =  (List<UserDetails>) getForList(sql, "%"+searchNickname+"%");
        return userDetails;
    }

    @Override
    public UserDetails queryUserDetailsByNickname(String nickname) {
        String sql = "select id, headPortrait, nickname, sex, birth, userAddr, userDesc, createTime, userId from userdetails where nickname=?";
        UserDetails userDetails = (UserDetails) getInstance(sql, nickname);
        return userDetails;
    }
}

