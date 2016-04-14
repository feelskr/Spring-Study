package com.oraclejava;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class AgeTag implements Tag {

	private PageContext pageContext;
	private Tag parentTag;
	private Date birthday;
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			
			Calendar cal = new GregorianCalendar();
			int cYear = cal.get(Calendar.YEAR);	
			
			cal.setTime(birthday);
			int bYear = cal.get(Calendar.YEAR);
			
			int age = (cYear - bYear) + 1;
			
			out.println(age);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public Tag getParent() {
		return this.parentTag;
	}

	@Override
	public void release() {
		// TODO Auto-generated method stub
	}

}
