package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.CfData;
import com.example.cugbacmpractice.bean.UserTotal;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserTotalMapper {
    List<UserTotal> getUserTodayTotalList();
    List<UserTotal> getActiveUserTodayTotalList();
}
