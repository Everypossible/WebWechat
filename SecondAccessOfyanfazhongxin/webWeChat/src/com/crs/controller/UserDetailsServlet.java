package com.crs.controller;

import com.crs.entity.UserDetails;
import com.crs.service.UserDetailsService;
import com.crs.service.impl.UserDetailsServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author RS
 * @Description: 用户详情
 * @create 2021-05-13 21:08
 */
public class UserDetailsServlet extends BaseServlet{
    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();
    /**
     * 查找用户
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void userDetailsSearch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDetails> userDetails = userDetailsService.queryUserDetailsByVagueNickname(req.getParameter("searchInfo"));
//        System.out.println(userDetails.toString());

        Gson gson = new Gson();
        String friendsDetailsJsonString = gson.toJson(userDetails);
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(friendsDetailsJsonString);
    }
}

