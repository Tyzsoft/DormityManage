package com.tyz.service;

import java.util.List;

import com.tyz.dao.DormityDao;
import com.tyz.model.Building;
import com.tyz.model.Dormity;
import com.tyz.tool.PageBean;

public class DormityService {

	private DormityDao dormityDao;
	public void setDormityDao(DormityDao dormityDao) {
		this.dormityDao = dormityDao;
	}
	public DormityDao getDormityDao() {
		return dormityDao;
	}
	public PageBean<Dormity> findAll(int page) {
		PageBean<Dormity> pageBean = new PageBean<Dormity>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = dormityDao.findAll();
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
		List<Dormity> list = dormityDao.findPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Dormity> findAll(String bname, int page) {
		PageBean<Dormity> pageBean = new PageBean<Dormity>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = dormityDao.findAll(bname);
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
		List<Dormity> list = dormityDao.findPage(bname,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public int findCount(String bname) {
		
		return dormityDao.findAll(bname);
	}
	public List<Dormity> finddor(int bid) {
		
		return dormityDao.finddor(bid);
	}
	public Dormity findByNumAndBid(String dorm, int bid) {
		return dormityDao.findByNumAndBid(dorm,bid);
	}
	public void update(Dormity dormity) {
		// TODO Auto-generated method stub
		dormityDao.update(dormity);
	}
	public List<Dormity> findAlldor(int i) {
		return dormityDao.findAlldor(i);
	}
	public Dormity findByDid(int did) {
		
		return dormityDao.findByDid(did);
	}
	public void save(Dormity dormity) {
		dormityDao.save(dormity);
	}
	
}
