package com.crs.dao.impl;

import com.crs.dao.FriendsDao;
import com.crs.entity.Friends;
import com.crs.entity.User;

import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-09 22:10
 */
public class FriendsDaoImpl extends BaseDao<Friends> implements FriendsDao {
    @Override
    public int saveFriend(Friends friend) {
        String sql = "insert into friends(fUserId,fFriendId,fFriendNickname)values(?,?,?)";
        int flag = update(sql, friend.getfUserId(), friend.getfFriendId(), friend.getfFriendNickname());
        return flag;
    }

    @Override
    public List queryAllFriendsIdByUserId(int userId) {
        String sql = "select * from friends where fUserId = ?";
        List<Friends> friends =  (List<Friends>) getForList(sql, userId);
        return friends;
    }

    @Override
    public int deleteFriendByNickname(String nickname) {
        String sql = "delete from friends where fFriendNickname=?";
        int flag = update(sql, nickname);
        return flag;
    }

}

