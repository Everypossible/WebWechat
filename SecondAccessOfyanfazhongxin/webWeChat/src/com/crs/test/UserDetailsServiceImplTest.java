package com.crs.test;

import com.crs.entity.UserDetails;
import com.crs.service.UserDetailsService;
import com.crs.service.impl.UserDetailsServiceImpl;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-05-12 23:15
 */
public class UserDetailsServiceImplTest {
    UserDetailsService userDetailsService = new UserDetailsServiceImpl();

    @Test
    public void userDetailsRegister() {
    }

    @Test
    public void queryUserDetailsByVagueNickname() {
        List<UserDetails> userDetailsList = userDetailsService.queryUserDetailsByVagueNickname("2");
//        Iterator<UserDetails> it = userDetailsList.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
        System.out.println(userDetailsList.toString());
    }
}