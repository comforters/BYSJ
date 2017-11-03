package com.xx.ssm.dao;

import java.util.List;

import com.xx.ssm.entity.FlowDefine;

public interface IFlowDefineDao {
	public void addFlow(FlowDefine flowDefine);
	public List<FlowDefine> selectAllFlow();
	public FlowDefine selectFlowById(int id);
}
