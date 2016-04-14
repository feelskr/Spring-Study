package com.oraclejava;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

public class SingleUpload extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "D:\\Dev\\upload";
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		factory.setSizeThreshold(1024);
		upload.setSizeMax(-1);
		upload.setHeaderEncoding("euc-kr");
		String fname = ""; //입력받은 파일이름
		String ext = "";
		try {
			List<FileItem> list = upload.parseRequest(req);
			
			for(FileItem item : list) {
				if(item.isFormField()) {
					fname = item.getString("euc-kr");
				}
				if(!item.isFormField()) {
					if(item.getName() != null && !item.getName().equals("")) {
						String filename = (new File(item.getName())).getName();
						ext = FilenameUtils.getExtension(filename);
						item.write(new File(path+"\\"+fname+"."+ext));
						
					}
				}
			}
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("single.html");
		
	}

}
