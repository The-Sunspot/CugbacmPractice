package com.example.cugbacmpractice.Task;

import com.example.cugbacmpractice.bean.User;
import com.example.cugbacmpractice.service.Dataservice;
import com.example.cugbacmpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@EnableScheduling
@EnableAsync
public class SpiderTask {
    @Autowired
    Dataservice dataservice;
    @Autowired
    UserService userService;

    @Async
    @Scheduled(fixedDelay = 1000*60*60*24)
    public void getSpriderData(){
        List<User> userList = userService.getUserList();
        for (User user : userList) {
            try {
                dataservice.insertCfData(user.getStudentId());
            }
            catch (Exception e){
                System.out.println(e);
            }
            try {
                dataservice.insertVjData(user.getStudentId());
            }
            catch (Exception e){
                System.out.println(e);
            }

        }
        System.out.println("完成");
    }
}
