package com.tyz.service;

import java.sql.SQLException;
import java.util.List;

import com.tyz.dao.SystemmanagerDao;
import com.tyz.model.Area;
import com.tyz.model.Systemmanager;
import com.tyz.tool.PageBean;



public class SystemmanagerService {

	private SystemmanagerDao systemmanagerDao;
	public void setSystemmanagerDao(SystemmanagerDao systemmanagerDao) {
		this.systemmanagerDao = systemmanagerDao;
	}
	//登录
	public Systemmanager login(Systemmanager systemmanager) {
	
		return systemmanagerDao.login(systemmanager);
	}
	//修改密码
	
	public void updatePwd(Systemmanager sysExist) {
		systemmanagerDao.updatePwd(sysExist);
	}
	public PageBean<Systemmanager> findAll(int page) {
		PageBean<Systemmanager> pageBean = new PageBean<Systemmanager>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = systemmanagerDao.findAll();
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
		List<Systemmanager> list = systemmanagerDao.findPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public void add(Systemmanager systemmanager) {
		systemmanagerDao.add(systemmanager);
	}
	public List<Area> findProvince() {
		return systemmanagerDao.findProvince();
	}
	public List<Area> findCity(int ar_uid) {
		
		return systemmanagerDao.findCity(ar_uid);
	}
	public Systemmanager findBySid(int sid) {
		return systemmanagerDao.findBySid(sid);
	}
	public void delete(Systemmanager systemmanager) {
		systemmanagerDao.delete(systemmanager);
	}
	public void update(Systemmanager systemmanager) {
		systemmanagerDao.update(systemmanager);
	}
	public PageBean<Systemmanager> findAll(int page, String name) {
		PageBean<Systemmanager> pageBean = new PageBean<Systemmanager>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = systemmanagerDao.findAllName(name);
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
		List<Systemmanager> list = systemmanagerDao.findPage(name,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public int getCount(String name) {
		// TODO Auto-generated method stub
		return systemmanagerDao.findAllName(name);
	}
	
	
}
