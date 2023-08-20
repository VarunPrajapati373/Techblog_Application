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

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;
import com.tech.blog.helper.Helper;

@MultipartConfig
public class EditServlet extends HttpServlet {
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html");
		try(PrintWriter out = resp.getWriter()){
		
			//fetch all data
			String user_email= req.getParameter("user_email");
			String user_name= req.getParameter("user_name");
			String user_password= req.getParameter("user_password");
			String user_about= req.getParameter("user_about");
			//fetching Image change
			Part part = req.getPart("image");
			String imageName = part.getSubmittedFileName();
			
			//get the user form the session
			HttpSession s = req.getSession();
			User user = (User)s.getAttribute("currentUser");
			
			//setting new details to old session
			user.setEmail(user_email);
			user.setPassword(user_password);
			user.setName(user_name);
			user.setAbout(user_about);
			
			String OldFile=user.getProfile();
			
			user.setProfile(imageName);
			
			//update database with new details
			UserDao userDao = new UserDao(ConnectionProvider.getConnection());
			boolean ans = userDao.updateUser(user);
			
			if(ans==true) {
				
				
				String path = req.getRealPath("/")+"pic"+File.separator+user.getProfile();
				
				
				//delete profile photo
				String pathOldFile = req.getRealPath("/")+"pic"+File.separator+OldFile;
				
				if(!OldFile.equals("default.png")) {
					Helper.deleteFile(pathOldFile);
				}
				
					if(Helper.saveFile(part.getInputStream(), path)) {
						out.println("Profile Updated");
						Message msg = new Message("Profile Details Updated","success","alert-success");
						s.setAttribute("msg", msg);
						
					}else {
						out.println("Profile Not Updated");
						Message msg = new Message("Something went wrong","error","alert-danger");
						s.setAttribute("msg", msg);
					}
				
			}else {
				out.println("Not Updated to DB");
				Message msg = new Message("Something went wrong","error","alert-danger");
				s.setAttribute("msg", msg);
			}
			
			resp.sendRedirect("profile.jsp");
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
