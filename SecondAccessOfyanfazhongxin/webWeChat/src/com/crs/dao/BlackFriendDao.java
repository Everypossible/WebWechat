package com.crs.dao;

import com.crs.entity.BlackFriend;

/**
 * @author shkstart
 * @create 2021-05-23 8:20
 */
public interface BlackFriendDao {
    /**
     * 增加一条黑名单
     * @param blackFriend
     * @return
     */
    public int createOneBlackRecord(BlackFriend blackFriend);

    /**
     * 删除一条黑名单
     * @param frienedNickname
     * @return
     */
    public int deleteOneBlackRecordByNickname(String frienedNickname);

    /**
     * 查找一条黑名单记录
     * @param blackFriend
     * @return
     */
    public BlackFriend queryOneBlackRecord(BlackFriend blackFriend);
}
