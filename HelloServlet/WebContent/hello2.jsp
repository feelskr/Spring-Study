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
	<c:set value="김<br />" var="lastName" />
	<c:set value="현수<br />" var="firstName" />
	성: <c:out value="${lastName}" /> <br />
	이름 : ${firstName} 
	<c:forEach var="i" begin="1"  end="10">
	명량${i}<br />
	</c:forEach>
	<%
	String[] movies = {"명량", "국제시장", "아바타", "도둑들"};
	%>
	<c:set var="movies" value="<%= movies %>" />
	<c:forEach var="movie" items="${movies}" varStatus="st">
		${st.count} : ${movie}<br />
	</c:forEach>
</body>
</html>