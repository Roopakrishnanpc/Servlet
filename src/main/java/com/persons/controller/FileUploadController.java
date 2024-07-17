
package com.persons.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;

//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class FileUploadController
 */
@MultipartConfig
public class FileUploadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//ServletFileUpload sf=new ServletFileUpload(new DiskFileItemFactory());
		//JakartaServletFileUpload sf=new JakartaServletFileUpload(new DiskFileItemFactory());
//		try {
//			List<FileItem> f=sf.parseRequest(request);
//					//sf.parseRequest(request);
//			for(FileItem item:f)
//			{
//				item.write(new File("/Users/ASHWIN KRISHNAN/Spring_Microservicses/ServletJSPMavenJDBCdemo/" + item.getName()));
//			}
//			
//		} catch (FileUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	       String uploadPath = "C:/Users/ASHWIN KRISHNAN/Spring_Microservicses_New/ServletJSPMavenJDBCDemoPerson/";
	        
	        for (Part part : request.getParts()) {
	            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
	            part.write(uploadPath + fileName);
	        }

	        response.getWriter().println("File uploaded successfully!");
	}

}
