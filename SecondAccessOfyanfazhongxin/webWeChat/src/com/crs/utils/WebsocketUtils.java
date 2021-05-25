package com.crs.utils;

import com.google.gson.Gson;
import com.mysql.cj.protocol.Message;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket 工具类，提供客户端连接的管理等功能
 * @author RS
 * @Description: TODO
 * @create 2021-05-21 21:23
 */
public class WebsocketUtils {

    /**
     * Session 与用户的映射
     */
    public static final Map<Session, String> SESSION_USER_MAP = new ConcurrentHashMap<>();
    /**
     * 用户与 Session 的映射
     */
    public static final Map<String, Session> USER_SESSION_MAP = new ConcurrentHashMap<>();

    /**
     * 添加 Session 。在这个方法中，会添加用户和 Session 之间的映射
     *
     * @param session Session
     * @param userNickname 用户昵称
     */
    public static void addSession(Session session, String userNickname) {
        // 更新 USER_SESSION_MAP
        USER_SESSION_MAP.put(userNickname, session);
        // 更新 SESSION_USER_MAP
        SESSION_USER_MAP.put(session, userNickname);
    }

    /**
     * 移除 Session 。
     *
     * @param session Session
     */
    public static void removeSession(Session session) {
        // 从 SESSION_USER_MAP 中移除
        String user = SESSION_USER_MAP.remove(session);
        // 从 USER_SESSION_MAP 中移除
        if (user != null && user.length() > 0) {
            USER_SESSION_MAP.remove(user);
        }
    }

    // ========== 消息相关 ==========

    /**
     * 广播发送消息给所有在线用户
     * @param sessionList
     * @param message
     */
    public static void broadcast(List<Session> sessionList, Message message) {
        // 遍历 SESSION_USER_MAP ，进行逐个发送
        for (Session session : sessionList) {
            sendMessage(session, message);
        }
    }

    /**
     * 发消息
     * @param message
     */
    private static void sendMessage(Session session, Message message) {
        Gson gson = new Gson();
        String msgStr = gson.toJson(message);
        try {
            session.getBasicRemote().sendText(msgStr);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

