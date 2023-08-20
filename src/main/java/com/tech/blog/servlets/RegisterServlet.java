package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

@MultipartConfig
public class RegisterServlet extends HttpServlet {
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html");
		try(PrintWriter out = resp.getWriter()){
			
			//fetch all form Data
			String  check = req.getParameter("check");
			if(check==null) {
				
				out.println("Please accept Terms and Conditions");
				
			}else {
				
				String name = req.getParameter("user_name");
				String email = req.getParameter("user_email");
				String password = req.getParameter("user_password");
				String gender = req.getParameter("gender");
				String about = req.getParameter("about");
				
				//Create user object and set all the Data to that object..
				User user = new User(name,email,password,gender,about);
 				
				//create UserDao object to send data to DB
				
				UserDao dao = new UserDao(ConnectionProvider.getConnection());
				if(dao.saveUser(user)) {
					out.println("done");
				}else {
					out.println("error");
				}
				
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
