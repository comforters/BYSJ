package com.xx.ssm.aop.advice;

import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import org.apache.ibatis.exceptions.PersistenceException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xx.ssm.anno.PermissionControl;
import com.xx.ssm.entity.Authority;
import com.xx.ssm.entity.Role;
import com.xx.ssm.entity.UserInfo;
import com.xx.ssm.service.IRoleService;

/**
 * ����֪ͨ
 * 
 * @author sir_li
 *
 */

// @Aspect �Ƕ�������
@Aspect
// @Component ����spring��������,��Ϊһ��spring���������
@Component
public class AuthAdvice {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpSession session;
	@Autowired
	private HttpServletResponse response;
	@Autowired
	private IRoleService roleService;

	@Pointcut("execution(@com.xx.ssm.anno.PermissionControl * *(..))")
	public void point() {
	}

	@Around("point()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		String classPath = point.getTarget().getClass().getName();
		String methodName = point.getSignature().getName();
		String methodPath = classPath + "." + methodName;
		System.out.println("Ȩ����֤�ķ���ȫ·��:"+methodPath);
		System.out.println("Ȩ����֤���ص�������uri:"+request.getRequestURI());
		System.out.println("Ȩ����֤���ص�������url:"+request.getRequestURL());
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		response.setCharacterEncoding("GBK");
		if (userInfo == null) {
			request.setAttribute("msg", "{authtype:'��ͨ��֤',authresult:'ʧ��'}");
			return "authresult";
		} else {
			List<Role> roles = userInfo.getRoles();
			boolean b=false;
			if (roles != null && roles.size() > 0) {
				a:for (Role role : roles) {
					// ���ݽ�ɫid��Ȩ���б�
					List<Role> list = roleService.listById(role.getId());
					for (Role role2 : list) {
						List<Authority> authorities= role2.getAuthorities();
						for (Authority authority : authorities) {
							System.out.println(authority.getMethodPath()+"??????");
							if(authority.getMethodPath().equals(methodPath)){
								b=true;
								break a;
							}
						}
					}
				}
			}
			if(b){ // ��֤ͨ��
				return point.proceed(); // ����Ŀ�귽��ִ��
			}else{
				request.setAttribute("msg", "{authtype:'��ͨ��֤',authresult:'ʧ��'}");
				return "authresult";
			}
			
		}
	}

}
