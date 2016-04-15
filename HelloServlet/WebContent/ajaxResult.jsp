<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 String phone = request.getParameter("phone");
 String img = phone+".jpg";
 String msg = null;
 switch(phone) {
 case "ip":
	 msg = "아이폰 입니다.";
	 break;
 case "ga":
	 msg = "갤럭시 입니다.";
	 break;
 case "ot":
	 msg = "옵티머스 입니다.";
	 break;
 case "vega":
	 msg = "베가 입니다.";
	 break;	 
 }
 %>
 <h2><%= msg %></h2>
<img src="<%= img %>" alt="<%= phone %>"  width="400" />