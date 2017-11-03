package com.xx.ssm.web.controller;
import java.util.ArrayList;
import java.util.HashMap;
/*
 * 1  com.xx.ssm.web.controller.UserInfoController.index
 */
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.xx.ssm.anno.PermissionControl;
import com.xx.ssm.entity.FlowDefine;
import com.xx.ssm.entity.FlowNode;
import com.xx.ssm.entity.PageBean;
import com.xx.ssm.entity.RoleData;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IFlowDefineService;
import com.xx.ssm.service.IFlowNodeService;
import com.xx.ssm.service.IRoleDataService;
import com.xx.ssm.service.IUserService;
import com.xx.ssm.web.model.JsonModel;
import com.xx.ssm.web.model.Nodes;

import net.sf.json.JSONObject;
@Controller
public class UserInfoController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IFlowDefineService iFlowDefineService;
	@Autowired
	private IFlowNodeService iFlowNodeService;
	@Autowired
	private IRoleDataService iRoleDataService;
	@RequestMapping("login")
	public String login(UserInfo userInfo,WebRequest webRequest){
		System.out.println(userInfo);
		userInfo =userService.login(userInfo);
		System.out.println(userInfo);
		webRequest.setAttribute("userinfo", userInfo, webRequest.SCOPE_SESSION);
		return "main";
	}
	@RequestMapping("userList")
	public String userList(Model model,PageBean pageBean){
		PageHelper.startPage(pageBean.getPageNum(),pageBean.getPageSize());
		List<UserInfo> list= userService.list();
		for (UserInfo userInfo : list) {
			System.out.println(userInfo);
		}
		PageInfo pageInfo = new PageInfo(list);
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("list", list);
		return "userList";
	}
	@RequestMapping("leavesheet")
	public String leavesheet(){
		return "leavesheet";
	}
	@RequestMapping("flowmanage")
	public String leavesheet1(Model model){
		List<FlowDefine> list= iFlowDefineService.selectAllFlow();
		model.addAttribute("list",list);
		return "flowmanage";
	}
	@RequestMapping("page.do")
	public void json(@RequestBody() Map<String, String> map) {
		try {
			System.out.println("map:" + map);
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(map);
			System.out.println("jaon:" + json);
			System.out.println("----------------");
			// map转jsonObject对象
			JSONObject jObj=JSONObject.fromObject(map);
			// 获取jsonObject对象里面的key值
			Set<String> set = jObj.keySet();
			for (String key : set) {
				System.out.println("key=" + key);
			}
			System.out.println("----------------");
			// 获取key值对应的value
			String title = jObj.getString("title");
			//新增工作流
			FlowDefine flowDefine=new FlowDefine();
			flowDefine.setFlowName(title);
			flowDefine.setJsonData(json);
			System.out.println("正在添加新的流程-----");
			System.out.println(flowDefine);
			iFlowDefineService.addFlow(flowDefine);
			
			System.out.println("----------------");
			// 获取二级json里面的内容
			JSONObject jObjnode = jObj.getJSONObject("nodes");
			System.out.println("jObj1" + jObjnode);
			// 获取三级json里面的内容
			JSONObject nodejObj1 = jObjnode.getJSONObject("demo_node_61");
			JSONObject nodejObj2 = jObjnode.getJSONObject("demo_node_62");
			JSONObject nodejObj3 = jObjnode.getJSONObject("demo_node_63");
			JSONObject nodejObj4 = jObjnode.getJSONObject("demo_node_64");
			//将node节点转为对象
			Gson gson=new Gson();
			Nodes demo_node_61=gson.fromJson(nodejObj1.toString(), Nodes.class);
			Nodes demo_node_62=gson.fromJson(nodejObj2.toString(), Nodes.class);
			Nodes demo_node_63=gson.fromJson(nodejObj3.toString(), Nodes.class);
			Nodes demo_node_64=gson.fromJson(nodejObj4.toString(), Nodes.class);
			List<Nodes> list=new ArrayList<>();
			list.add(demo_node_61);
			list.add(demo_node_62);
			list.add(demo_node_63);
			list.add(demo_node_64);
			List<RoleData> list2= iRoleDataService.selectUserRole();
			for(int i=0;i<list.size();i++){
				String nodeName=list.get(i).getName();
				for(int j=0;j<list2.size();j++){
					if(nodeName.equals(list2.get(j).getNodeName())){
						list.get(i).setRoleId(list2.get(j).getRoleId());
						list.get(i).setUserId(list2.get(j).getUserId());
					}
				}
			}
			System.out.println("正在存储节点信息-----");
			for (Nodes nodes : list) {
				System.out.println(nodes);
			}
			//将节点对象存进数据库
			for(int i=0;i<list.size();i++){
				FlowNode flowNode=new FlowNode();
				flowNode.setId(i+1);
				flowNode.setNodeName(list.get(i).getName());
				flowNode.setNodeType(list.get(i).getType());
				flowNode.setNextNodeId(i+2);
				flowNode.setPrevNodeId(i);
				flowNode.setApproverRoleId(list.get(i).getRoleId());
				flowNode.setApproverUserId(list.get(i).getUserId());
				flowNode.setDefid(1);
				iFlowNodeService.addNode(flowNode);
			}
			
			System.out.println("----------------");
			JSONObject jObjline = jObj.getJSONObject("lines");
			System.out.println(jObjline);
			JSONObject linejObj1 = jObjline.getJSONObject("demo_line_65");
			JSONObject linejObj2 = jObjline.getJSONObject("demo_line_66");
			JSONObject linejObj3 = jObjline.getJSONObject("demo_line_67");
			System.out.println("demo_line_65:" + linejObj1);
			System.out.println("demo_line_66:" + linejObj2);
			System.out.println("demo_line_67:" + linejObj3);
			// 获取每个节点里面的内容

		} catch (Exception e) {
			System.out.println("json转换失败：" + e);
		}
	}

}
