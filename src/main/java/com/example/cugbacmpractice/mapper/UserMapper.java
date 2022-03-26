package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.Map;

@Mapper

public interface UserMapper {
    List<User> getUserList();
    List<User> getUserListByGrade(int grade);
    List<User> getUserListByNameLike(String name);
    List<User> getActiveUserList();
    List<User> getNotActiveUserList();
    User getUserBySid(String sid);
    int insertUser(@Validated User user);
    int updateUser(Map map);
    int deleteUser(String sid);
}
