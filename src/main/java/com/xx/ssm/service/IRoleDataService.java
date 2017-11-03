package com.xx.ssm.service;

import java.util.List;

import com.xx.ssm.entity.RoleData;

public interface IRoleDataService {
	public void addUserRole(RoleData roleData);
	public List<RoleData> selectUserRole();
	public RoleData selectUserByName(String nodeName);
}
