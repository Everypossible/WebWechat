package com.crs.controller;

import com.crs.LoginDetails;
import com.crs.entity.User;
import com.crs.entity.UserDetails;
import com.crs.service.UserDetailsService;
import com.crs.service.UserService;
import com.crs.service.impl.UserDetailsServiceImpl;
import com.crs.service.impl.UserServiceImpl;
import com.crs.utils.BeanUtils;
import com.crs.utils.MD5Utils;
import com.google.gson.Gson;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;

/**
 * @Description: 合并RegisterServlet和LoginServlet
 * @author RS
 * @create 2021-04-27 15:32
 */
public class UserServlet extends BaseServlet {
    private UserService userService = new UserServiceImpl();
    private UserDetailsService userDetailsService = new UserDetailsServiceImpl();
    /**
     * 登录业务处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        User user = (User) BeanUtils.populate(User.class, req.getParameterMap());
        user.setPassword(MD5Utils.toMD5(req.getParameter("password")));
        User loginUser = userService.login(user);
        //如果等于null,登录失败
        if(loginUser == null){
            //跳回登录页面
            req.getRequestDispatcher("/pages/LoginFalse.html").forward(req, resp);
        } else {
            //登陆成功
            //保存登录的用户信息
            Integer userId = loginUser.getId();
            String userNickname = userDetailsService.queryUserDetailsByUserId(userId).getNickname();
            req.getSession().setAttribute("user", loginUser);
            req.getSession().setAttribute("userNickname", userNickname);
            LoginDetails.loginerId = userService.queryUserIdByUsername(loginUser.getUsername());
            //跳转到主页
            resp.sendRedirect("/pages/admin/HomeTest.jsp");
        }
    }

    /**
     * 注册业务处理
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        //获取请求参数
        User user = BeanUtils.populate(User.class, req.getParameterMap());
        UserDetails userDetails = BeanUtils.populate(UserDetails.class, req.getParameterMap());

        String year = req.getParameter("YYYY");
        String month = req.getParameter("MM");
        String day = req.getParameter("DD");
        String code = req.getParameter("input_code");
        Integer userId = null;
        String dateStr = year + "-" + month + "-" + day;
        Date birth = null;
        try {
            birth = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setPassword(MD5Utils.toMD5(req.getParameter("password")));
        user.setIdentity(0);

        userDetails.setBirth(birth);
        userDetails.setCreateTime(LocalDateTime.now());

        String username = user.getUsername();
        String nickname = userDetails.getNickname();

        //equalsIgnoreCase()可以忽略大小写去进行比较字符串
        if (codeIsCorrect(req, resp)){
            //正确
            //检查用户名是否已经存在
            if (userService.existsUsername(username)){
                //用户名已存在
                System.out.println("用户邮箱[" + username + "]已存在");
                //跳回注册页面
                req.getRequestDispatcher("/pages/Register.jsp").forward(req, resp);
            } else if (userDetailsService.existsNickname(nickname)){
                //用户名已存在
                System.out.println("用户昵称[" + nickname + "]已存在");
                //跳回注册页面
                req.getRequestDispatcher("/pages/Register.jsp").forward(req, resp);
            } else {
                //用户名不存在,该用户名可用
                userService.userRegister(user);
                LoginDetails.loginerId = userService.queryUserIdByUsername(username);
                userDetails.setUserId(LoginDetails.loginerId);
                userDetailsService.userDetailsRegister(userDetails);
                //跳转到注册成功页面
                resp.sendRedirect("/pages/Login.html");
            }
        } else {
            //不正确
            //跳回注册页面
            req.getRequestDispatcher("/pages/Register.jsp").forward(req, resp);
        }

    }

    /**
     * 发送邮件
     * @param req
     * @param resp
     * @return
     * @throws ServletException
     * @throws IOException
     */
    protected boolean sendEmail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        //产生4位验证码
        String code = String.valueOf((int)(Math.random()*9000+1000));
        System.out.println(code);
        req.getSession().setAttribute("codeSend", code);
        System.out.println(req.getSession().getAttribute("codeSend"));
        String emailAddress = req.getParameter("emailAddress");
        HtmlEmail htmlEmail = new HtmlEmail();
        htmlEmail.setHostName("smtp.163.com");
        htmlEmail.setCharset("UTF-8");
        try {
            htmlEmail.addTo(emailAddress);
            htmlEmail.setFrom("rs19125885367@163.com","微聊");
            htmlEmail.setAuthentication("rs19125885367@163.com", "BUYHGPVHYQVJBQIW");
            htmlEmail.setSubject("[微聊]验证码");
            htmlEmail.setMsg("尊敬的用户，您好！您本次注册的验证码是：" + code);
//            htmlEmail.send();
            System.out.println("发送成功");
            return true;
        } catch (EmailException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断邮箱是否已被注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void emailExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        Gson gson = new Gson();
        resp.setCharacterEncoding("utf-8");
        if (userService.existsUsername(username)){
            resp.getWriter().write(gson.toJson(1));
        } else {
            resp.getWriter().write(gson.toJson(0));
        }
    }
    /**
     * 判断用户昵称是否已被注册
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void nicknameExist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String nickname = req.getParameter("nickname");
        Gson gson = new Gson();
        resp.setCharacterEncoding("utf-8");
        if (userDetailsService.existsNickname(nickname)){
            resp.getWriter().write(gson.toJson(1));
        } else {
            resp.getWriter().write(gson.toJson(0));
        }
    }

    /**
     * 判断输入的验证码是否和发送的一样
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected boolean codeIsCorrect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String codeInput = req.getParameter("input_code");
        Gson gson = new Gson();
        resp.setCharacterEncoding("utf-8");
        System.out.println("接收到" + codeInput);
        if (req.getSession().getAttribute("codeSend").equals(codeInput)){
            //验证码输入正确
            System.out.println("正确");
            resp.getWriter().write(gson.toJson(1));
            return true;
        } else {
            System.out.println("cuowu");
            resp.getWriter().write(gson.toJson(0));
            return false;
        }
    }

    /**
     * 修改密码
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void resetPassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String newPassword = req.getParameter("newPassword");
        int flag = userService.updatePasswordByUsername(username, MD5Utils.toMD5(newPassword));
        System.out.println(flag);
        if (flag == 1){
            req.getRequestDispatcher("/pages/Login.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/PasswordForgeted.jsp").forward(req, resp);
        }
    }
}

