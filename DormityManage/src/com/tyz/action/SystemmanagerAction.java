package com.tyz.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator.Success;
import com.tyz.model.Area;
import com.tyz.model.Building;
import com.tyz.model.Dormity;
import com.tyz.model.Systemmanager;
import com.tyz.service.BuildingService;
import com.tyz.service.SystemmanagerService;
import com.tyz.tool.PageBean;

import net.sf.json.JSONObject;

public class SystemmanagerAction extends ActionSupport implements ModelDriven<Systemmanager>{
	
	private Systemmanager systemmanager = new Systemmanager();
	@Override
	public Systemmanager getModel() {
		// TODO Auto-generated method stub
		return systemmanager;
	}
	
	private SystemmanagerService systemmanagerService;
	public void setSystemmanagerService(SystemmanagerService systemmanagerService) {
		this.systemmanagerService = systemmanagerService;
	}
	
	private String oldPwd;
	public void setOldPwd(String oldPwd) {
		this.oldPwd = oldPwd;
	}
	public String getOldPwd() {
		return oldPwd;
	}
	
	private String newPwd;
	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
	public String getNewPwd() {
		return newPwd;
	}
	
	private int page;
	public void setPage(int page) {
		if(page==0){
			page = 1;
		}
		this.page = page;
	}
	public int getPage() {
		if(page==0){
			page=1;
		}
		return page;
	}
	
	//返回json
	private String result;
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
	}
	
	private String bname;
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBname() {
		return bname;
	}
	
	public int ar_uid;
	public void setAr_uid(int ar_uid) {
		this.ar_uid = ar_uid;
	}
	public int getAr_uid() {
		return ar_uid;
	}
	
	public String sysid;
	public void setSysid(String sid) {
		this.sysid = sid;
	}
	public String getSysid() {
		return sysid;
	}
	
	private BuildingService buildingService;
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	public BuildingService getBuildingService() {
		return buildingService;
	}
	
	
	//按名字查找
	public String find(){
		int count = systemmanagerService.getCount(systemmanager.getName()); 
		if(count == 0){
			page = 0;
		}else{
		if(page==0)
			page=1;
		}
		PageBean<Systemmanager> pageBean = systemmanagerService.findAll(page,systemmanager.getName());
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "find";
	}
	
	//编辑界面
	public String edit(){
		List<Area> province = systemmanagerService.findProvince();
		ActionContext.getContext().getValueStack().set("province", province);
		
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist", list);
		
		systemmanager = systemmanagerService.findBySid(systemmanager.getSid());
		if(systemmanager.getGender().equals("男")){
			systemmanager.setGender("1");
		}else{
			systemmanager.setGender("0");
		}
		return "edit";
	}
	
	//修改成功
	public String updateSuccess(){
		
		if(systemmanager.getGender().equals("1")){
			systemmanager.setGender("男");
		}else{
			systemmanager.setGender("女");
		}
		systemmanager.setPwd(systemmanager.getPwd());
		
		Building building = buildingService.findByName(bname);
		systemmanager.setBuilding(building);
		systemmanager.setUsername(systemmanager.getName());
		systemmanagerService.update(systemmanager);	
		return "updateSuccess";
	}
	
	public String delete(){
		System.out.println(systemmanager.getSid());
		System.out.println("-------------------------");
		systemmanager = systemmanagerService.findBySid(systemmanager.getSid());
		systemmanagerService.delete(systemmanager);
		return "delete";
	}
	
	public String findCity(){
		List<Area> list = systemmanagerService.findCity(ar_uid);
		Map<String, String> map = new HashMap<>();
		List<String> list2 = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<list.size();i++){
			map.put(list.get(i).getAr_name(), list.get(i).getAr_name());
			//list2.add(list.get(i).getAr_name());
			sb.append(list.get(i).getAr_name()).append(" ");
		}
		JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
		result = json.toString();//给result赋值，传递给页面
		//result="xxx";
		return SUCCESS;
	}
	
	//登录
	public String login(){
		Systemmanager sysExist = systemmanagerService.login(systemmanager);
		ServletActionContext.getRequest().getSession()
		.setAttribute("sysExist", sysExist);
		if(sysExist!=null){
		if(sysExist.getRole()==0){
			return "loginSuccess";
		}else{
			return "dorLoginSuccess";
		}
		}else{
			this.addActionError("账户名或密码错误！");
			return "loginFail";
		}
	}
	
	//修改密码
	public String updatePwd(){
		Systemmanager sysExist = (Systemmanager) ServletActionContext.getRequest().getSession()
				.getAttribute("sysExist");
		if(oldPwd.endsWith(sysExist.getPwd())){
			sysExist.setPwd(newPwd);
			systemmanagerService.updatePwd(sysExist);
			
			ServletActionContext.getRequest().getSession()
			.setAttribute("sysExist", sysExist);
			
			return "updatePwdSuccsss";
		}
		this.addActionError("修改失败，旧密码错误");
		return "updatePwdFail";
	
	}
	
	//进入主界面
	public String index(){
		if(page==0)
			page=1;
		PageBean<Systemmanager> pageBean = systemmanagerService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "sysindex";
	}
	
	public String findProvince(){
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist", list);
		
		List<Area> province = systemmanagerService.findProvince();
		ActionContext.getContext().getValueStack().set("province", province);
		
		return "findProvince";
	}
	
	//退出
	public String  exit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "exitSuccess";
	}
	
	//添加管理员
	public String add(){
		Building building = buildingService.findByName(bname);
		if(systemmanager.getGender().equals("1")){
			systemmanager.setGender("男");
		}else{
			systemmanager.setGender("女");
		}
		systemmanager.setPwd("123");
		systemmanager.setBuilding(building);
		systemmanager.setRole(1);;
		systemmanager.setUsername(systemmanager.getName());
		systemmanagerService.add(systemmanager);
		return "addSuccess";
	}

}
