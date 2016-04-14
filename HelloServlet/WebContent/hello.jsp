<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.oraclejava.co.kr/tags"  prefix="ora" %>
<%@ include file="param.jsp" %>
</head>
<body>
	<%-- jsp 주석 --%>
	<!-- html 주석 -->
	<%! int x = 0; %>
	<%
		out.println("x=" + x);
		x++;
		Calendar cal = new GregorianCalendar();
		cal.set(1982, 2, 8); //1970-02-21 새일 month : 0
		Date birth = cal.getTime();
	%>
	<h3>
		결과 :
		<%= x %></h3>
	<h3><%= new Date() %></h3>
	<h3><ora:helloTag  message="안녕하세요!" /></h3>
	<h3>나이 : <ora:ageTag birthday="<%=birth%>" /></h3>
</body>
</html>