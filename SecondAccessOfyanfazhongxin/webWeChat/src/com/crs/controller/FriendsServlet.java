package com.crs.controller;

import com.crs.LoginDetails;
import com.crs.entity.BlackFriend;
import com.crs.entity.Friends;
import com.crs.entity.UserDetails;
import com.crs.service.FriendRequestService;
import com.crs.service.FriendsService;
import com.crs.service.UserDetailsService;
import com.crs.service.impl.FriendRequestServiceImpl;
import com.crs.service.impl.FriendsServiceImpl;
import com.crs.service.impl.UserDetailsServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author RS
 * @Description: TODO
 * @create 2021-05-11 21:55
 */
public class FriendsServlet extends BaseServlet{
    private FriendsService friendsService = new FriendsServiceImpl();
    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();
    private FriendRequestService friendRequestService = new FriendRequestServiceImpl();
    /**
     * 展示所有的好友
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void showAllFriends(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String userNickname = (String) req.getSession().getAttribute("userNickname");
        Integer userId = userDetailsService.queryUserDetailsByNickname(userNickname).getUserId();
        List<UserDetails> friendsDetails = friendsService.showAllFriends(userId);
//        System.out.println("该用户好友有：" + friendsDetails.toString());

        Gson gson = new Gson();
        String friendsDetailsJsonString = gson.toJson(friendsDetails);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(friendsDetailsJsonString);
    }

    /**
     * 拉黑好友
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deFriend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String friendNickname = req.getParameter("friendNickname");
        BlackFriend blackFriend = new BlackFriend(null, friendNickname);
        friendsService.deFriend(blackFriend);
    }

    /**
     * 删除好友
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteFriend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String friendNickname = req.getParameter("friendNickname");
        friendsService.deleteFriendByNickname(friendNickname);
    }

    /**
     * 添加好友
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void agreeAddFriend(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String requestSender = req.getParameter("requestSender");
        String requestReceiver = (String) req.getSession().getAttribute("userNickname");
        //将好友信息存入数据库
        Integer requestSenderId = userDetailsService.queryUserDetailsByNickname(requestSender).getUserId();
        Integer requestReceiverId = userDetailsService.queryUserDetailsByNickname(requestReceiver).getUserId();
        Friends friend1 = new Friends(null, requestSenderId, requestReceiverId, requestReceiver);
        Friends friend2 = new Friends(null, requestReceiverId, requestSenderId, requestSender);
        friendsService.saveFriend(friend1);
        friendsService.saveFriend(friend2);
        //将这条好友申请状态设置为1
        friendRequestService.updateFriendRequest(requestSender, requestReceiver);
    }
}

