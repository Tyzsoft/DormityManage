package com.tyz.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyz.model.Building;
import com.tyz.model.Systemmanager;
import com.tyz.tool.PageHibernateCallback;

public class BuildingDao extends HibernateDaoSupport{

	public int findAll() {
		String hql = "select count(*) from Building";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public  List<Building> findPage(int begin, int limit) {
		String hql = "from Building ";
		List<Building> list = (List<Building>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public void add(Building building) {
		this.getHibernateTemplate().save(building);
	}

	public Building findByBid(int bid) {
		String hql = "from Building where bid=?" ;
		return this.getHibernateTemplate().get(Building.class, bid);
		
	}

	public void update(Building building) {
		this.getHibernateTemplate().update(building);
	}

	public void delete(Building building) {
		this.getHibernateTemplate().delete(building);
	}

	public List<Building> find() {
		String hql= "from Building";
		List<Building> list = this.getHibernateTemplate().find(hql);
		return list;
	}

	public Building findByName(String build) {
		String hql = "from Building where name=?" ;
		List<Building> list = this.getHibernateTemplate().find(hql, build);
		return list.get(0);
	}

	

}
