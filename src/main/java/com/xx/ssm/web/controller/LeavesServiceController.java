package com.xx.ssm.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.xx.ssm.entity.FlowDefine;
import com.xx.ssm.entity.FlowInstance;
import com.xx.ssm.entity.FlowNode;
import com.xx.ssm.entity.RoleData;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IFlowDefineService;
import com.xx.ssm.service.IFlowInstanceService;
import com.xx.ssm.service.IFlowNodeService;
import com.xx.ssm.service.IRoleDataService;
import com.xx.ssm.web.model.NodeId;
import com.xx.ssm.web.model.RoleDataModel;

@Controller
public class LeavesServiceController {
	@Autowired
	private IFlowInstanceService iFlowInstanceService;
	@Autowired
	private IFlowNodeService iFlowNodeService;
	@Autowired
	private IRoleDataService iRoleDataService;
	@Autowired
	private IFlowDefineService iFlowDefineService;
	@RequestMapping("ask.do")
	public String addRequest(Model model, int id){
		FlowInstance flowInstance=new FlowInstance();
		flowInstance.setUserId(id);
		flowInstance.setDefid(1);
		flowInstance.setCurrentNodeId(1);
		flowInstance.setNextNodeId(2);
		flowInstance.setStatus("正在审批~~");
		flowInstance.setServiceUrl("");
		iFlowInstanceService.addAsk(flowInstance);
		List<FlowInstance> list= iFlowInstanceService.selectAsk(id);
		model.addAttribute("list",list);
		return "waitthing";
	}
	@RequestMapping("waitthing")
	public String waitThings(HttpServletRequest request,Model model){
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userinfo");
		int id=userInfo.getId();
		int defid=1;
		List<FlowInstance> list= iFlowInstanceService.selectAsk(id);//待申请事件
		FlowNode flowNode= iFlowNodeService.selectNodeById(id, defid);
		int nodeId=flowNode.getId();
		List<FlowInstance> list2=iFlowInstanceService.selectAskByNode(nodeId);//待处理事件
		model.addAttribute("list",list);
		model.addAttribute("list2",list2);
		return "waitthing";
	}
	@RequestMapping("nextnode")
	public @ResponseBody String waitThingss(@RequestBody() Map<String, String> map) throws NumberFormatException{
		String string=map.get("id");
		int nextId=Integer.parseInt(string);
		int defid=1;
		FlowNode flowNode= iFlowNodeService.selectNode(nextId, defid);
		System.out.println(flowNode);
		String nextName=flowNode.getNodeName();
		return nextName;
	}
	@RequestMapping("delAsk.do")
	public String delAsks(int id,HttpServletRequest request,Model model){
	    UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userinfo");
		int userid=userInfo.getId();
		iFlowInstanceService.delAsk(id);
		List<FlowInstance> list= iFlowInstanceService.selectAsk(userid);
		model.addAttribute("list",list);
		return "waitthing";
	}
	@RequestMapping("ok.do")
	public String agreeAsk(int id,HttpServletRequest request,Model model){
		UserInfo userInfo=(UserInfo)request.getSession().getAttribute("userinfo");
		int userId=userInfo.getId();
		int defid=1;
		FlowNode flowNode= iFlowNodeService.selectNodeById(userId, defid);
		int flowId=flowNode.getId();
		int next=flowId+1;
		System.out.println(id);
		if(next==5){
			iFlowInstanceService.editEndFlowById(flowId, next, id);
		}else {
			iFlowInstanceService.editFlowById(flowId, next, id);
		}		
		List<FlowInstance> list= iFlowInstanceService.selectAsk(flowId);
		model.addAttribute("list",list);
		return "waitthing";
	}
	@RequestMapping("gooflow")
	public String seeGooflow(int id,Model model){
		FlowDefine flowDefine=iFlowDefineService.selectFlowById(id);
		System.out.println(flowDefine);
		model.addAttribute("jsonData",flowDefine.getJsonData());
		return "seeflow";
	}
	@RequestMapping("saverole")
	public  void saveRoles(@RequestBody() RoleDataModel roleDataModel ){
		RoleData roleData=new RoleData();
		roleData.setNodeName(roleDataModel.getNodeName());
		roleData.setRoleId(roleDataModel.getRoleId());
		roleData.setUserId(roleDataModel.getUserId());
		iRoleDataService.addUserRole(roleData);
		System.out.println("节点信息存储中-----");
	}
	@RequestMapping("getRole")
	public @ResponseBody RoleData getUserRole(@RequestBody() Map<String, String> map){
		String string=map.get("name");
		RoleData roleData= iRoleDataService.selectUserByName(string);
		return roleData;
	}
	@RequestMapping("addFlow")
	public String addflow(){
		return "gooflow";
	}
}
