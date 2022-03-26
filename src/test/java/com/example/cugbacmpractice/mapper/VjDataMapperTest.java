package com.example.cugbacmpractice.mapper;

import com.example.cugbacmpractice.bean.VjData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
//@SpringBootTest
class VjDataMapperTest {
    @Autowired
    VjDataMapper mapper;
    //@Test
    void getVjList() {
    }

    //@Test
    void getVjListBySid() {
    }

    //@Test
    void insertVjData() {
        VjData data=new VjData();
        data.setSid("1004196120");
        data.setAllSolved(100);
        data.setDaySolved(12);
        data.setMonthSolved(33);
        data.setProfileName("csh");
        data.setWeekSolved(22);
        data.setRecordDate(new Timestamp(new Date().getTime()));
        assert mapper.insertVjData(data)==1;
    }
}