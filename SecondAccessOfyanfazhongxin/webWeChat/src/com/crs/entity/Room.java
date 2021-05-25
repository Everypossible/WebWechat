package com.crs.entity;

import java.time.LocalDateTime;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 10:55
 */
public class Room {
    /**
     * 群 主键id
     */
    private Integer roomId;
    /**
     * 群昵称
     */
    private String roomNickname;
    /**
     * 群创建时间
     */
    private LocalDateTime createTime;
    /**
     * 群主昵称
     */
    private String ownerNickname;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getRoomNickname() {
        return roomNickname;
    }

    public void setRoomNickname(String roomNickname) {
        this.roomNickname = roomNickname;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getOwnerNickname() {
        return ownerNickname;
    }

    public void setOwnerNickname(String ownerNickname) {
        this.ownerNickname = ownerNickname;
    }

    public Room() {
    }

    public Room(Integer roomId, String roomNickname, LocalDateTime createTime, String ownerNickname) {
        this.roomId = roomId;
        this.roomNickname = roomNickname;
        this.createTime = createTime;
        this.ownerNickname = ownerNickname;
    }

    @Override
    public String toString() {
        return "room{" +
                "roomId=" + roomId +
                ", roomNickname='" + roomNickname + '\'' +
                ", createTime='" + createTime + '\'' +
                ", ownerNickname='" + ownerNickname + '\'' +
                '}';
    }
}

