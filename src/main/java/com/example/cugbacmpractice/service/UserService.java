package com.example.cugbacmpractice.service;

import com.example.cugbacmpractice.bean.User;
import com.example.cugbacmpractice.bean.UserTotal;
import com.example.cugbacmpractice.mapper.UserMapper;
import com.example.cugbacmpractice.mapper.UserTotalMapper;
import com.example.cugbacmpractice.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    MD5Utils md5Utils;
    @Autowired
    Dataservice dataservice;
    @Autowired
    UserTotalMapper userTotalMapper;
    public List<UserTotal> getUesrInfoList(){
        return userTotalMapper.getUserTodayTotalList();
    }
//    public List<UserTotal> getUesrInfo(String sid){
  //      return userTotalMapper.getUserTodayTotalList();
    //}
    public int setCfName(String sid,String cfName){
        Map map = new HashMap();
        map.put("sid",sid);
        map.put("cfProfileName",cfName);
        return userMapper.updateUser(map);
    }
    public List<User> getUserList(){
        return userMapper.getUserList();
    }
    public int setVjName(String sid,String vjName){
        Map map = new HashMap();
        map.put("sid",sid);
        map.put("vjProfileName",vjName);
        return userMapper.updateUser(map);
    }

    public int changePassword(String sid,String password){
        Map map = new HashMap();
        map.put("sid",sid);
        map.put("password",password);
        return userMapper.updateUser(map);
    }

    public boolean doLogin(String sid,String password){
        User user = userMapper.getUserBySid(sid);
        if(user==null)  return false;
        return md5Utils.isSameString(password,user.getPassword());
    }

    public boolean isSignedSid(String sid){
        return userMapper.getUserBySid(sid)!=null;
    }
    public int signUp(User user){
        user.setPassword(md5Utils.doEncryption(user.getPassword()));
        int i= userMapper.insertUser(user);
        if(i==0)    return i;
        dataservice.insertCfData(user.getStudentId());
        dataservice.insertVjData(user.getStudentId());
        return i;
    }
}
