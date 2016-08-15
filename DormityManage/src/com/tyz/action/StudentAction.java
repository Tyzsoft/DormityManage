package com.tyz.action;

import java.util.ArrayList;
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

public class StudentAction extends ActionSupport implements ModelDriven<Student>{

	private Student student = new Student();
	@Override
	public Student getModel() {
		// TODO Auto-generated method stub
		return student;
	}
	
	private StudentService studentService;
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	public StudentService getStudentService() {
		return studentService;
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
	
	private String dor;
	public void setDor(String dor) {
		this.dor = dor;
	}
	public String getDor() {
		return dor;
	}
	
	private String sid;
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSid() {
		return sid;
	}
	
	private LackstudentService lackstudentService;
	public void setLackstudentService(LackstudentService lackstudentService) {
		this.lackstudentService = lackstudentService;
	}
	public LackstudentService getLackstudentService() {
		return lackstudentService;
	}
	
	//退寝
	public String delete(){
		
		student = studentService.findBySid(student.getSid());
		Dormity dor = dormityService.findByDid(student.getDormity().getDid());
		List<Lackstudent> list = lackstudentService.findBySid(student.getSid());
		for(int i=0;i<list.size();i++){
			lackstudentService.delete(list.get(i));
		}
		
		dor.setCount(dor.getCount()-1);
		
		dormityService.update(dor);
		
		studentService.delete(student);
		return "delete";
	}
	
	public String findAll(){
		PageBean<Student> pageBean = studentService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist",list);
		List<String> dbList = new ArrayList<String>();
		List<String> allList = new ArrayList<String>();
		
		for(int i=0;i<list.size();i++){
			List<Dormity> dList = dormityService.finddor(list.get(i).getBid());
			if(dList!=null){
				for(int j=0;j<dList.size();j++){
					dbList.add(list.get(i).getName()+"-"+dList.get(j).getNum());
				}
			}
			
			List<Dormity> daList = dormityService.findAlldor(list.get(i).getBid());
			if(daList!=null){
				for(int j=0;j<daList.size();j++){
					System.out.println(list.get(i).getName()+"-"+daList.get(j).getNum());
					allList.add(list.get(i).getName()+"-"+daList.get(j).getNum());
				}
			}
			
		}
		
		
		ActionContext.getContext().getValueStack().set("dbList",dbList);
		ActionContext.getContext().getValueStack().set("allList",allList);
		return "findAll";
	}
	
	public String add(){
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist",list);
		List<String> dbList = new ArrayList<String>();
		for(int i=0;i<list.size();i++){
			List<Dormity> dList = dormityService.finddor(list.get(i).getBid());
			if(dList!=null){
				for(int j=0;j<dList.size();j++){
					dbList.add(list.get(i).getName()+"-"+dList.get(j).getNum());
				}
			}
		}
		ActionContext.getContext().getValueStack().set("dbList",dbList);
		return "add";
	}
	
	//入住
	public String addstu(){
		student.setAddress("湖南");
//		Student stu = studentService.findName(student.getName());
//		if(stu == null){}
		String [] newdor = dor.split("-");
		String build = newdor[0];//宿舍楼名
		String dorm = newdor[1];//寝室号
		Building building = buildingService.findByName(build);
		
		Dormity dormity = dormityService.findByNumAndBid(dorm,building.getBid());
		dormity.setCount(dormity.getCount()+1);
		dormity.setBuilding(building);
		student.setDormity(dormity);
		student.setState("正常");
		studentService.save(student);
		
		dormity.getStudents().add(student);

		dormityService.update(dormity);
		
		return "addstu";
	}
	
	//换寝室
	public String changeDor(){
		String [] newdor = dor.split("-");
		String build = newdor[0];//宿舍楼名
		String dorm = newdor[1];//寝室号
		int sid = student.getSid();
		//查找学生
		student = studentService.findBySid(sid);
		//原先宿舍
		Dormity olddorm = student.getDormity();
		//旧楼层
		Building oldbuild = student.getDormity().getBuilding();
		olddorm.setCount(olddorm.getCount()-1);
		
		dormityService.update(olddorm);
		
		//查找宿舍楼
		Building building = buildingService.findByName(build);
		//查找宿舍
		Dormity dormity = dormityService.findByNumAndBid(dorm,building.getBid());
		dormity.setCount(dormity.getCount()+1);
		dormity.setBuilding(building);
		student.setDormity(dormity);
		studentService.update(student);
		
		dormity.getStudents().add(student);
		
		dormityService.update(dormity);
		
		return "changeDor";
	}
	
	public String find(){
		if(dor.equals("1")&&student.getName()==null){
		//选项为空，名字为空，查找所有	
			PageBean<Student> pageBean = studentService.findAll(page);
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			
			List<Building> list = buildingService.find();
			ActionContext.getContext().getValueStack().set("blist",list);
			List<String> dbList = new ArrayList<String>();
			List<String> allList = new ArrayList<String>();
			
			for(int i=0;i<list.size();i++){
				List<Dormity> dList = dormityService.finddor(list.get(i).getBid());
				if(dList!=null){
					for(int j=0;j<dList.size();j++){
						dbList.add(list.get(i).getName()+"-"+dList.get(j).getNum());
					}
				}
				
				List<Dormity> daList = dormityService.findAlldor(list.get(i).getBid());
				if(daList!=null){
					for(int j=0;j<daList.size();j++){
						System.out.println(list.get(i).getName()+"-"+daList.get(j).getNum());
						allList.add(list.get(i).getName()+"-"+daList.get(j).getNum());
					}
				}
				
			}
			
			
			ActionContext.getContext().getValueStack().set("dbList",dbList);
			ActionContext.getContext().getValueStack().set("allList",allList);
			
		}else if(!dor.equals("1")&&student.getName()==null){
		//x选项不为空，名字为空
		String [] newdor = dor.split("-");
		String build = newdor[0];//宿舍楼名
		String dorm = newdor[1];//寝室号
		
		int count = studentService.findCount(dorm,build);
		if(count==0){
			page=0;
		}
		
		PageBean<Student> pageBean = studentService.find(build,dorm,page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		List<Building> list = buildingService.find();
		ActionContext.getContext().getValueStack().set("blist",list);
		List<String> dbList = new ArrayList<String>();
		List<String> allList = new ArrayList<String>();
		
		for(int i=0;i<list.size();i++){
			List<Dormity> dList = dormityService.finddor(list.get(i).getBid());
			if(dList!=null){
				for(int j=0;j<dList.size();j++){
					dbList.add(list.get(i).getName()+"-"+dList.get(j).getNum());
				}
			}
			
			List<Dormity> daList = dormityService.findAlldor(list.get(i).getBid());
			if(daList!=null){
				for(int j=0;j<daList.size();j++){
					System.out.println(list.get(i).getName()+"-"+daList.get(j).getNum());
					allList.add(list.get(i).getName()+"-"+daList.get(j).getNum());
				}
			}
			
		}
		
		
		ActionContext.getContext().getValueStack().set("dbList",dbList);
		ActionContext.getContext().getValueStack().set("allList",allList);
		
		}else if(dor.equals("1")&&student.getName()!=null){
			//选项为空，名字不为空
			
			int count = studentService.findCount(student.getName());
			if(count==0){
				page=0;
			}
			
			PageBean<Student> pageBean = studentService.findByName(student.getName(),page);
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			
			List<Building> list = buildingService.find();
			ActionContext.getContext().getValueStack().set("blist",list);
			List<String> dbList = new ArrayList<String>();
			List<String> allList = new ArrayList<String>();
			
			for(int i=0;i<list.size();i++){
				List<Dormity> dList = dormityService.finddor(list.get(i).getBid());
				if(dList!=null){
					for(int j=0;j<dList.size();j++){
						dbList.add(list.get(i).getName()+"-"+dList.get(j).getNum());
					}
				}
				
				List<Dormity> daList = dormityService.findAlldor(list.get(i).getBid());
				if(daList!=null){
					for(int j=0;j<daList.size();j++){
						System.out.println(list.get(i).getName()+"-"+daList.get(j).getNum());
						allList.add(list.get(i).getName()+"-"+daList.get(j).getNum());
					}
				}
				
			}
			
			
			ActionContext.getContext().getValueStack().set("dbList",dbList);
			ActionContext.getContext().getValueStack().set("allList",allList);
			
		}else if(!dor.equals("1")&&student.getName()!=null){
			//选项不为空，名字不为空
			
			
			
			String [] newdor = dor.split("-");
			String build = newdor[0];//宿舍楼名
			String dorm = newdor[1];//寝室号
			
			int count = studentService.findCount(build,dorm,student.getName());
			if(count==0){
				page=0;
			}
			
			PageBean<Student> pageBean = studentService.find(build,dorm,student.getName(),page);
			ActionContext.getContext().getValueStack().set("pageBean", pageBean);
			
			List<Building> list = buildingService.find();
			ActionContext.getContext().getValueStack().set("blist",list);
			List<String> dbList = new ArrayList<String>();
			List<String> allList = new ArrayList<String>();
			
			for(int i=0;i<list.size();i++){
				List<Dormity> dList = dormityService.finddor(list.get(i).getBid());
				if(dList!=null){
					for(int j=0;j<dList.size();j++){
						dbList.add(list.get(i).getName()+"-"+dList.get(j).getNum());
					}
				}
				
				List<Dormity> daList = dormityService.findAlldor(list.get(i).getBid());
				if(daList!=null){
					for(int j=0;j<daList.size();j++){
						System.out.println(list.get(i).getName()+"-"+daList.get(j).getNum());
						allList.add(list.get(i).getName()+"-"+daList.get(j).getNum());
					}
				}
				
			}
			
			
			ActionContext.getContext().getValueStack().set("dbList",dbList);
			ActionContext.getContext().getValueStack().set("allList",allList);
			
		}
		return "find";
	} 
	
}
