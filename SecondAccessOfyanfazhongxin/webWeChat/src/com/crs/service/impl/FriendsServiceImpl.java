package com.crs.service.impl;

import com.crs.dao.BlackFriendDao;
import com.crs.dao.FriendsDao;
import com.crs.dao.UserDetailsDao;
import com.crs.dao.impl.BlackFriendDaoImpl;
import com.crs.dao.impl.FriendsDaoImpl;
import com.crs.dao.impl.UserDetailsDaoImpl;
import com.crs.entity.BlackFriend;
import com.crs.entity.Friends;
import com.crs.entity.UserDetails;
import com.crs.service.FriendsService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-11 21:57
 */
public class FriendsServiceImpl implements FriendsService {
    private FriendsDao friendsDao = new FriendsDaoImpl();
    private UserDetailsDao userDetailsDao = new UserDetailsDaoImpl();
    private BlackFriendDao blackFriendDao = new BlackFriendDaoImpl();

    @Override
    public List showAllFriends(Integer userId) {
        List<UserDetails> friendsDetailsList = new ArrayList<UserDetails>();
        List<Friends> friends = new ArrayList<Friends>();
        friends = friendsDao.queryAllFriendsIdByUserId(userId);
        //遍历friends
        Iterator<Friends> it = friends.iterator();
        while (it.hasNext()){
            friendsDetailsList.add(userDetailsDao.queryUserDetailsByUserId(it.next().getfFriendId()));
        }
        return friendsDetailsList;
    }

    @Override
    public int deFriend(BlackFriend blackFriend) {
        return blackFriendDao.createOneBlackRecord(blackFriend);
    }

    @Override
    public int deleteFriendByNickname(String nickname) {
        return friendsDao.deleteFriendByNickname(nickname);
    }

    @Override
    public int saveFriend(Friends friend) {
        return friendsDao.saveFriend(friend);
    }
}

