package com.oraclejava;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/imageServlet")
public class ImageServlet extends HttpServlet {
	
	private String dbURL = "jdbc:mysql://localhost:3306/oradb?useUnicode=true";
	private String dbUser = "root";
	private String dbPass = "oraclejava";
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int contact_id = Integer.parseInt(req.getParameter("contact_id"));
		
		Connection conn = null;
		//String msg = null;
		ResultSet rs = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
			String sql = "SELECT photo FROM contacts WHERE contact_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, contact_id);
			rs = stmt.executeQuery();
			if(rs.next()) {
				Blob blob =rs.getBlob("photo");
				InputStream inputStream = blob.getBinaryStream();
				OutputStream outputStream = resp.getOutputStream();
				resp.setContentType("image/jpeg");
				//resp.setContentType("application/octet-stream");
				//쓰기
				byte[] buffer = new byte[1024];
				int bytesRead = -1;
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

	
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}
		}

	}
	
}
