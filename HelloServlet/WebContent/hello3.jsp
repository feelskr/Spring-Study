<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set var="movie" value="국제시장,   서울시장   ,   대구시장   ,   광주시장    " />
	<h2>${fn:contains(movie, "국제")}</h2>
	<h3>
		<c:if test="${fn:contains(movie, '국제')}">
	yes
	</c:if>
	</h3>
	<h3>${ fn:length(movie) }</h3>
	<h3>${ fn:replace(movie, '시장', 'Market') }</h3>
	<c:set var="m_array" value="${ fn:split(movie, ',') }" />
	<ul>
		<c:forEach var="m" items="${m_array}">
			<li>${fn:trim(m)}</li>
		</c:forEach>
	</ul>
	${ fn:join(m_array, '|') }
</body>
</html>