package com.crs.dao.impl;

import com.crs.dao.BlackFriendDao;
import com.crs.entity.BlackFriend;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-23 8:25
 */
public class BlackFriendDaoImpl extends BaseDao<BlackFriend> implements BlackFriendDao {
    @Override
    public int createOneBlackRecord(BlackFriend blackFriend) {
        String sql = "insert into blackfriend(friendNickname)values(?)";
        int flag = update(sql, blackFriend.getFriendNickname());
        return flag;
    }

    @Override
    public int deleteOneBlackRecordByNickname(String frienedNickname) {
        String sql = "delete from blackfriend where friendNickname=?";
        int flag = update(sql, frienedNickname);
        return flag;
    }

    @Override
    public BlackFriend queryOneBlackRecord(BlackFriend blackFriend) {
        return null;
    }
}

