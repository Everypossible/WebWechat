package com.crs.service;

import com.crs.entity.Room;

/**
 * @author shkstart
 * @create 2021-05-19 12:48
 */
public interface RoomService {

    /**
     * 创建群聊
     * @param room
     * @return
     */
    public int createRoom(Room room);
}
