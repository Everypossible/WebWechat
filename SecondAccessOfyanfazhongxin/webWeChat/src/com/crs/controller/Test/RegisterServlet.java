package com.crs.controller.Test;

import com.crs.entity.User;
import com.crs.service.UserService;
import com.crs.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description: TODO
 * @outhor RS
 * @create 2021-04-25 17:08
 */
public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    //注册页面有密码，不希望别人看见，所以用doPost()而不用doGet();
    //doGet()会在地址栏显示参数,而doPost()不会.所以密码安全

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //检查 验证码是否正确 === 活的(动态)验证码还不会,现在先把它写死
        //equalsIgnoreCase()可以忽略大小写去进行比较字符串
        if ("abcde".equalsIgnoreCase(code)){
            //正确
            //检查用户名是否已经存在
            if (userService.existsUsername(username)){
                //用户名已存在
                System.out.println("用户名[" + username + "]已存在");
                //跳回注册页面
                req.getRequestDispatcher("跳转的目标地址").forward(req, resp);
            } else {
                //用户名不存在,该用户名可用
                userService.userRegister(new User(null, username, password, 0));
                //跳转到注册成功页面
                req.getRequestDispatcher("跳转的目标地址").forward(req, resp);
            }
        } else {
            //不正确
            //跳回注册页面
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("跳转的目标地址").forward(req, resp);
        }

    }
}

