package com.crs.service.impl;

import com.crs.dao.MessageDao;
import com.crs.dao.impl.MessageDaoImpl;
import com.crs.entity.Message;
import com.crs.service.MessageService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-18 18:33
 */
public class MessageServiceImpl implements MessageService {
    private MessageDao messageDao = new MessageDaoImpl();
    @Override
    public int msgSendToMySQL(Message message) {
        return messageDao.saveMessage(message);
    }

    @Override
    public  Message
    queryRecordByMsgReceiver(String msgReceiver){
        return messageDao.queryMessageByMsgReceiver(msgReceiver);
    }

    @Override
    public List queryRecordByUserNickname(String userNickname) {
        List<Message> messageList =  messageDao.queryMessageByUserNickname(userNickname);
        List<String> msgInfoList = new ArrayList<>();
        for (Message message : messageList){
            msgInfoList.add(message.getMsgInfo());
        }
        return msgInfoList;
    }

    @Override
    public List queryFullMsgByUserNickname(String userNickname) {
        return messageDao.queryMessageByUserNickname(userNickname);
    }
}

