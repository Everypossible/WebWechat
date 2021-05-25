package com.crs.controller;

import com.crs.entity.Message;
import com.crs.service.MessageService;
import com.crs.service.impl.MessageServiceImpl;
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

    /**
     * 将消息存入数据库
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void msgSendToMySQL(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Message msg = new Gson().fromJson(req.getParameter("msg"), Message.class);
        System.out.println(msg);
    }
    protected void getMsgRecordByUserNickname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Message> messageList = messageService.queryFullMsgByUserNickname(req.getParameter("userNickname"));
        System.out.println(messageList);

        Gson gson = new Gson();
        String messageListJsonString = gson.toJson(messageList);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(messageListJsonString);
    }
}

