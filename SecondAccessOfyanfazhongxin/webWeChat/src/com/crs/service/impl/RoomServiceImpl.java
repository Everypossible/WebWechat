package com.crs.service.impl;

import com.crs.dao.RoomDao;
import com.crs.dao.impl.RoomDaoImpl;
import com.crs.entity.Room;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 12:49
 */
public class RoomServiceImpl implements com.crs.service.RoomService {

    private RoomDao roomDao = new RoomDaoImpl();
    @Override
    public int createRoom(Room room) {
        return roomDao.createRoom(room);
    }

    @Override
    public int isExistRoom(String roomNickname) {
        if (roomDao.queryRoomByRoomNickname(roomNickname) == null){
            return 0;
        } else {
            return 1;
        }
    }
}

