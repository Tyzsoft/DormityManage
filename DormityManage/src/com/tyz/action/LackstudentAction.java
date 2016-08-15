package com.tyz.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tyz.model.Building;
import com.tyz.model.Dormity;
import com.tyz.model.Lackstudent;
import com.tyz.model.Student;
import com.tyz.service.BuildingService;
import com.tyz.service.DormityService;
import com.tyz.service.LackstudentService;
import com.tyz.service.StudentService;
import com.tyz.tool.PageBean;

public class LackstudentAction extends ActionSupport implements ModelDriven<Lackstudent>{

	private Lackstudent lackstudent = new Lackstudent();
	@Override
	public Lackstudent getModel() {
		// TODO Auto-generated method stub
		return lackstudent;
	}
	
	private LackstudentService lackstudentService;
	public void setLackstudentService(LackstudentService lackstudentService) {
		this.lackstudentService = lackstudentService;
	}
	public LackstudentService getLackstudentService() {
		return lackstudentService;
	}
	
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	public int getPage() {
		return page;
	}
	
	private BuildingService buildingService;
	public void setBuildingService(BuildingService buildingService) {
		this.buildingService = buildingService;
	}
	public BuildingService getBuildingService() {
		return buildingService;
	}
	private DormityService dormityService;
	public void setDormityService(DormityService dormityService) {
		this.dormityService = dormityService;
	}
	public DormityService getDormityService() {
		return dormityService;
	}
	private String name;
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	private String dor;
	public void setDor(String dor) {
		this.dor = dor;
	}
	public String getDor() {
		return dor;
	}
	
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
	}
	
	public String findAll(){

		PageBean<Lackstudent> pageBean = lackstudentService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		SimpleDateFormat format =new SimpleDateFormat ("yyyy-mm-dd HH:mm:ss");
		return "findAll";
	}
	
	public String add(){
		
		List<Building> list = buildingService.find();
		List<String> allList = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			List<Dormity> daList = dormityService.findAlldor(list.get(i).getBid());
			if(daList!=null){
				for(int j=0;j<daList.size();j++){
					System.out.println(list.get(i).getName()+"-"+daList.get(j).getNum());
					allList.add(list.get(i).getName()+"-"+daList.get(j).getNum());
				}
			}
			
		}
		ActionContext.getContext().getValueStack().set("allList",allList);
		
		return "add";
	}
	
	public String addlack(){
		String [] newdor = dor.split("-");
		String build = newdor[0];//宿舍楼名
		String dorm = newdor[1];//寝室号
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		lackstudent.setTime(new Date());
		Student student = studentService.find(name,build,dorm);
		lackstudent.setStudent(student);
		lackstudentService.add(lackstudent);
		student.setState("请假");
		studentService.update(student);
		
		return "addlack";
	}
	
	public String cancel(){
	
		lackstudent = lackstudentService.findBylid(lackstudent.getLid());
		Student student = lackstudent.getStudent();
		student.setState("正常");
		studentService.update(student);
		return "cancel";
	}
	
	public String find(){
		PageBean<Lackstudent> pageBean = lackstudentService.findByName(name,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "find";
	}
}
