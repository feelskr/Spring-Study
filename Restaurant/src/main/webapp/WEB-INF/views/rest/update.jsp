<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑 수정</title>
</head>
<body>
	<form:form modelAttribute="restaurant" method="post" enctype="multipart/form-data">
		<form:input path="restaurantId" type="hidden" />
		<p>
			<form:label path="restaurantName">레스토랑 명</form:label>
			<form:input path="restaurantName" />
		</p>
		<p>
			<form:label path="lat">위도</form:label>
			<form:input path="lat" />
		</p>
		<p>
			<form:label path="lon">경도</form:label>
			<form:input path="lon" />
		</p>
		<p>
			<form:label path="pr">소개말</form:label>
			<form:textarea path="pr"  rows="4" cols="70" />
		</p>
		<p>
			<form:label path="image">레스토랑 이미지 : </form:label>
			<input type="file" name="imageFile" />
		</p>		
		<input type="submit" value="전송" />
		<a href="<c:url value="/rest/list" />">리스트</a>
	</form:form>
</body>
</html>