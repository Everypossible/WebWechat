package com.crs.dao.impl;

import com.crs.dao.UserAndRoomDao;
import com.crs.entity.UserAndRoom;
import com.crs.entity.UserDetails;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 12:54
 */
public class UserAndRoomDaoImpl extends BaseDao<UserAndRoom> implements UserAndRoomDao {
    @Override
    public int createUserAndRoom(UserAndRoom userAndRoom) {
        String sql = "insert into userandroom(id,memberNickname,roomName)values(?,?,?)";
        int flag = update(sql, userAndRoom.getId(), userAndRoom.getMemberNickname(), userAndRoom.getRoomName());
        return flag;
    }

    @Override
    public List queryRoomMemberByRoomName(String roomName) {
        String sql = "select * from userandroom where roomName=?";
        List<UserAndRoom> sameRoomList = (List<UserAndRoom>) getForList(sql, roomName);
        List<String> membersList = new ArrayList<>();
        for (UserAndRoom userAndRoom : sameRoomList){
            membersList.add(userAndRoom.getMemberNickname());
        }
        return membersList;
    }

    @Override
    public List queryRoomsByMemberNickname(String memberNickname) {
        String sql = "select * from userandroom where memberNickname=?";
        List<UserAndRoom> roomsList = (List<UserAndRoom>) getForList(sql, memberNickname);
        List<String> roomsNameList = new ArrayList<>();
        for (UserAndRoom userAndRoom : roomsList){
            roomsNameList.add(userAndRoom.getRoomName());
        }
        return roomsNameList;
    }
}

