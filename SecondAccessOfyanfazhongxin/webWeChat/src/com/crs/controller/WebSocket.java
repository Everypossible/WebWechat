package com.crs.controller;
import com.crs.entity.Message;
import com.crs.utils.WebUtils;
import com.crs.utils.WebsocketUtils;
import com.google.gson.Gson;


import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Console;
import java.io.File;
import java.io.IOException;

import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author RS
 * @Description: 搭建Websocket服务器
 * @create 2021-05-08 21:07
 */

/**
 * ?这个注解怎么用
 */
@ServerEndpoint("/websocket/chat/{userNickname}")
public class  WebSocket {
    // 当每一个连接来的时候都会实例化一个MsgWebSocket
    private static ConcurrentHashMap<WebSocket, String> webSockets = new ConcurrentHashMap<WebSocket, String>();
    //真正的在线接受者
    private static ConcurrentHashMap<String, WebSocket> realReceivers = new ConcurrentHashMap<>();
    // 与任何一个客户端的连接都有会话
    private Session session;
    private Message message = null;
    private String msgSender;
    private final int TYPE_ENTER = 0;
    private final int TYPE_LEAVE = 1;
    private final int TYPE_MSG = 2;

    @OnOpen
    public void onOpen(@PathParam (value = "userNickname") String userNickname, Session session) {

        this.session = session;
        webSockets.put(this, userNickname);
        System.out.println("***有新用户上线***");
        msgSender = userNickname;
        this.message = new Message(null, String.valueOf(this.session.getId()), null,
                "用户" + this.session.getId() + "： 进入了聊天室",
                LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()), 0);
        Gson gson = new Gson();
//        sendMsgToOthers(gson.toJson(this.message));
    }
    @OnClose
    public void onClose(Session session) {
        this.session = session;
        webSockets.remove(this);
        this.message = new Message(null, String.valueOf(this.session.getId()), null,
                "用户" + this.session.getId() + "： 离开了聊天室",
                LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()), 0);
        System.out.println(this.message);
        Gson gson = new Gson();
//        sendMsgToOthers(gson.toJson(this.message));
    }

    // 给其他所有用户发送消息，不给自己发
    private void sendMsgToOthers(String message) {
        for (String key : realReceivers.keySet()) {
            System.out.println("***" + this.session + "***" + realReceivers.get(key).session.getId());
            realReceivers.get(key).sendMessage(message);
        }
    }

    private void sendMessage(String message) {
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 当服务器接收到消息的时候，做消息转发
     */
    @OnMessage(maxMessageSize = 20000000)
    public void onMessage(String message) {
        realReceivers.clear();
        Gson gson = new Gson();
        Message message1 = gson.fromJson(message, Message.class);
        //从前端获得的群成员List
        List<String> receiverList = message1.getMsgReceiverList();
//        System.out.println("后台确认转发到：" + receiverList);
        //找出群成员的昵称与在线成员的昵称匹配，匹配成功则存入代发送的真正成员列表
        for (String receiver : receiverList){
            for (WebSocket key : webSockets.keySet()){
                if (receiver.equals(webSockets.get(key))){
                    realReceivers.put(receiver, key);
                }
            }
        }
        System.out.println("真正接收者：" + realReceivers);

//        System.out.println("来自客户端的语句消息：" + message);
        // 当有消息来临时，给除去自己外的所有人发送消息
        this.message = new Message(null, msgSender, null, message1.getMsgInfo(),
                LocalDateTime.ofInstant(new Date().toInstant(), ZoneId.systemDefault()), 0);
        sendMsgToOthers(gson.toJson(this.message));
    }

    @OnError
    public void error(Throwable t) throws Throwable {
        System.out.println("系统出现异常!!!");
        t.printStackTrace();
        onClose(session);
    }

}

