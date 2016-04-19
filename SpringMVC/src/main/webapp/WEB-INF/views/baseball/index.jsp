<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 3.0 MVC : Baseball</title>
</head>
<body>

	<h1>프로 야구팀 소개 입니다.</h1>
	<ul>
	
		<li><a href="<c:url value="/baseball/team?name=삼성" />">삼성</a></li>
		<li><a href="<c:url value="/baseball/team?name=한화" />">한화</a></li>
		<li><a href="<c:url value="/baseball/team?name=기아" />">기아</a></li>
		<li><a href="<c:url value="/baseball/team?name=두산" />">두산</a></li>
	</ul>
</body>
</html>