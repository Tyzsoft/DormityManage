package com.tyz.service;

import java.util.List;

import com.tyz.dao.LackstudentDao;
import com.tyz.model.Building;
import com.tyz.model.Lackstudent;
import com.tyz.tool.PageBean;

public class LackstudentService {

	private LackstudentDao lackstudentDao;
	public void setLackstudentDao(LackstudentDao lackstudentDao) {
		this.lackstudentDao = lackstudentDao;
	}
	public LackstudentDao getLackstudentDao() {
		return lackstudentDao;
	}
	public PageBean<Lackstudent> findAll(int page) {
		PageBean<Lackstudent> pageBean = new PageBean<Lackstudent>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = lackstudentDao.findAll();
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
		List<Lackstudent> list = lackstudentDao.findPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public void add(Lackstudent lackstudent) {
		lackstudentDao.add(lackstudent);
	}
	public Lackstudent findBylid(int lid) {
		
		return lackstudentDao.find(lid);
	}
	public PageBean<Lackstudent> findByName(String name, int page) {
		PageBean<Lackstudent> pageBean = new PageBean<Lackstudent>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = lackstudentDao.findAll(name);
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
		List<Lackstudent> list = lackstudentDao.findPage(name,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public List<Lackstudent> findBySid(int sid) {
		
		return lackstudentDao.findBySid(sid);
	}
	public void delete(Lackstudent lackstudent) {
		// TODO Auto-generated method stub
		lackstudentDao.delete(lackstudent);
	}
	
}
