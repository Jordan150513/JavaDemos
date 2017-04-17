package com.helloqiaodan.firstweb;
import com.helloqiaodan.firstweb.Department;
import java.util.Date;

public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", sex=" + sex + ", employedDate=" + employedDate
				+ ", department=" + department + "]";
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmployedDate() {
		return employedDate;
	}

	public void setEmployedDate(String employedDate) {
		this.employedDate = employedDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	private Integer id;
	private String name;
	private String sex;
	
	private String employedDate;
	
	private Department department;

	public Employee(String name, String sex, String employedDate, Department department) {
		super();
		this.name = name;
		this.sex = sex;
		this.employedDate = employedDate;
		this.department = department;
	}

	public Employee() {
		super();
	}
	
}
