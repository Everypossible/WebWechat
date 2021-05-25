package com.crs.dao;

import com.crs.entity.Friends;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-09 22:06
 */
public interface FriendsDao {
    /**
     * 添加好友
     * @param friend
     * @return
     */
    public int saveFriend(Friends friend);

    /**
     * 根据本人id查找本人的好友
     * @param userId
     * @return
     */
    public List queryAllFriendsIdByUserId(int userId);

    /**
     * 删除好友
     * @param nickname
     * @return
     */
    public int deleteFriendByNickname(String nickname);

}
