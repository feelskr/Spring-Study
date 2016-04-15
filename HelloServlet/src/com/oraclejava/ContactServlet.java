package com.oraclejava;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class ContactServlet
 */
@WebServlet("/contactServlet")
@MultipartConfig(maxFileSize=16177215) //16M
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String dbURL = "jdbc:mysql://localhost:3306/oradb?useUnicode=true";
	private String dbUser = "root";
	private String dbPass = "oraclejava";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		InputStream inputStream = null;
		Part filePart = req.getPart("photo");
		if(filePart != null) {
			System.out.println(filePart.getName());
			System.out.println(filePart.getSize());
			System.out.println(filePart.getContentType());
			inputStream = filePart.getInputStream();
		}
		Connection conn = null;
		String msg = null;
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
			String sql = "INSERT INTO contacts (first_name, last_name, photo) VALUES (?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			if(inputStream != null) {
				stmt.setBlob(3, inputStream);
			}
			int row = stmt.executeUpdate();
			if (row > 0) {
				msg = "성공적으로 입력했습니다.";
			}
		} catch (SQLException e) {
			msg = "에러발생 : " + e.getMessage();
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
		
		req.setAttribute("message", msg);
		getServletContext().getRequestDispatcher("/Message.jsp").forward(req, resp);
	}

}
