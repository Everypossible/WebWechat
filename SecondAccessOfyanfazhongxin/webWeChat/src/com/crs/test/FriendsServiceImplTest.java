package com.crs.test;

import com.crs.entity.Friends;
import com.crs.entity.UserDetails;
import com.crs.service.FriendsService;
import com.crs.service.impl.FriendsServiceImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author shkstart
 * @create 2021-05-12 18:56
 */
public class FriendsServiceImplTest {
    FriendsService friendsService = new FriendsServiceImpl();

    @Test
    public void showAllFriends() {
        List<UserDetails> friendsList = new ArrayList<>();
        friendsList = friendsService.showAllFriends(2);
        Iterator<UserDetails> it = friendsList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}