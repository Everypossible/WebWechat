package com.crs.service;

import com.crs.entity.FriendRequest;
import com.crs.entity.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-19 22:15
 */
public interface FriendRequestService {
    /**
     * 添加一条好友申请
     * @param friendRequest
     * @return
     */
    public int addFriendRequest(FriendRequest friendRequest);

    /**
     * 根据接收者昵称查询好友申请
     * @param nickname
     * @return
     */
    public List queryFriendRequestByNickname(String nickname);

    /**
     * 更新好友申请为同意状态
     * @param senderNickname
     * @param receiverNickname
     * @return
     */
    public Integer updateFriendRequest(String senderNickname, String receiverNickname);
}
