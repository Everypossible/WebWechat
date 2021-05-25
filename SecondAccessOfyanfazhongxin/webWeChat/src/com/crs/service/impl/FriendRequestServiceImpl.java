package com.crs.service.impl;

import com.crs.dao.FriendRequestDao;
import com.crs.dao.impl.FriendRequestDaoImpl;
import com.crs.entity.FriendRequest;
import com.crs.service.FriendRequestService;

import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 22:17
 */
public class FriendRequestServiceImpl implements FriendRequestService {
    private FriendRequestDao friendRequestDao = new FriendRequestDaoImpl();
    @Override
    public int addFriendRequest(FriendRequest friendRequest) {
        return friendRequestDao.createFriendRequest(friendRequest);
    }

    @Override
    public List queryFriendRequestByNickname(String nickname) {
        return friendRequestDao.queryRequestByReceiverNickname(nickname);
    }

    @Override
    public Integer updateFriendRequest(String senderNickname, String receiverNickname) {
        return friendRequestDao.updateRequestStateById(senderNickname, receiverNickname);
    }
}

