package com.helloqiaodan.firstweb;

public class Pagination {

	public static String getPagination(int pageNum,int pageCount,int recordCount,String pageUrl){
		
		String url = pageUrl.contains("?")?pageUrl:pageUrl+"?";
		if(!url.endsWith("?") && !url.endsWith("&")){
			url += "&";
		}
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("NO. "+pageNum+" /"+pageCount+" page. Total "+recordCount+" records");
		buffer.append(pageNum==1?"first page":"<a href='"+url+"pageNum=1'>first page<a/>");
		buffer.append(pageNum==1?"Pre page":"<a href='"+url+"pageNum="+(pageNum-1)+"'>pre page</a>");
		buffer.append(pageNum==pageCount?"next page":"<a href='"+url+"pageNum="+(pageNum+1)+"'>next page</a>");
		buffer.append(pageNum==pageCount?"last page":"<a href='"+url+"pageNum="+pageCount+"'>last page</a>");
		return buffer.toString();
	}
}
