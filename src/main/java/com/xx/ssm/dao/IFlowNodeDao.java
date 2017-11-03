package com.xx.ssm.dao;

import java.util.List;

import com.xx.ssm.entity.FlowNode;

public interface IFlowNodeDao {
	public void addNode(FlowNode flowNode);
	public FlowNode selectNode(int nextId,int defid);
	public FlowNode selectNodeById(int id,int defid);
}
