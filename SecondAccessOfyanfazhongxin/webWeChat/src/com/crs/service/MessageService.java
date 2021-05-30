package com.crs.service;

import com.crs.entity.Message;
import com.crs.entity.User;

import java.util.List;

/**
 * @author shkstart
 * @create 2021-05-18 18:14
 */
public interface MessageService {
    /**
     * 将发送的消息存入数据库
     * @param message
     * @return
     */
    public int msgSendToMySQL(Message message);

    /**
     * 查询聊天记录(根据接受者昵称)
     * @param msgReceiver
     * @return
     */
    public Message queryRecordByMsgReceiver(String msgReceiver);

    /**
     * 查询聊天内容记录(根据用户昵称，不区分他是发送者还是接收者)
     * @param userNickname
     * @return
     */
    public List queryRecordByUserNickname(String userNickname);

    /**
     * 查询聊天完整记录(包括发送者，时间等等)(根据用户昵称，不区分他是发送者还是接收者)
     * @param userNickname
     * @return
     */
    public List queryFullMsgByUserNickname(String userNickname);

    /**
     *查询聊天记录(根据群昵称)
     * @param roomNickname
     * @return
     */
    public List queryMsgByRoomNickname(String roomNickname);
}
