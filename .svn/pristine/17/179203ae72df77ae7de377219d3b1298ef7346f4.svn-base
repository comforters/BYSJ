package com.xx.ssm.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.github.pagehelper.PageInfo;

public class PageTag extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		PageInfo pageInfo=(PageInfo) getJspContext().findAttribute("pageInfo");
		System.out.println(pageInfo);
		JspWriter out = getJspContext().getOut();
		//Displaying 1 to 10 of 114 items
		String str="<div class=\"easyui-panel\"><div class=\"easyui-pagination\" data-options=\"total: "+pageInfo.getTotal()+",pageSize:"+pageInfo.getPageSize()+",showPageList: true,pageList:[5,10,15],showRefresh: false,beforePageText:'第',afterPageText:'页 共 {pages} 页',pageNumber:"+pageInfo.getPageNum()+",onSelectPage:function(pageNumber,pageSize){window.location.href='?pageSize='+pageSize+'&pageNum='+pageNumber;},displayMsg: '显示"+((pageInfo.getPageNum()-1)*pageInfo.getPageSize()+1)+"到"+pageInfo.getEndRow()+",共"+pageInfo.getTotal()+"条'\"></div></div>";
		out.write(str);
	}
}
