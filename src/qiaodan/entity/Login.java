package qiaodan.entity;

import java.io.Serializable;
import java.util.LinkedList;
/**
 * 
 * 用户登录实体类
 * 
 * */
public class Login implements Serializable {

	/**
	 * 这个是啥？什么作用？
	 */
	private static final long serialVersionUID = 4704773694918046098L;

	private String username = "";
	private String backNews = "未登录";
	private LinkedList<String> car = null;//购物车 订单
	
	public Login(){
		car = new LinkedList<String>();
	}
	
	public LinkedList<String> getCar(){
		return car;
	}
	public void setCar(LinkedList<String> car)
	{
		this.car = car;
	}
	public String getUsername()
	{
	    if (username.trim()=="")
        {
            return "userNull";
        }
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getBackNews()
	{
		return backNews;
	}
	public void setBackNews(String backNews)
	{
		this.backNews = backNews;
	}
}
