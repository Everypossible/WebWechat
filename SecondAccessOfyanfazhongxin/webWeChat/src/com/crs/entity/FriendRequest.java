package com.crs.entity;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 22:02
 */
public class FriendRequest {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 发送好友请求者的昵称
     */
    private String senderName;
    /**
     * 接受申请者的昵称
     */
    private String receiverName;
    /**
     * 请求状态(0表示未回复,1表示接受请求,2表示拒绝)
     */
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public FriendRequest() {
    }

    public FriendRequest(Integer id, String senderName, String receiverName, Integer state) {
        this.id = id;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.state = state;
    }

    @Override
    public String toString() {
        return "FriendRequest{" +
                "id=" + id +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", state=" + state +
                '}';
    }
}

