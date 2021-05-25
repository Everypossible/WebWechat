package com.crs.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author RS
 * @Description: 消息实体类
 * @create 2021-05-09 10:01
 */
public class Message {
    /**
     * 对应消息主键
     */
    private Integer msgId;
    /**
     * 消息发送者
     */
    private String msgSender;
    /**
     * 消息接受者
     */
    private String msgReceiver;
    /**
     * 接收者集合(群聊时)
     */
    private List msgReceiverList;
    /**
     * 消息内容
     */
    private String msgInfo;
    /**
     * 消息日期
     */
    private LocalDateTime msgDateTimeStr;
    /**
     * 消息已读未读状态
     */
    private Integer msgState;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgSender() {
        return msgSender;
    }

    public void setMsgSender(String msgSender) {
        this.msgSender = msgSender;
    }

    public String getMsgReceiver() {
        return msgReceiver;
    }

    public void setMsgReceiver(String msgReceiver) {
        this.msgReceiver = msgReceiver;
    }

    public List getMsgReceiverList() {
        return msgReceiverList;
    }

    public void setMsgReceiverList(List msgReceiverList) {
        this.msgReceiverList = msgReceiverList;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public LocalDateTime getMsgDateTimeStr() {
        return msgDateTimeStr;
    }

    public void setMsgDateTimeStr(LocalDateTime msgDateTimeStr) {
        this.msgDateTimeStr = msgDateTimeStr;
    }

    public Integer getMsgState() {
        return msgState;
    }

    public void setMsgState(Integer msgState) {
        this.msgState = msgState;
    }

    public Message() {
    }

    public Message(Integer msgId, String msgSender, String msgReceiver, String msgInfo, LocalDateTime msgDateTimeStr, Integer msgState) {
        this.msgId = msgId;
        this.msgSender = msgSender;
        this.msgReceiver = msgReceiver;
        this.msgInfo = msgInfo;
        this.msgDateTimeStr = msgDateTimeStr;
        this.msgState = msgState;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msgId=" + msgId +
                ", msgSender='" + msgSender + '\'' +
                ", msgReceiver='" + msgReceiver + '\'' +
                ", msgInfo='" + msgInfo + '\'' +
                ", msgDateTimeStr='" + msgDateTimeStr + '\'' +
                ", msgType='" + msgState + '\'' +
                '}';
    }
}

