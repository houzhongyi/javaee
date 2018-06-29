package com.zytec.javaee.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zytec.javaee.dao.IUserDao;
import com.zytec.javaee.model.User;
import com.zytec.javaee.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{
	@Autowired
    private IUserDao iUserDao;

    public List<User> getUser() {
    	System.out.println("***********");
    	List<User> list = iUserDao.selectAllUser();
        return list;
    }

/*	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}*/
}