package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IUserInfoDao;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IUserService;
@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserInfoDao userInfoDAO;
	public List<UserInfo> list() {
		return userInfoDAO.list();
	}
	
	public UserInfo login(UserInfo userInfo){
		return userInfoDAO.login(userInfo);
	}
}
