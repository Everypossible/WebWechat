package com.crs.controller;

import com.crs.entity.Message;
import com.crs.service.MessageService;
import com.crs.service.RoomService;
import com.crs.service.impl.MessageServiceImpl;
import com.crs.service.impl.RoomServiceImpl;
import com.google.gson.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-18 18:37
 */
public class MessageServlet extends BaseServlet{
    private MessageService messageService = new MessageServiceImpl();
    private RoomService roomService = new RoomServiceImpl();

    /**
     * 将消息存入数据库
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void msgSendToMySQL(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message msg = new Gson().fromJson(req.getParameter("msg"), Message.class);
        String sender = msg.getMsgSender();
        String receiver = msg.getMsgReceiver();
        String msgInfo = msg.getMsgInfo();
        String roomNickname = null;
//        System.out.println(roomService.isExistRoom(receiver));
        if (roomService.isExistRoom(receiver) == 0) {
            //群数据库中查询不到该群，证明这是一对一聊天
            roomNickname = sender + "and" + receiver;
//            System.out.println("一对一聊天的群名是：" + roomNickname);
        } else {
            roomNickname = receiver;
        }

        Message message = new Message(null, sender, receiver, roomNickname,  msgInfo, LocalDateTime.now(), 0);

        messageService.msgSendToMySQL(message);
    }

    /**
     * 获取聊天记录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void getMsgRecordByUserNickname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = messageService.queryFullMsgByUserNickname(req.getParameter("userNickname"));

        Gson gson = new Gson();
        String messageListJsonString = gson.toJson(messageList);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(messageListJsonString);
    }
    protected void getMsgRecordByRoomNickname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = messageService.queryMsgByRoomNickname(req.getParameter("roomNickname"));
//        System.out.println(messageList);

        Gson gson = new Gson();
        String messageListJsonString = gson.toJson(messageList);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(messageListJsonString);
    }
}

