package com.crs.dao;

import com.crs.entity.Message;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-18 18:02
 */
public interface MessageDao {
    /**
     * 将消息一条条存入数据库
     * @param message
     * @return 返回1则表示成功存入数据库一条消息
     */
    public int saveMessage(Message message);

    /**
     * 根据消息发送者的昵称查询消息记录
     * @param MsgReceiver
     * @return
     */
    public Message queryMessageByMsgReceiver(String MsgReceiver);

    /**
     * 根据用户昵称查询他的消息记录(不管他是消息的发送者还是接收者)
     * @param userNickname
     * @return
     */
    public List queryMessageByUserNickname(String userNickname);
}
