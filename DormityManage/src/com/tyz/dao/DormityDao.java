package com.tyz.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyz.model.Building;
import com.tyz.model.Dormity;
import com.tyz.tool.PageHibernateCallback;

public class DormityDao extends HibernateDaoSupport{

	public int findAll() {
		String hql = "select count(*) from Dormity";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Dormity> findPage(int begin, int limit) {
		String hql = "from Dormity";
		List<Dormity> list = (List<Dormity>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public int findAll(String bname) {
		String hql = "SELECT COUNT(*) FROM Dormity d WHERE d.building.name=?";
		List<Long> list = this.getHibernateTemplate().find(hql,bname);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Dormity> findPage(String bname, int begin, int limit) {
		String hql = "FROM Dormity d WHERE d.building.name=?";
		List<Dormity> list = (List<Dormity>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {bname},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public List<Dormity> finddor(int bid) {
		String hql = "FROM Dormity d WHERE d.building.bid = ? AND d.count < 4";
		List<Dormity> list = this.getHibernateTemplate().find(hql, bid);
		return list;
	}

	public Dormity findByNumAndBid(String dorm, int bid) {
		String hql = "from Dormity d where d.num =? and d.building.bid = ?";
		List<Dormity> list = this.getHibernateTemplate().find(hql,dorm,bid);
		return list.get(0);
	}

	public void update(Dormity dormity) {
		// TODO Auto-generated method stub
		 this.getHibernateTemplate().update(dormity);
	}

	public List<Dormity> findAlldor(int i) {
		String hql = "FROM Dormity d WHERE d.building.bid = ? ";
		List<Dormity> list = this.getHibernateTemplate().find(hql, i);
		return list;
	}

	public Dormity findByDid(int did) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(Dormity.class, did);
	}

	public void save(Dormity dormity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(dormity);
	}

}
