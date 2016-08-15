package com.tyz.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyz.model.Building;
import com.tyz.model.Lackstudent;
import com.tyz.tool.PageHibernateCallback;

public class LackstudentDao extends HibernateDaoSupport{

	public int findAll() {
		String hql = "select count(*) from Lackstudent";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Lackstudent> findPage(int begin, int limit) {
		String hql = "from Lackstudent";
		List<Lackstudent> list = (List<Lackstudent>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public void add(Lackstudent lackstudent) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(lackstudent);
	}

	public Lackstudent find(int lid) {
		return this.getHibernateTemplate().get(Lackstudent.class, lid);
	}

	public int findAll(String name) {
		String hql = "select count(*) from Lackstudent l  where l.student.name like ?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+name+"%");
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Lackstudent> findPage(String name, int begin, int limit) {
		String hql = "from Lackstudent l  where l.student.name like ?";
		List<Lackstudent> list = (List<Lackstudent>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {"%"+name+"%"},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<Lackstudent> findBySid(int sid) {
		String hql = "from Lackstudent l  where l.student.sid =?";
		return this.getHibernateTemplate().find(hql, sid);
	}

	public void delete(Lackstudent lackstudent) {
		this.getHibernateTemplate().delete(lackstudent);
	}

}
