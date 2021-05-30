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

    /**
     * 根据群昵陈判断是否存在群
     * @param roomNickname
     * @return 返回1表示存在该群, 返回0表示不存在该群
     */
    public int isExistRoom(String roomNickname);
}
