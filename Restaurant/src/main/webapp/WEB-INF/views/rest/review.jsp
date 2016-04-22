<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑 상세보기</title>
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
	float: left;
	list-style: none;
	margin: 0 auto;
	padding: 0;
	list-style: none;
}

.paging li {
	float: left;
	list-style: none;
	margin: 0;
	padding: 5px;
	list-style: none;
}

.paging li span {
	font-size: 14px;
}

.star {
	color: darkyellow;
	font-size: 14px;
}
</style>
</head>
<body>
	<h1>${rest.restaurantName}</h1>
	<div>
		<p>
			<img src="<c:url value="/rest/getImage?id=${rest.restaurantId}" />"
				width="
				500" alt="${rest.restaurantName}" />
		</p>
		<p>좌표 : (${rest.lat}, ${rest.lon})</p>
		<c:set var="newline" value="\n" />
		<p>소개말 : ${fn:replace(rest.pr, newline, '<br />')}</p>
		<p>평점 : ${reviewAvg}</p>
	</div>
	<hr />
	<div>
		<c:set var="conextPath" value="<%=request.getContextPath()%>" />
		<form:form modelAttribute="review" action="${conextPath}/rest/review"
			method="post">
			<form:input type="hidden" value="${rest.restaurantId}" path="rid" />
			<p>
				<form:label path="rate">평점</form:label>
				<form:select path="rate" items="${ starList }" />
				<form:errors path="rate" cssClass="error" />
			</p>
			<p>
				<form:label path="uid">작성자</form:label>
				<form:input path="uid" />
				<form:errors path="uid" cssClass="error" />
			</p>
			<p>
				<form:label path="body">내용</form:label>
				<form:textarea path="body" rows="4" cols="70" />
				<form:errors path="body" cssClass="error" />
			</p>
			<input type="submit" value="쓰기" />
			<input type="button" value="목록"
				onclick="window.location.href='<c:url value="/rest/list" />'" />
		</form:form>
		<hr />
		<div>
			<c:set var="listStar" value="${starList}" />
			<table width="100%">
				<colgroup>
					<col width="100" />
					<col width="100" />
					<col width="*" />
					<col width="100" />
					<col width="80" />
				</colgroup>
				<tr>
					<th class="td-border">평점</th>
					<th class="td-border">작성자</th>
					<th class="td-border">내용</th>
					<th class="td-border">작성일</th>
					<th class="td-border">삭제</th>
				</tr>
				<c:choose>
					<c:when test="${not empty reviewList}">
						<c:forEach var="review" items="${reviewList}">
							<tr>
								<td class="td-border"><c:forEach begin="1"
										end="${review.rate}">★</c:forEach></td>
								<td class="td-border td-padding ta-center">${review.uid}</td>
								<td class="td-border td-padding">${review.body}</td>
								<td class="td-border td-padding ta-center"><fmt:formatDate
										value="${review.uDate}" pattern="yyyy-MM-dd" /></td>
								<td class="td-border td-padding ta-center"><a
									href="<c:url value="/rest/review_del/${review.reviewId}/${review.uid}/${review.rid}" /> ">삭제</a>
								</td>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr>
							<td colspan="5" align="center" height="35">등록된 리뷰가 없습니다.</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</table>
		</div>
		<hr />
	</div>
</body>
</html>