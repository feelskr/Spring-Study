package com.oraclejava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorld extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
					throws ServletException, IOException {

		PrintWriter out = res.getWriter();

		out.println("<html>");
		out.println("<body><h1>Hello World!!</h1></body>");
		out.println("</html>");

	}

}
