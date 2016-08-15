package com.tyz.model;


public class Systemmanager {

	private int sid;//id
	private String name;//系统员名字
	private String username;//用户名
	private String pwd;//密码
	private String gender; //性别
	private String telephone;//电话号码
	private String address;//地址
	private String card;//身份证号
	private int role;//0管理员 1宿舍管理员
	private Building building;//1对多
	
	
	@Override
	public String toString() {
		return "Systemmanager [sid=" + sid + ", name=" + name + ", username=" + username + ", pwd=" + pwd + ", gender="
				+ gender + ", telephone=" + telephone + ", address=" + address + ", card=" + card + ", role=" + role
				 + "]";
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCard() {
		return card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	
	
}
