package com.helloqiaodan.firstweb;

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
	
	private String name;
	private int age;
	private String sex;
	private boolean secrete;
	
}
