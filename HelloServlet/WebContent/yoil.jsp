<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		int yoil = Integer.parseInt(request.getParameter("yo"));
		switch (yoil) {
		case 1: //�Ͽ���
	%>
	<img src="shk.jpg" />
	<%
		break;
		case 5:
	%>
	<img src="iu.jpg" width="800" />
	<br />
	<%
		out.println(session.getAttribute("userid") + "�������!");
		out.println(application.getInitParameter("msg"));
		break;
		}
	%>
</body>
</html>