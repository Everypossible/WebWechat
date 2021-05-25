package com.crs.service;

import com.crs.entity.BlackFriend;
import com.crs.entity.Friends;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-11 21:56
 */
public interface FriendsService {
    /**
     * 查询用户所有的好友
     * @param userId
     * @return
     */
    public List showAllFriends(Integer userId);

    /**
     * 将好友昵称加进黑名单
     * @param blackFriend
     * @return
     */
    public int deFriend(BlackFriend blackFriend);

    /**
     * 从friends表中删除好友
     * @param nickname
     * @return
     */
    public int deleteFriendByNickname(String nickname);

    /**
     * 添加好友
     * @param friend
     * @return
     */
    public int saveFriend(Friends friend);
}
