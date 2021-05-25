package com.crs.entity;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-23 8:17
 */
public class BlackFriend {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 黑名单的好友昵称
     */
    private String friendNickname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFriendNickname() {
        return friendNickname;
    }

    public void setFriendNickname(String friendNickname) {
        this.friendNickname = friendNickname;
    }

    public BlackFriend() {
    }

    public BlackFriend(Integer id, String friendNickname) {
        this.id = id;
        this.friendNickname = friendNickname;
    }

    @Override
    public String toString() {
        return "BlackList{" +
                "id=" + id +
                ", friendNickname='" + friendNickname + '\'' +
                '}';
    }
}

