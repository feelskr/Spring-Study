<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="contactServlet" enctype="multipart/form-data">
		<table border="0">
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="firstName" /></td>
			</tr>
			<tr>
				<td>성 :</td>
				<td><input type="text" name="lastName" /></td>
			</tr>
			<tr>
				<td>사진 :</td>
				<td><input type="file" name="photo" size="50" /></td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="저장" /></td>
			</tr>
		</table>
	</form>
</body>
</html>