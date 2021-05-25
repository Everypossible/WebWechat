package com.crs.service.impl;

import com.crs.dao.UserAndRoomDao;
import com.crs.dao.impl.UserAndRoomDaoImpl;
import com.crs.entity.UserAndRoom;
import com.crs.service.UserAndRoomService;

import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 12:59
 */
public class UserAndRoomServiceImpl implements UserAndRoomService {

    private UserAndRoomDao userAndRoomDao = new UserAndRoomDaoImpl();
    @Override
    public int addUserAndRoom(UserAndRoom userAndRoom) {
        return userAndRoomDao.createUserAndRoom(userAndRoom);
    }

    @Override
    public List queryRoomMemberByRoomName(String roomName) {
        return userAndRoomDao.queryRoomMemberByRoomName(roomName);
    }

    @Override
    public List queryMyJoinRoomsNameByUserNickname(String userNickname) {
        return userAndRoomDao.queryRoomsByMemberNickname(userNickname);
    }
}

