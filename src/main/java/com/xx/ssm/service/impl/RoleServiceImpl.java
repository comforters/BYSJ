package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IRoleDao;
import com.xx.ssm.dao.IUserInfoDao;
import com.xx.ssm.entity.Role;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IRoleService;
import com.xx.ssm.service.IUserService;
@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private IRoleDao roleDao;
	@Override
	public List<Role> listById(int roleId) {
		return roleDao.listById(roleId);
	}
	 
}
