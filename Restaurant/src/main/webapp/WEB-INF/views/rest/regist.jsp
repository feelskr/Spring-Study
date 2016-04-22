<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>레스토랑 추가</title>
<style type="text/css">
.error{color:red;font-size:12px;}
</style>
</head>
<body>
	<form:form modelAttribute="restaurant" method="post" enctype="multipart/form-data">
		<p>
			<form:label path="restaurantName">레스토랑 명</form:label>
			<form:input path="restaurantName" />
			<form:errors path="restaurantName" cssClass="error" />			
		</p>
		<p>
			<form:label path="lat">위도</form:label>
			<form:input path="lat" />
			<form:errors path="lat" cssClass="error"  />
		</p>
		<p>
			<form:label path="lon">경도</form:label>
			<form:input path="lon" />
			<form:errors path="lon" cssClass="error"  />			
		</p>
		<p>
			<form:label path="pr">소개말</form:label>
			<form:textarea path="pr"  rows="4" cols="70" />
			<form:errors path="pr" cssClass="error"  />			
		</p>
		<p>
			<form:label path="image">레스토랑 이미지 : </form:label>		
			<input type="file" name="imageFile" />
		</p>
		<c:if test="${'regist' == mode}">		
		<input type="submit" value="등록" />
		</c:if>
		<c:if test="${'update' == mode}">		
		<input type="submit" value="수정" />
		</c:if>		
		<p>
		<a href="<c:url value="/rest/list" />">리스트</a>
		</p>
	</form:form>
</body>
</html>