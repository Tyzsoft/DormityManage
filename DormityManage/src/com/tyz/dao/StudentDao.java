package com.tyz.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tyz.model.Building;
import com.tyz.model.Student;
import com.tyz.tool.PageHibernateCallback;

public class StudentDao extends HibernateDaoSupport{

	public int findAll() {
		String hql = "select count(*) from Student";
		List<Long> list = this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Student> findPage(int begin, int limit) {
		String hql = "from Student ";
		List<Student> list =  (List<Student>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public void save(Student student) {
		this.getHibernateTemplate().save(student);
	}

	public Student findBySid(int sid) {
		String hql = "from Student where sid = ?";
		return this.getHibernateTemplate().get(Student.class, sid);
	}

	public void update(Student student) {
		this.getHibernateTemplate().update(student);
	}

	public int find(String build, String dorm) {
		String hql = "select count(*) from Student s where s.dormity.num=? and s.dormity.building.name=?";
		List<Long> list = this.getHibernateTemplate().find(hql,dorm,build);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Student> findPage(String build, String dorm, int begin, int limit) {
		String hql = "from Student s where s.dormity.num=? and s.dormity.building.name=?";
		List<Student> list = (List<Student>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {dorm,build},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public int find(String name) {
		String hql = "select count(*) from Student  where name like ?";
		List<Long> list = this.getHibernateTemplate().find(hql,"%"+name+"%");
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Student> findPage(String name, int begin, int limit) {
		String hql = "from Student  where name like ?";
		List<Student> list = (List<Student>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {"%"+name+"%"},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public int find(String name, String build, String dorm) {
		String hql = "select count(*) from Student s where s.dormity.num=? and s.dormity.building.name=? and s.name like ?";
		List<Long> list = this.getHibernateTemplate().find(hql,dorm,build,"%"+name+"%");
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Student> findPage(String build, String dorm, String name, int begin, int limit) {
		String hql = "from Student s where s.dormity.num=? and s.dormity.building.name=? and s.name like ?";
		List<Student> list = (List<Student>) this.getHibernateTemplate().execute(
				new PageHibernateCallback(hql, new Object[] {dorm,build,"%"+name+"%"},
						begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public Student findBy(String name, String build, String dorm) {
		String hql = "from Student s where s.dormity.num=? and s.dormity.building.name=? and s.name =? ";
		List<Student> list = this.getHibernateTemplate().find(hql, dorm,build,name);
		if(list.size()>0&&list!=null){
			return list.get(0);
		}
		return null;
	}

	public void delete(Student stu) {
		this.getHibernateTemplate().delete(stu);
	}

	public Student findName(String name) {
		String hql = "from Student where name=?"; 
		return (Student) this.getHibernateTemplate().find(hql, name);
	}

}
