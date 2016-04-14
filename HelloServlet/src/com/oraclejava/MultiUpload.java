package com.oraclejava;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class MultiUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "D:\\Dev\\upload";

		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		factory.setSizeThreshold(1024);
		upload.setSizeMax(-1);
		upload.setHeaderEncoding("euc-kr");
		String fname="";
		String ext="";
		Enumeration<String> st = req.getParameterNames();
		while(st.hasMoreElements()) {
			String name = st.nextElement();
			System.out.println("na:"+name);
		}
		
		try {
			List<FileItem> list = upload.parseRequest(req);
						
			for(FileItem item : list) {
				if(item.isFormField()) {
					fname = item.getString("euc-kr");
				}
				if(!item.isFormField()) {
					if(item.getName() != null && !item.getName().equals("")) {
						ext = FilenameUtils.getExtension((new File(item.getName())).getName());
						item.write(new File(path+"\\"+fname+"."+ext));
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("multi.html");
		
	}

	
	
}
