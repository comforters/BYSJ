package com.xx.ssm.service;

import com.xx.ssm.entity.FlowNode;

public interface IFlowNodeService {
	public void addNode(FlowNode flowNode);
	public FlowNode selectNode(int nextId,int defid);
	public FlowNode selectNodeById(int id,int defid);
}
