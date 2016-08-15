package com.tyz.service;

import java.util.List;

import com.tyz.dao.BuildingDao;
import com.tyz.model.Building;
import com.tyz.model.Systemmanager;
import com.tyz.tool.PageBean;

public class BuildingService {

	private BuildingDao buildingDao;
	public void setBuildingDao(BuildingDao buildingDao) {
		this.buildingDao = buildingDao;
	}
	public BuildingDao getBuildingDao() {
		return buildingDao;
	}
	public PageBean<Building> findAll(int page) {
		PageBean<Building> pageBean = new PageBean<Building>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = buildingDao.findAll();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合:
		int begin = (page - 1)*limit;
		List<Building> list = buildingDao.findPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public void add(Building building) {
		buildingDao.add(building);
	}
	public Building findByBid(int bid) {
		return buildingDao.findByBid(bid);
	}
	public void update(Building building) {
		buildingDao.update(building);
	}
	public void delete(Building building) {
		buildingDao.delete(building);
		
	}
	public List<Building> find() {
		return buildingDao.find();
	}
	public Building findByName(String build) {
		return buildingDao.findByName(build);
	}
	
}
