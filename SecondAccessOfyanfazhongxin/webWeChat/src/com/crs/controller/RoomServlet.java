package com.crs.controller;

import com.crs.entity.Room;
import com.crs.entity.UserAndRoom;
import com.crs.entity.UserDetails;
import com.crs.service.RoomService;
import com.crs.service.UserAndRoomService;
import com.crs.service.impl.RoomServiceImpl;
import com.crs.service.impl.UserAndRoomServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 16:45
 */
public class RoomServlet extends BaseServlet{
    private RoomService roomService = new RoomServiceImpl();
    private UserAndRoomService userAndRoomService = new UserAndRoomServiceImpl();
    private UserAndRoom userAndRoom;

    /**
     * 创建房间
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        List<String> members =  gson.fromJson(req.getParameter("members"), List.class);
        String roomNickname = req.getParameter("roomNickname");

        roomService.createRoom(new Room(null, roomNickname, LocalDateTime.now(), (String) req.getSession().getAttribute("userNickname")));
        for (String member: members) {
            userAndRoomService.addUserAndRoom(new UserAndRoom(null, member, roomNickname));
        }
    }

    /**
     * 查找群成员(包括群主)
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryRoomMemberByRoomName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String roomName = req.getParameter("roomName");
        System.out.println(roomName);
        String roomNameStr = gson.fromJson(roomName, String.class);
        System.out.println(roomNameStr);
        List<String> roomMembersList = userAndRoomService.queryRoomMemberByRoomName(roomNameStr);

        String roomMembersListJsonString = gson.toJson(roomMembersList);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(roomMembersListJsonString);
    }

    /**
     * 根据用户昵称查找其参与的群聊
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void queryMyJoinRoomByUserNickname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Gson gson = new Gson();
        String userNickName = req.getParameter("userNickname");
        List<String> roomsNameList = userAndRoomService.queryMyJoinRoomsNameByUserNickname(userNickName);

        String roomsNameListJsonString = gson.toJson(roomsNameList);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(roomsNameListJsonString);
    }
}

