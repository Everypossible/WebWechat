package com.crs.service.impl;

import com.crs.entity.Message;
import com.crs.service.MessageHander;
import com.crs.utils.WebsocketUtils;

import javax.websocket.Session;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-21 22:05
 */
public class LoginHanderImpl implements MessageHander {
    @Override
    public void execute(Session session, Message message) {
        WebsocketUtils.addSession(session, message.getMsgSender());
    }
}

