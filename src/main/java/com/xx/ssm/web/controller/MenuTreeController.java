package com.xx.ssm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IMenuTreeService;
import com.xx.ssm.service.IUserService;
@Controller
public class MenuTreeController {
	@Autowired
	private IMenuTreeService menuTreeService;
	@RequestMapping("tree")
	public String tree(Model model){
		String menuTreeJson = menuTreeService.getTreeJson(0);
		model.addAttribute("treeJson", menuTreeJson);
		return  "tree_data";
	}
}
