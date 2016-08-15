package com.tyz.model;

import java.util.HashSet;
import java.util.Set;

public class Building {

	private int bid;//id
	private String name;//名字
	private String introduction;//介绍
	private Set<Dormity> dormities = new HashSet<Dormity>();
	private Set<Systemmanager> systemmanagers = new HashSet<>();
	
	
	public Set<Systemmanager> getSystemmanagers() {
		return systemmanagers;
	}
	public void setSystemmanagers(Set<Systemmanager> systemmanagers) {
		this.systemmanagers = systemmanagers;
	}
	public Set<Dormity> getDormities() {
		return dormities;
	}
	public void setDormities(Set<Dormity> dormities) {
		this.dormities = dormities;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@Override
	public String toString() {
		return "Building [bid=" + bid + ", name=" + name + ", introduction=" + introduction + ", dormities=" + dormities
				+ ", systemmanagers=" + systemmanagers + "]";
	}
	
	
}
