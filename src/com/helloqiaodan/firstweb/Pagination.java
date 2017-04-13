package com.helloqiaodan.firstweb;

public class Pagination {

	public static String getPagination(int pageNum,int pageCount,int recordCount,String pageUrl){
		
		String url = pageUrl.contains("?")?pageUrl:pageUrl+"?";
		if(!url.endsWith("?") && !url.endsWith("&")){
			url += "&";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("NO."+pageNum+"/"+pageCount+"page  Total"+recordCount+"records");
		buffer.append(pageNum==1?"  first_page":"<a href='"+url+"pageNum=1'>  first_page<a/>");
		buffer.append(pageNum==1?"  Pre_page":"<a href='"+url+"pageNum="+(pageNum-1)+"'>  pre_page</a>");
		buffer.append(pageNum==pageCount?"  next_page":"<a href='"+url+"pageNum="+(pageNum+1)+"'> next_page</a>");
		buffer.append(pageNum==pageCount?"   last_page":"<a href='"+url+"pageNum="+pageCount+"'>   last_page</a>");
		return buffer.toString();
	}
}
