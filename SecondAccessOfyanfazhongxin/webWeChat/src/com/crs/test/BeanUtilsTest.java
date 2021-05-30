package com.crs.test;

import com.crs.entity.User;
import com.crs.utils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-04-28 18:49
 */
public class BeanUtilsTest {
    public String[] objToStringArray(Object obj){
        String[] strArray = new String[1];
        strArray[0] = "" + obj + "";
        return strArray;
    }

    @Test
    public void populate() {
        User user = new User();

        user.setId(2);
        user.setIdentity(0);
        user.setUsername("13134");
        user.setPassword("1231314");

        HashMap<String, String[]> map = new HashMap<String, String[]>();
        map.put("id", objToStringArray(user.getId()));
        map.put("identity", objToStringArray(user.getIdentity()));
        map.put("username", objToStringArray(user.getUsername()));
        map.put("password", objToStringArray(user.getUsername()));

        try {
            User user1 = BeanUtils.populate(User.class, map);
            System.out.println(user1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}