package com.crs.utils;

import com.crs.entity.User;

import javax.servlet.http.HttpServletRequest;


/**
 * @Description: 将请求的参数包装成JavaBean
 * @outhor RS
 * @create 2021-04-28 18:38
 */
public class WebUtils {
    public static void copyParamToBean(HttpServletRequest req, Object bean) {
        try {
            System.out.println("注入之前：" + bean);
//            BeanUtils.populate(User.class, req.getParameterMap());
            System.out.println("注入之后：" + bean);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

