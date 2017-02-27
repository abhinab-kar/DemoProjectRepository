package com.demoproject.bean;

public class Person 
{
	private String name;
	private Integer id;
	private String address;
	
	public Person() {
		// TODO Auto-generated constructor stub
		this.name = null;
		this.id = null;
		this.address = null;
	}
	
	public Person(String name, Integer id, String address) 
	{
		// TODO Auto-generated constructor stub
		this.name = name;
		this.id = id;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
