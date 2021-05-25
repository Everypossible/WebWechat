package com.crs.dao.impl;

import com.crs.dao.MessageDao;
import com.crs.entity.Message;
import com.crs.entity.User;

import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-18 18:04
 */
public class MessageDaoImpl extends BaseDao<Message> implements MessageDao {
    @Override
    public int saveMessage(Message message) {
        String sql = "insert into message(msgId,msgSender,msgReceiver,msgInfo,msgDateTimeStr,msgState)values(?,?,?,?,?,?)";
        int flag = update(sql, message.getMsgId(), message.getMsgSender(), message.getMsgReceiver(), message.getMsgInfo(), message.getMsgDateTimeStr(), message.getMsgState());
        return flag;
    }

    @Override
    public Message queryMessageByMsgReceiver(String msgReceiver) {
        String sql = "select msgSender,msgInfo,msgDateTimeStr from message where msgReceiver = ? order by msgDateTimeStr asc";
        Message message = (Message) getInstance(sql, msgReceiver);
        return message;
    }

    @Override
    public List queryMessageByUserNickname(String userNickname) {
        String sql = "select * from message where msgReceiver=? or msgSender=? order by msgDateTimeStr asc";
        List<Message> messages = (List<Message>) getForList(sql, userNickname, userNickname);
        return messages;
    }
}

