package com.xx.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IFlowNodeDao;
import com.xx.ssm.entity.FlowDefine;
import com.xx.ssm.entity.FlowNode;
import com.xx.ssm.service.IFlowDefineService;
import com.xx.ssm.service.IFlowNodeService;
@Service
public class FlowNdoeServiceImpl implements IFlowNodeService {
	@Autowired
	private IFlowNodeDao iFlowNodeDao;
	@Override
	public void addNode(FlowNode flowNode) {
		iFlowNodeDao.addNode(flowNode);
	}
	@Override
	public FlowNode selectNode(int nextId, int defid) {
		return iFlowNodeDao.selectNode(nextId, defid);
	}
	@Override
	public FlowNode selectNodeById(int id, int defid) {
		return iFlowNodeDao.selectNodeById(id, defid);
	}

}
