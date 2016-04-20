<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>주소록 목록</title>
<script type="text/javascript"
	src="<c:url value="/resources/js/jquery-1.12.3.min.js" />"></script>
</head>
<body>
<table width="500" border="1">
<tr>
	<th>No.</th>
	<th>성</th>
	<th>이름</th>
</tr>
<c:forEach var="item" items="${list}">
<tr>
	<td align="center">${item.contactId }</td>
	<td>${item.lastName }</td>
	<td>${item.firstName }</td>
</tr>
</c:forEach>
</table>
<a href="<c:url value="/contact/add" />">등록</a>	
</body>
</html>