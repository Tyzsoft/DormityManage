package com.tyz.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator.Success;
import com.tyz.model.Area;
import com.tyz.model.Dormity;
import com.tyz.service.DormityService;
import com.tyz.service.SystemmanagerService;

import net.sf.json.JSONObject;

public class JsonAction  {

	public String result;
	public void setReeult(String result) {
		this.result = result;
	}
	public String getReeult() {
		return result;
	}

	private SystemmanagerService systemmanagerService;
	public SystemmanagerService getSystemmanagerService() {
		return systemmanagerService;
	}
	public void setSystemmanagerService(SystemmanagerService systemmanagerService) {
		this.systemmanagerService = systemmanagerService;
	}
	private int ar_uid;
	public void setAr_uid(int ar_uid) {
		this.ar_uid = ar_uid;
	}
	public int getAr_uid() {
		return ar_uid;
	}
	
	
	public String findCity(){
		List<Area> list = systemmanagerService.findCity(ar_uid);
		Map<String, String> map = new HashMap<>();
		List<String> list2 = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
//			map.put(list.get(i).getAr_name(), list.get(i).getAr_name());
//			//list2.add(list.get(i).getAr_name());
			sb.append(list.get(i).getAr_name()).append(" ");
		}
		map.put("name", "1");
		//JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
		//request.put("json", json.toString());
		result = sb.toString();
		
		return "success";
	}

	
	
	
}
