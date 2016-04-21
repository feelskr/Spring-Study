<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑</title>
</head>
<body>
<a href="<c:url value="/rest/regist" />">추가</a>
	<table width="100%" border="1">
	<colgroup>
	<col width="100" />
	<col width="100" />
	<col width="*" />
	<col width="80" />
	<col width="80" />
	<col width="80" />
	<col width="80" />	
	</colgroup>
		<tr>
			<td>이미지</td>
			<td>이름</td>
			<td>내용</td>
			<td>위도</td>
			<td>경도</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td><img src="<c:url value="/rest/getImage?id=${item.restaurantId}" />"  width="100" height="100"  alt="${item.restaurantName}" /></td>
				<td>${item.restaurantName}</td>
				<td>${item.pr}</td>
				<td>${item.lat}</td>
				<td>${item.lon}</td>
				<td><a href="<c:url value="/rest/update?id=${item.restaurantId}" />">수정</a></td>
				<td><a href="<c:url value="/rest/delete?id=${item.restaurantId}" />">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<div id="pagingView" style="width:600px;;text-align:center;">
		<c:forEach begin="1"  end="${allpage}" var="i">
			<c:if test="${i eq page}">
				${i} &nbsp;
			</c:if>
			<c:if test="${i ne page}">
			<a href="<c:url value="/rest/list?page=${i}" />">${i}</a>
			</c:if>
		</c:forEach>
	</div>
</body>
</html>