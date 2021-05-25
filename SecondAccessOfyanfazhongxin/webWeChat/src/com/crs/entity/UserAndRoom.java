package com.crs.entity;

/**
 * @author RS
 * @Description: 建立用户(群成员)和群的联系
 * @create 2021-05-19 11:57
 */
public class UserAndRoom {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 群成员昵称
     */
    private String memberNickname;
    /**
     * 群名
     */
    private String roomName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberNickname() {
        return memberNickname;
    }

    public void setMemberNickname(String memberNickname) {
        this.memberNickname = memberNickname;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public UserAndRoom() {
    }

    public UserAndRoom(Integer id, String memberNickname, String roomName) {
        this.id = id;
        this.memberNickname = memberNickname;
        this.roomName = roomName;
    }

    @Override
    public String toString() {
        return "UserAndRoom{" +
                "id=" + id +
                ", memberNickname='" + memberNickname + '\'' +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}

