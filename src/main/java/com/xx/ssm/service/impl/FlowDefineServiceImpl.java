package com.xx.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xx.ssm.dao.IFlowDefineDao;
import com.xx.ssm.entity.FlowDefine;
import com.xx.ssm.service.IFlowDefineService;

@Service
public class FlowDefineServiceImpl implements IFlowDefineService {
	@Autowired
	private IFlowDefineDao iFlowDefineDao;

	@Override
	public void addFlow(FlowDefine flowDefine) {
		iFlowDefineDao.addFlow(flowDefine);
	}

	@Override
	public List<FlowDefine> selectAllFlow() {
		return iFlowDefineDao.selectAllFlow();
	}

	@Override
	public FlowDefine selectFlowById(int id) {
		return iFlowDefineDao.selectFlowById(id);
	}

}
