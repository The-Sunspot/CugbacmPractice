package com.example.cugbacmpractice.Task;

import com.example.cugbacmpractice.bean.VjData;
import com.example.cugbacmpractice.service.Dataservice;
import com.example.cugbacmpractice.service.UserService;
import com.example.cugbacmpractice.utils.SpiderUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class SpiderTaskTest {
    @Autowired
    SpiderTask spiderTask;
    @Autowired
    UserService userService;
    @Autowired
    Dataservice dataservice;
    @Test
    void dooo(){
        spiderTask.getSpriderData();
    }

}