package com.tyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyz.model.Area;
import com.tyz.model.Systemmanager;
import com.tyz.tool.PageHibernateCallback;






public class SystemmanagerDao extends HibernateDaoSupport{

	public Systemmanager login(Systemmanager systemmanager) {
		String hql = "from Systemmanager where username = ? and pwd = ?";
		List<Systemmanager> list = this.getHibernateTemplate().find(hql, systemmanager.getUsername(),systemmanager.getPwd());;
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}


	public void updatePwd(Systemmanager sysExist) {
		this.getHibernateTemplate().update(sysExist);
	}


	public int findAll() {
		String hql = "select count(*) from Systemmanager";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}


	public List<Systemmanager> findPage(int begin, int limit) {
		String hql = "from Systemmanager ";
		List<Systemmanager> list = (List<Systemmanager>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}


	public void add(Systemmanager systemmanager) {
		this.getHibernateTemplate().save(systemmanager);
	}


	public List<Area> findProvince() {
		String hql = "FROM Area WHERE ar_uid = 0";
		List<Area> list = this.getHibernateTemplate().find(hql);
		return list;
	}


	public List<Area> findCity(int ar_uid) {
		String hql = "FROM Area WHERE ar_uid =(SELECT ar_id FROM Area WHERE ar_id = ?)";
		List<Area> list = this.getHibernateTemplate().find(hql, ar_uid);
		return list;
	}


	public Systemmanager findBySid(int sid) {
		String hql = "FROM Systemmanager WHERE sid =?";
		return this.getHibernateTemplate().get(Systemmanager.class, sid);
		
	}


	public void delete(Systemmanager systemmanager) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(systemmanager);
	}


	public void update(Systemmanager systemmanager) {
		this.getHibernateTemplate().update(systemmanager);
	}


	public int findAllName(String name) {
		String hql = "SELECT COUNT(*) FROM Systemmanager WHERE name LIKE ? ";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+name+"%");
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}


	public List<Systemmanager> findPage(String name, int begin, int limit) {
		String hql = "from Systemmanager WHERE name LIKE ?";
		List<Systemmanager> list = (List<Systemmanager>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {"%"+name+"%"},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}


	

	
}
