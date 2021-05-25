package com.crs.dao;

import com.crs.entity.Room;

/**
 * @author shkstart
 * @create 2021-05-19 12:16
 */
public interface RoomDao {
    /**
     * 增加一个群
     * @param room
     * @return
     */
    public int createRoom(Room room);
}
