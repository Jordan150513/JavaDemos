package com.helloqiaodan.firstweb;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;
public class Person {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isSecrete() {
		return secrete;
	}
	public void setSecrete(boolean secrete) {
		this.secrete = secrete;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return this.password;
	}
	public void setDateFormat(Date dateFormat){
		this.dateFormat = dateFormat;
	}
	public Date getDateFormat(){
		return this.dateFormat;
	}
	private String name;
	private int age;
	private String sex;
	private boolean secrete;
	private String password;
	private Date dateFormat;
	
	public Person(){
		
	}
	public Person(String name,String password,int age,Date format){
	this.name=name;
	this.password= password;
	this.age = age;
	this.dateFormat= format;
	}
}
