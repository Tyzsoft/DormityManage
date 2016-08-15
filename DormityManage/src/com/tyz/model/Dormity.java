package com.tyz.model;

import java.util.HashSet;
import java.util.Set;

public class Dormity {

	private int did;//寝室id
	private String num;//寝室号
	private String type;
	private int count;//寝室类型
	private Building building;
	private Set<Student> students = new HashSet<>();
	
	
	@Override
	public String toString() {
		return "Dormity [did=" + did + ", num=" + num + ", type=" + type + ", count=" + count + ", building=" + building
				+ "]";
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
	}
	
	
	
}
