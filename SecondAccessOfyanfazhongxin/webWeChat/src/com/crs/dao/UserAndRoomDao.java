package com.crs.dao;

import com.crs.dao.impl.BaseDao;
import com.crs.entity.User;
import com.crs.entity.UserAndRoom;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-19 12:52
 */
public interface UserAndRoomDao {
    /**
     * 增加用户和群的关系
     * @param userAndRoom
     * @return
     */
    public int createUserAndRoom(UserAndRoom userAndRoom);

    /**
     * 根据群昵称查找出所有群成员的昵称
     * @param roomName
     * @return
     */
    public List queryRoomMemberByRoomName(String roomName);

    /**
     * 根据用户名查找其参与的群聊
     * @param memberNickname
     * @return
     */
    public List queryRoomsByMemberNickname(String memberNickname);
}
