package com.xx.ssm.dao;

import java.util.List;

import com.xx.ssm.entity.RoleData;

public interface IRoleDataDao {
	public void addUserRole(RoleData roleData);
	public List<RoleData> selectUserRole();
	public RoleData selectUserByName(String nodeName);
}
