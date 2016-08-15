package com.tyz.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.tyz.model.Systemmanager;



public class PrivilegeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		Systemmanager systemmanager = (Systemmanager) ServletActionContext.getRequest()
				.getSession().getAttribute("sysExist");
		if(systemmanager != null){
			
			return actionInvocation.invoke();
		}else{
			
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("您还没有登录!没有权限访问!");
			return "loginFail";
		}
	}

}
