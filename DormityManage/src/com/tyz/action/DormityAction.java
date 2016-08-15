package com.tyz.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.tyz.model.Building;
import com.tyz.model.Dormity;
import com.tyz.service.BuildingService;
import com.tyz.service.DormityService;
import com.tyz.tool.PageBean;

public class DormityAction extends ActionSupport {

	private DormityService dormityService;
	public void setDormityService(DormityService dormityService) {
		this.dormityService = dormityService;
	}
	public DormityService getDormityService() {
		return dormityService;
	}
	
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	public int getPage() {
		return page;
	}
	
	private BuildingService buildingService;
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	public BuildingService getBuildingService() {
		return buildingService;
	}
	
	private String bname;
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBname() {
		return bname;
	}
	
	public String findByname(){
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist", list);
		int count = dormityService.findCount(bname);
		if(count==0){
			page=0;
		}
		PageBean<Dormity> pageBean = dormityService.findAll(bname,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findByname";
	}
	
	public String findAll(){
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist", list);
		PageBean<Dormity> pageBean = dormityService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findAll";
	}
}
