<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>팀명 : ${model.teamName}</h1>
<c:if test="${model.teamName == '삼성'}">
	<img
		src="https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/40/87/146_2484087_team_image_url_1428310436226.jpg"
		alt="${ model.teamName }" />
	<p>연고지 대구광역시 홈구장 대구 삼성 라이온즈 파크 감독/선수단 류중일 감독</p>
</c:if>
<c:if test="${model.teamName == '한화'}">
	<img
		src="https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/40/93/146_2484093_team_image_url_1428384557192.jpg"
		alt="${ model.teamName }" />
	<p>연고지 대전광역시 | 홈구장 한화생명 이글스 파크 감독/선수단 김성근 감독</p>
</c:if>
<c:if test="${model.teamName == '기아'}">
	<img
		src="https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/40/78/146_2484078_team_image_url_1428310006072.jpg"
		alt="${ model.teamName }" />
	<p>연고지 광주광역시 | 홈구장 기아 챔피언스 필드, 기아 챌린저스 필드 감독/선수단 김기태 감독</p>
</c:if>
<c:if test="${model.teamName == '두산'}">
	<img
		src="https://tv.pstatic.net/thm?size=150x112&quality=9&q=http://sstatic.naver.net/keypage/image/dss/146/48/41/02/146_2484102_team_image_url_1428311072978.jpg"
		alt="${ model.teamName }" />
	<p>연고지 서울특별시 | 홈구장 잠실 야구장 감독/선수단김태형 감독</p>
</c:if>
<a href="<c:url value="/baseball" />">Home</a>
