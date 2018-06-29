package com.zytec.javaee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zytec.javaee.model.User;
import com.zytec.javaee.service.UserService;

@Controller
@RequestMapping("USER")
public class UserController {

    @Autowired
    private UserService userServiceImpl;
    
    @RequestMapping(value="selectUser", method=RequestMethod.POST)
    @ResponseBody
    public ModelAndView selectUser(){
        ModelAndView mv = new ModelAndView();
        List<User> userList = userServiceImpl.getUser();
        mv.addObject("userList", userList);
        mv.addObject("time","2018-06-11");
        mv.setViewName("/show");
        return mv;
    }
}
