package com.crs.test;

import com.crs.entity.User;
import com.crs.service.UserService;
import com.crs.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-04-25 16:24
 */
public class UserServiceTest {
    private UserService userService = new UserServiceImpl();

    @Test
    public void userRegister() {
        userService.userRegister(new User(null, "chen", "666666", 0));
    }

    @Test
    public void login() {
        System.out.println(userService.login(new User(null, "chen", "666666", 0)));
        System.out.println(userService.login(new User(null, "123", "666666", 0)));
        System.out.println(userService.login(new User(null, "哈哈哈", "666666", 0)));
        User user = userService.login(new User(null, "哈哈哈哈哈", "666666", 0));
        if (user == null){
            System.out.println(0);
        }
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("chen")) {
            System.out.println("该用户名已经存在!");
        } else {
            System.out.println("该用户名不存在!");
        }
    }
}