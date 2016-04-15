<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*, java.sql.*"%>
<%!private String dbURL = "jdbc:mysql://localhost:3306/oradb?useUnicode=true";
	private String dbUser = "root";
	private String dbPass = "oraclejava";%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="700">
		<colgroup>
			<col width="120" />
			<col width="180" />
			<col width="180" />
			<col width="*" />
		</colgroup>
		<tr>
			<th>ID</th>
			<th>성</th>
			<th>이름</th>
			<th>이미지</th>
		</tr>
		<%
			Connection conn = null;
			String msg = null;
			try {
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
				String sql = "SELECT contact_id, last_name, first_name, photo FROM contacts";
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
		%>
				<tr>
					<td align="center"><%=rs.getInt("contact_id")%>
					<td align="center"><%=rs.getString("last_name")%></td>
					<td align="center"><%=rs.getString("first_name")%></td>
					<td align="center"><a href="show.jsp?contact_id=<%=rs.getInt("contact_id")%>">Show Image</a></td>					
				</tr>
		<%
				}
			} catch (Exception e) {
		%>
		예외발생 :
		<%=e.getMessage()%>
		<%
			} finally {
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e2) {
						e2.printStackTrace();
					}
				}
			}
		%>
	</table>
</body>
</html>