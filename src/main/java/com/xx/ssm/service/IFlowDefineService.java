package com.xx.ssm.service;

import java.util.List;

import com.xx.ssm.entity.FlowDefine;

public interface IFlowDefineService {
	public void addFlow(FlowDefine flowDefine);
	public List<FlowDefine> selectAllFlow();
	public FlowDefine selectFlowById(int id);
}
