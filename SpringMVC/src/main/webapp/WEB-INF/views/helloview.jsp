<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Spring 3.0 MVC : Hello World</title>
</head>
<body>
	<p>�𵨰� ȣ��</p>
	<ul>
		<li>message1 = ${ message1 }</li>
		<li>message1(Ŀ�����±׷κ���) = <c:out value="${ message1 }" /></li>
		<li>message2 = ${message2}</li>
		<li>currentDate(��������) = <fmt:formatDate value="${currentDate }"
				pattern="yyyy�� MM�� dd��" /></li>
	</ul>

</body>
</html>