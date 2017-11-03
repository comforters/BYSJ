package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IRoleDataDao;
import com.xx.ssm.entity.RoleData;
import com.xx.ssm.service.IRoleDataService;
@Service
public class RoleDataServiceImpl implements IRoleDataService {
	@Autowired
	private IRoleDataDao iRoleDataDao;
	@Override
	public void addUserRole(RoleData roleData) {
		iRoleDataDao.addUserRole(roleData);
	}
	@Override
	public List<RoleData> selectUserRole() {
		return iRoleDataDao.selectUserRole();
	}
	@Override
	public RoleData selectUserByName(String nodeName) {
		return iRoleDataDao.selectUserByName(nodeName);
	}

}
