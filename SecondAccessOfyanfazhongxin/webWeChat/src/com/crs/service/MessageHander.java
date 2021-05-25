package com.crs.service;

import com.crs.entity.Message;

import javax.websocket.Session;

/**
 * @author shkstart
 * @create 2021-05-21 22:01
 */
public interface MessageHander {
    /**
     * 处理消息
     * @param session
     * @param message
     */
    public void execute(Session session, Message message);
}
