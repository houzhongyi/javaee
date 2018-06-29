/*package com.zytec.javaee.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.zytec.javaee.model.User;
import com.zytec.javaee.service.UserService;
	
public class TestUser {
	
	@Autowired
//	@Resource(name = "userService")
	@Qualifier("userServiceImpl")
    public UserService userServiceImpl;
//	
	@Test
	public void selectUser(){
		System.out.println("coming.........");
		List<User> list = userServiceImpl.getUser();
//		for (User user : list) {
//			System.out.println(user.getName());
//		}
		System.out.println(list.size());
	}
//	public static void main(String[] args) {
//		List<User> list = new UserServiceImpl().getUser();
//		for (User user : list) {
//			System.out.println(user.getName());
//		}
//	}
}
*/