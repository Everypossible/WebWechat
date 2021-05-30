package com.crs.controller;
import com.crs.entity.Message;
import com.crs.service.RoomService;
import com.crs.service.UserAndRoomService;
import com.crs.service.impl.RoomServiceImpl;
import com.crs.service.impl.UserAndRoomServiceImpl;
import com.google.gson.Gson;


import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import java.io.IOException;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

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

    /**
     * 当每一个连接来的时候都会实例化一个MsgWebSocket
     */
    private static ConcurrentHashMap<WebSocket, String> webSockets = new ConcurrentHashMap<WebSocket, String>();

    /**
     * 真正的在线接受者
     */
    private static ConcurrentHashMap<String, WebSocket> realReceivers = new ConcurrentHashMap<>();
    private static List<String> receiverList = new ArrayList<>();
    private static List<String> roomMemberList = new ArrayList<>();
    private static UserAndRoomService userAndRoomService = new UserAndRoomServiceImpl();
    private static RoomService roomService = new RoomServiceImpl();
    private Session session;
    private Message message = null;
    private String msgSender;

    @OnOpen
    public void onOpen(@PathParam (value = "userNickname") String userNickname, Session session) {

        this.session = session;
        webSockets.put(this, userNickname);
//        System.out.println("***有新用户上线***");
        msgSender = userNickname;
    }
    @OnClose
    public void onClose(Session session) {
        this.session = session;
        webSockets.remove(this);
    }

    // 给其他所有用户发送消息，不给自己发
    private void sendMsgToOthers(String message) {
        for (String key : realReceivers.keySet()) {
//            System.out.println("***" + this.session + "***" + realReceivers.get(key).session.getId());
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

    /**
     * 当服务器接收到消息的时候，做消息转发
     * @param message
     */
    @OnMessage(maxMessageSize = 20000000)
    public void onMessage(String message) {
        receiverList.clear();
        realReceivers.clear();
        Gson gson = new Gson();
        Message message1 = gson.fromJson(message, Message.class);
        receiverList.add(0, message1.getMsgSender());
        if (roomService.isExistRoom(message1.getRoomNickname()) == 1) {
            //是群发
            roomMemberList = userAndRoomService.queryRoomMemberByRoomName(message1.getRoomNickname());
            for (int i = 0; i < roomMemberList.size(); i++) {
                receiverList.add(++i, roomMemberList.get(i));
            }
        } else {
            receiverList.add(1, message1.getMsgReceiver());
        }
        //找出群成员的昵称与在线成员的昵称匹配，匹配成功则存入代发送的真正成员列表
        for (String receiver : receiverList){
            for (WebSocket key : webSockets.keySet()){
                if (receiver.equals(webSockets.get(key))){
                    realReceivers.put(receiver, key);
                }
            }
        }

        // 当有消息来临时，给所有人发送消息
        this.message = new Message(null, msgSender, null, null, message1.getMsgInfo(),
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

