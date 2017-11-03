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
 * 定义通知
 * 
 * @author sir_li
 *
 */

// @Aspect 是定义切面
@Aspect
// @Component 交给spring容器管理,成为一个spring容器的组件
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
		System.out.println("权限认证的方法全路径:"+methodPath);
		System.out.println("权限认证拦截到的请求uri:"+request.getRequestURI());
		System.out.println("权限认证拦截到的请求url:"+request.getRequestURL());
		UserInfo userInfo = (UserInfo) session.getAttribute("userInfo");
		response.setCharacterEncoding("GBK");
		if (userInfo == null) {
			request.setAttribute("msg", "{authtype:'普通认证',authresult:'失败'}");
			return "authresult";
		} else {
			List<Role> roles = userInfo.getRoles();
			boolean b=false;
			if (roles != null && roles.size() > 0) {
				a:for (Role role : roles) {
					// 根据角色id查权限列表
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
			if(b){ // 验证通过
				return point.proceed(); // 继续目标方法执行
			}else{
				request.setAttribute("msg", "{authtype:'普通认证',authresult:'失败'}");
				return "authresult";
			}
			
		}
	}

}
