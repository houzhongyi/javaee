package com.zytec.type.utils;

import org.apache.shiro.SecurityUtils;

public class GetUser {
    
    public static String getUsername(){
        String userName = (String) SecurityUtils.getSubject()
        .getSession().getAttribute("showUserName");
        return userName;
    }
    
}
