package com.tyz.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tyz.model.Building;
import com.tyz.model.Dormity;
import com.tyz.model.Systemmanager;
import com.tyz.service.BuildingService;
import com.tyz.service.DormityService;
import com.tyz.tool.PageBean;

public class BuildingAction extends ActionSupport implements ModelDriven<Building>{

	private Building building = new Building();
	@Override
	public Building getModel() {
		// TODO Auto-generated method stub
		return building;
	}
	
	private BuildingService buildingService;
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	public BuildingService getBuildingService() {
		return buildingService;
	}
	
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
	public String findAll(){
		PageBean<Building> pageBean = buildingService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findAll";
	} 
	public String add(){
		return "add";
	}
	public String addbuild(){
		buildingService.add(building);
		building = buildingService.findByName(building.getName());
		for(int i=0;i<5;i++){
			Dormity dormity = new Dormity();
			dormity.setBuilding(building);
			dormity.setCount(0);
			dormity.setNum("B10"+i);
			dormity.setType("空闲");
			System.out.println(dormity.toString());
			System.out.println("--------------------------------");
			dormityService.save(dormity);
			System.out.println(dormity.toString());
		}
		return "addbuild";
	}
	
	
	public String edit(){
		building = buildingService.findByBid(building.getBid()); 
		return "edit";
	}
	public String editSuccess(){
		buildingService.update(building);
		return "editSuccess";
	}
	public String delete(){
		buildingService.delete(building);
		return "delete";
	}
	
}
