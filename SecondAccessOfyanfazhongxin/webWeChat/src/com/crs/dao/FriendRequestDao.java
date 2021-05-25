package com.crs.dao;

import com.crs.entity.FriendRequest;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-19 22:11
 */
public interface FriendRequestDao {
    /**
     * 增加一条请求记录
     * @param friendRequest
     * @return
     */
    public int createFriendRequest(FriendRequest friendRequest);

    /**
     * 根据接收者的昵称查询好友申请
     * @param ReceiverNickname
     * @return
     */
    public List queryRequestByReceiverNickname(String ReceiverNickname);

    /**
     * 根据申请记录的发送者和接收者共同来判断更新哪个记录的状态为1
     * @param sender
     * @param receiver
     * @return
     */
    public int updateRequestStateById(String sender, String receiver);
}
