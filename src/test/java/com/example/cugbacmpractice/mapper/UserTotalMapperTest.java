package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.UserTotal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class UserTotalMapperTest {
    //@Autowired
    UserTotalMapper mapper;
    //@Test
    void getUserTodayTotalList() {
        for (UserTotal userTotal : mapper.getUserTodayTotalList()) {
            System.out.println(userTotal);
        }
    }

    //@Test
    void getActiveUserTodayTotalList() {
        for (UserTotal userTotal : mapper.getActiveUserTodayTotalList()) {
            System.out.println(userTotal);
        }
    }
}