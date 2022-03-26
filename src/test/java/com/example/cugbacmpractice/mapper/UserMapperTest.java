package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.html.HTMLUListElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper mapper;
    //@Test
    void getUserList() {
        List<User> userList = mapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }

    }

    //@Test
    void getUserListByGrade() {
        List<User> userListByGrade = mapper.getUserListByGrade(20);
        for (User user : userListByGrade) {
            System.out.println(user);
        }
    }

    //@Test
    void getUserListByNameLike() {
        List<User> list = mapper.getUserListByNameLike("华华");
        for (User user : list) {
            System.out.println(user);
        }

    }

    //@Test
    void getActiveUserList() {
        List<User> activeUserList = mapper.getActiveUserList();
        for (User user : activeUserList) {
            System.out.println(user);
        }
    }

    //@Test
    void getNotActiveUserList() {
        List<User> activeUserList = mapper.getNotActiveUserList();
        for (User user : activeUserList) {
            System.out.println(user);
        }
    }

    //@Test
    void insertUser() {
        User user = new User();
        user.setStudentId("1004196111");
        user.setActive(false);
        user.setName("test");
        user.setGrade(22);
        int i = mapper.insertUser(user);
        assert i==1;
    }

    //@Test
    void updateUser() {
        Map map = new HashMap();
        map.put("name","曹操");
        map.put("sid","1004196122");
        int i = mapper.updateUser(map);
        assert i==1;
    }

    //@Test
    void deleteUser() {
        assert mapper.deleteUser("1004196111")==1;
    }

    //@Test
    void getUserBySid() {
        System.out.println(mapper.getUserBySid("1004196122"));
    }
}