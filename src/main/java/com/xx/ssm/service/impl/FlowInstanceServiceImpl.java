package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IFlowInstanceDao;
import com.xx.ssm.entity.FlowInstance;
import com.xx.ssm.service.IFlowInstanceService;
@Service
public class FlowInstanceServiceImpl implements IFlowInstanceService {
	@Autowired
	private IFlowInstanceDao iFlowInstanceDao;
	@Override
	public void addAsk(FlowInstance flowInstance) {
		iFlowInstanceDao.addAsk(flowInstance);
	}
	@Override
	public List<FlowInstance> selectAsk(int id) {	
		return iFlowInstanceDao.selectAsk(id);
	}
	@Override
	public void delAsk(int id) {
		iFlowInstanceDao.delAsk(id);
	}
	@Override
	public List<FlowInstance> selectAskByNode(int id) {
		return iFlowInstanceDao.selectAskByNode(id);
	}
	@Override
	public void editFlowById(int current, int next, int id) {
		iFlowInstanceDao.editFlowById(current, next, id);
	}
	@Override
	public void editEndFlowById(int current, int next, int id) {
		iFlowInstanceDao.editEndFlowById(current, next, id);
	}

}
