package com.helloqiaodan.firstweb;

public class Department {
	
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	private Integer id;
	private String name;
	
	public Department(String name) {
		super();
		this.name = name;
	}
	
	public Department() {
		super();
	}
	
	
}
