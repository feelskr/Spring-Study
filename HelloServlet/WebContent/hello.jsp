<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ include file="param.jsp" %>
</head>
<body>
	<%-- jsp 주석 --%>
	<!-- html 주석 -->
	<%! int x = 0; %>
	<%
		out.println("x=" + x);
		x++;
	%>
	<h3>
		결과 :
		<%= x %></h3>
	<h3><%= new Date() %></h3>
</body>
</html>