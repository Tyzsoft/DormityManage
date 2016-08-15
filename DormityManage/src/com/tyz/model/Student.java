package com.tyz.model;

import java.util.HashSet;
import java.util.Set;

public class Student {

	private int sid;//id
	private String name;//姓名
	private String grader;//年级
	private String xh;//学号
	private String state;//迁入迁出状态
	private String telephone;//电话号码
	private String card;//身份证号
	private String address;//地址
	private String teacher;//辅导员
	private String profession;
	private Dormity dormity;
	private Set<Lackstudent> lackstudents = new HashSet<>();
	
	
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", grader=" + grader + ", xh=" + xh + ", state=" + state
				+ ", telephone=" + telephone + ", card=" + card + ", address=" + address + ", teacher=" + teacher
				+ ", profession=" + profession + ", dormity=" + dormity + "]";
	}
	public Set<Lackstudent> getLackstudents() {
		return lackstudents;
	}
	public void setLackstudents(Set<Lackstudent> lackstudents) {
		this.lackstudents = lackstudents;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Dormity getDormity() {
		return dormity;
	}
	public void setDormity(Dormity dormity) {
		this.dormity = dormity;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrader() {
		return grader;
	}
	public void setGrader(String grader) {
		this.grader = grader;
	}
	public String getXh() {
		return xh;
	}
	public void setXh(String xh) {
		this.xh = xh;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	
	
	
}
