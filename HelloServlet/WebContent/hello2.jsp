<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set value="��<br />" var="lastName" />
	<c:set value="����<br />" var="firstName" />
	��: <c:out value="${lastName}" /> <br />
	�̸� : ${firstName} 
	<c:forEach var="i" begin="1"  end="10">
	��${i}<br />
	</c:forEach>
	<%
	String[] movies = {"��", "��������", "�ƹ�Ÿ", "���ϵ�"};
	%>
	<c:set var="movies" value="<%= movies %>" />
	<c:forEach var="movie" items="${movies}" varStatus="st">
		${st.count} : ${movie}<br />
	</c:forEach>
</body>
</html>