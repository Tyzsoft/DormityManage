package com.tyz.service;

import java.util.List;

import com.tyz.dao.StudentDao;
import com.tyz.model.Building;
import com.tyz.model.Student;
import com.tyz.tool.PageBean;

public class StudentService {

	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	public StudentDao getStudentDao() {
		return studentDao;
	}
	public PageBean<Student> findAll(int page) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = studentDao.findAll();
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
		List<Student> list = studentDao.findPage(begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public void save(Student student) {
		studentDao.save(student);
	}
	public Student findBySid(int sid) {
		// TODO Auto-generated method stub
		return studentDao.findBySid(sid);
	}
	public void update(Student student) {
		studentDao.update(student);
	}
	public PageBean<Student> find(String build, String dorm, int page) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = studentDao.find(build,dorm);
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
		List<Student> list = studentDao.findPage(build,dorm,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public int findCount(String dorm, String build) {
		// TODO Auto-generated method stub
		return studentDao.find(build,dorm);
	}
	public PageBean<Student> findByName(String name, int page) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = studentDao.find(name);
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
		List<Student> list = studentDao.findPage(name,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public PageBean<Student> find(String build, String dorm, String name, int page) {
		PageBean<Student> pageBean = new PageBean<Student>();
		// 设置当前页数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		// 显示5个
		int limit = 5;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = 0;
		totalCount = studentDao.find(name,build,dorm);
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
		List<Student> list = studentDao.findPage(build,dorm,name,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	public int findCount(String name) {
		// TODO Auto-generated method stub
		return studentDao.find(name);
	}
	public int findCount(String build, String dorm, String name) {
		// TODO Auto-generated method stub
		return studentDao.find(name, build, dorm);
	}
	public Student find(String name, String build, String dorm) {
		
		return studentDao.findBy(name,build,dorm);
	}
	public void delete(Student stu) {
		studentDao.delete(stu);
	}
	public Student findName(String name) {
		return studentDao.findName(name);
	}
	
}
