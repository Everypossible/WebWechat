package com.crs.entity;

import javax.mail.search.IntegerComparisonTerm;

/**
 * @author RS
 * @Description: friends数据库表对应实体类
 * @create 2021-05-09 22:01
 */
public class Friends {
    /**
     * 主键id
     */
    private Integer fId;
    /**
     *本人id
     */
    private Integer fUserId;
    /**
     *好友id
     */
    private Integer fFriendId;
    /**
     *好友昵称
     */
    private String fFriendNickname;

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
    }

    public Integer getfUserId() {
        return fUserId;
    }

    public void setfUserId(Integer fUserId) {
        this.fUserId = fUserId;
    }

    public Integer getfFriendId() {
        return fFriendId;
    }

    public void setfFriendId(Integer fFriendId) {
        this.fFriendId = fFriendId;
    }

    public String getfFriendNickname() {
        return fFriendNickname;
    }

    public void setfFriendNickname(String fFriendNickname) {
        this.fFriendNickname = fFriendNickname;
    }

    public Friends() {
    }

    public Friends(Integer fId, Integer fUserId, Integer fFriendId, String fFriendNickname) {
        this.fId = fId;
        this.fUserId = fUserId;
        this.fFriendId = fFriendId;
        this.fFriendNickname = fFriendNickname;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "fId=" + fId +
                ", fUserId=" + fUserId +
                ", fFriendId=" + fFriendId +
                ", fFriendNickname='" + fFriendNickname + '\'' +
                '}';
    }
}

