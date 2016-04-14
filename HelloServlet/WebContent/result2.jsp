<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		Calendar cal = new GregorianCalendar();
	%>
	<jsp:forward page="yoil.jsp">
		<jsp:param value="<%=cal.get(Calendar.DAY_OF_WEEK)%>" name="yo" />
	</jsp:forward>>
</body>
</html>