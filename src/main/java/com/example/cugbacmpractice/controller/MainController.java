package com.example.cugbacmpractice.controller;

import com.example.cugbacmpractice.bean.User;
import com.example.cugbacmpractice.mapper.UserTotalMapper;
import com.example.cugbacmpractice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/")
    public String index(Model model){
        model.addAttribute("UserInfos",userService.getUesrInfoList());
        //model.addAttribute("Users",userService.getUserList());
        return "index";
    }

    @RequestMapping(value = "/dosignup",method = {RequestMethod.POST,RequestMethod.GET})
    public String signUp(){
        return "signUp";
    }
    @RequestMapping(value = "/signup",method = {RequestMethod.POST,RequestMethod.GET})
    public String doSignUp(@ModelAttribute User user, Model model){
        System.out.println(user);
        if(userService.isSignedSid(user.getStudentId())){
            model.addAttribute("msg","已经注册的学号");
            return "error";
        }
        int i = userService.signUp(user);
        if(i==1)
            return "redirect:/";
        model.addAttribute("msg","注册失败！");
        return "error";
    }

}
