package com.example.cugbacmpractice.service;

import com.example.cugbacmpractice.bean.CfData;
import com.example.cugbacmpractice.bean.User;
import com.example.cugbacmpractice.bean.VjData;
import com.example.cugbacmpractice.mapper.CfDataMapper;
import com.example.cugbacmpractice.mapper.UserMapper;
import com.example.cugbacmpractice.mapper.VjDataMapper;
import com.example.cugbacmpractice.utils.SpiderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Dataservice {
    @Autowired
    CfDataMapper cfMapper;
    @Autowired
    VjDataMapper vjMapper;
    @Autowired
    UserMapper userMapper;
    //@Autowired
    SpiderUtils spider=new SpiderUtils();

    List<CfData> getCfList() {
        return cfMapper.getCfList();
    }

    CfData getCfListBySid(String sid) {
        return cfMapper.getCfListBySid(sid);
    }

    public int insertCfData(String sid){
        User user = userMapper.getUserBySid(sid);
        CfData data = spider.getCfData(user.getCfProfileName());
        if(data == null)
            return 0;
        data.setSid(sid);
        return cfMapper.insertCfData(data);
    }

    List<VjData> getVjList(){
        return vjMapper.getVjList();
    }

    VjData getVjListBySid(String sid){
        return vjMapper.getVjListBySid(sid);
    }

    public int insertVjData(String sid){
        User user = userMapper.getUserBySid(sid);
        VjData data = spider.getVjData(user.getVjProfileName());
        if(data == null)
            return 0;
        data.setSid(sid);
        return vjMapper.insertVjData(data);
    }

}
