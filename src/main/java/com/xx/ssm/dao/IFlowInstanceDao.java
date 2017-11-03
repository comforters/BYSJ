package com.xx.ssm.dao;

import java.util.List;

import com.xx.ssm.entity.FlowInstance;

public interface IFlowInstanceDao {
	public void addAsk(FlowInstance flowInstance);
	public List<FlowInstance> selectAsk(int id);
	public void delAsk(int id);
	public List<FlowInstance> selectAskByNode(int id);
	public void editFlowById(int current,int next,int id);
	public void editEndFlowById(int current,int next,int id);
}
