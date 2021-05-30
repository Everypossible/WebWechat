package com.crs.dao.impl;

import com.crs.dao.RoomDao;
import com.crs.entity.Message;
import com.crs.entity.Room;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 12:21
 */
public class RoomDaoImpl extends BaseDao<Room> implements RoomDao {
    @Override
    public int createRoom(Room room) {
        String sql = "insert into room(roomId,roomNickname,createTime,ownerNickname)values(?,?,?,?)";
        int flag = update(sql, room.getRoomId(), room.getRoomNickname(), room.getCreateTime(), room.getOwnerNickname());
        return flag;
    }

    @Override
    public Room queryRoomByRoomNickname(String roomNickname) {
        String sql = "select roomNickname from room where roomNickname = ?";
        Room room = (Room) getInstance(sql, roomNickname);
        return room;
    }
}
