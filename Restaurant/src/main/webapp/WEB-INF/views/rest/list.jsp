<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑</title>
<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
}

.td-border {
	border-bottom: 1px solid black;
	border-right: 1px solid black
}

.td-border-top {
	border-bottom: 2px solid #c5c3c3;
	border-right: 1px solid black
}

.td-padding {
	padding: 5px;
}

.height {
	height: 35px;
}

.ta-center {
	text-align: center
}

.paging {
	float: left; list-style : none;
	margin: 0 auto;
	padding: 0;
	list-style: none;
}

.paging li {
	float: left; list-style : none;
	margin: 0;
	padding: 5px;
	list-style: none;
}

.paging li span {
	font-size: 14px;
}
</style>
</head>
<body>
	<c:set var="appUrl" value="<%=request.getContextPath() %>" />
	<a href="<c:url value="/rest/regist" />">추가</a>
	<table width="100%" class="table-border">
		<colgroup>
			<col width="10%" />
			<col width="30%" />
			<col width="*" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
			<col width="10%" />
		</colgroup>
		<tr>
			<th class="td-border-top height">이미지
			</td>
			<th class="td-border-top height">이름
			</td>
			<th class="td-border-top height">내용
			</td>
			<th class="td-border-top height">위도
			</td>
			<th class="td-border-top height">경도
			</td>
			<th class="td-border-top height">수정
			</td>
			<th class="td-border-top height">삭제
			</td>
		</tr>
		<c:forEach var="item" items="${list }">
			<tr>
				<td class="td-border td-padding ta-center"><img
					src="<c:url value="/rest/getImage?id=${item.restaurantId}" />"
					width="100" height="100" alt="${item.restaurantName}" /></td>
				<td class="td-border td-padding"><a href="<c:url value="/rest/review/${item.restaurantId}" />">${item.restaurantName}</a></td>
				<td class="td-border td-padding">${item.pr}</td>
				<td class="td-border td-padding ta-center">${item.lat}</td>
				<td class="td-border td-padding ta-center">${item.lon}</td>
				<td class="td-border td-padding ta-center"><a href="<c:url value="/rest/update?id=${item.restaurantId}" />">수정</a></td>
				<td class="td-border td-padding ta-center">
				<form:form	modelAttribute="restaurant"
						action="${ appUrl }/rest/delete?id=${item.restaurantId}" method="post">
						<%-- <a href="<c:url value="/rest/update?id=${item.restaurantId}" />">수정</a> --%>
						<input type="submit" value="삭제" />
					</form:form>
					</td>
				<%-- <td class="td-border td-padding ta-center"><a href="<c:url value="/rest/delete/${item.restaurantId}" />">삭제</a></td> --%>
			</tr>
		</c:forEach>
	</table>

	<ul class="paging">
		<c:forEach begin="1" end="${allpage}" var="i">
			<c:if test="${i eq page}">
				<li><span>${i}</span></li>
			</c:if>
			<c:if test="${i ne page}">
				<li><a href="<c:url value="/rest/list?page=${i}" />"><span>${i}</span></a></li>
			</c:if>
		</c:forEach>
	</ul>

</body>
</html>