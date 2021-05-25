package com.crs.service;

import com.crs.entity.User;
import com.crs.entity.UserAndRoom;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-19 12:58
 */
public interface UserAndRoomService {
    /**
     * 插入群成员和群的联系
     * @param userAndRoom
     * @return
     */
    public int addUserAndRoom(UserAndRoom userAndRoom);

    /**
     * 根据群昵称查找群成员
     * @param roomName
     * @return
     */
    public List queryRoomMemberByRoomName(String roomName);

    /**
     * 根据用户昵称查找其参与的群聊
     * @param userNickname
     * @return 参与的群聊的群名称
     */
    public List queryMyJoinRoomsNameByUserNickname(String userNickname);
}
