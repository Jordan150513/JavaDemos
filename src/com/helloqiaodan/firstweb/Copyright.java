package com.helloqiaodan.firstweb;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class Copyright implements Tag {

	private Tag parent;
	private PageContext pageContext;
	
	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try{
			out.println("<div align=center style='line-height:22px;font-size:12px;'>");
			out.println(ResourceBundle.getBundle("copyright").getString("copyright"));
			out.println("qiao");
			out.println("</div>");
			// 并没有成功将copyright信息显示出来 什么问题呢？？
		}catch(IOException e){
			throw new JspException(e);
		}
		return EVAL_PAGE;
//		return 0;
	}

	@Override
	public int doStartTag() throws JspException {
		return SKIP_BODY;
//		return 0;
	}

	@Override
	public Tag getParent() {
		
		return this.parent;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPageContext(PageContext arg0) {
		this.pageContext = arg0;

	}

	@Override
	public void setParent(Tag arg0) {
		this.parent = arg0;

	}

}
