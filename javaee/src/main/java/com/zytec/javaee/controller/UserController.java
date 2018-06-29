package com.zytec.javaee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zytec.javaee.model.User;
import com.zytec.javaee.service.UserService;
import com.zytec.javaee.utils.DataListReturn;

@Controller
@RequestMapping("USER")
public class UserController {

    @Autowired
    private UserService userServiceImpl;
    
//    @RequestMapping(value="selectUser", method=RequestMethod.POST)
//    @ResponseBody
//    public ModelAndView selectUser(){
//        ModelAndView mv = new ModelAndView();
//        List<User> userList = userServiceImpl.getUser();
//        mv.addObject("userList", userList);
//        mv.addObject("time","2018-06-11");
//        mv.setViewName("/show");
//        return mv;
//    }
    
    @RequestMapping(value="selectUser", method=RequestMethod.POST)
    @ResponseBody
    public DataListReturn selectUser(){
    	DataListReturn dlr = new DataListReturn();
    	Map<String, Object> map = new HashMap<String, Object>();
        try {
			List<User> userList = userServiceImpl.getUser();
			map.put("users", userList);
			dlr.setDataList(map);
			dlr.setMessage("success");
			dlr.setStatus(true);
		} catch (Exception e) {
			dlr.setMessage("fail");
			dlr.setStatus(false);
		}
        return dlr;
    }
}
