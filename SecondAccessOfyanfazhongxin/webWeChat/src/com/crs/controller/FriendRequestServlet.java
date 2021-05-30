package com.crs.controller;

import com.crs.entity.FriendRequest;
import com.crs.service.FriendRequestService;
import com.crs.service.impl.FriendRequestServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-19 22:57
 */
public class FriendRequestServlet extends BaseServlet{
    private FriendRequestService friendRequestService = new FriendRequestServiceImpl();

    /**
     * 保存好友申请
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void saveFriendRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(req.getParameter("friendRequest"));
        Gson gson = new Gson();
        FriendRequest friendRequest = gson.fromJson(req.getParameter("friendRequest"), FriendRequest.class);
        friendRequestService.addFriendRequest(friendRequest);
    }

    protected void queryFriendRequestByReceiverNickname(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String receiverNickname = (String) req.getSession().getAttribute("userNickname");
        List<FriendRequest> friendRequestList = friendRequestService.queryFriendRequestByNickname(receiverNickname);

//        System.out.println(friendRequestList);
        Gson gson = new Gson();
        String requestListJsonString = gson.toJson(friendRequestList);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(requestListJsonString);
    }

}

