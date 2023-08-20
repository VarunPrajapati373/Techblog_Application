package com.tech.blog.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.tech.blog.dao.PostDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.Post;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;


@MultipartConfig
public class AddPostServlet extends HttpServlet {
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html");
		try(PrintWriter out = resp.getWriter()){
			
			int cid= Integer.parseInt(req.getParameter("cid"));
			String pTitle=req.getParameter("pTitle");
			String pContent=req.getParameter("pContent");
			String pCode=req.getParameter("pCode");
			Part part = req.getPart("pic");
			//getting current User id
			
			HttpSession session = req.getSession();
			User user = (User) session.getAttribute("currentUser");
			
			Post p= new Post(pTitle, pContent, pCode, part.getSubmittedFileName(), null, cid, user.getId());
			
			PostDao dao = new PostDao(ConnectionProvider.getConnection());
			
			if(dao.savePost(p)) {
				
				
				String path = req.getRealPath("/")+"blog_pic"+File.separator+part.getSubmittedFileName();
				
				Helper.saveFile(part.getInputStream(), path);
				out.println("done");
				
			}else {
				out.println("error");
			}
			
			}
			
	   }
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	public String getServletInfo() {
		return "short Description";
	}

}
