package com.crs.dao.impl;

import com.crs.dao.FriendRequestDao;
import com.crs.entity.FriendRequest;
import com.crs.entity.Message;

import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 22:11
 */
public class FriendRequestDaoImpl extends BaseDao<FriendRequest> implements FriendRequestDao {
    @Override
    public int createFriendRequest(FriendRequest friendRequest) {
        String sql = "insert into friendsrequest(id,senderName,receiverName,state)values(?,?,?,?)";
        int flag = update(sql, friendRequest.getId(), friendRequest.getSenderName(), friendRequest.getReceiverName(),friendRequest.getState());
        return flag;
    }

    @Override
    public List queryRequestByReceiverNickname(String ReceiverNickname) {
        String sql = "select * from friendsrequest where receiverName=? and state=0";
        List<FriendRequest> RequestList = (List<FriendRequest>) getForList(sql, ReceiverNickname);
        return RequestList;
    }

    @Override
    public int updateRequestStateById(String sender, String receiver) {
        String sql = "update friendsrequest set state=? where senderName=? and receiverName=?";
        int flag = update(sql, 1, sender, receiver);
        return flag;
    }
}

