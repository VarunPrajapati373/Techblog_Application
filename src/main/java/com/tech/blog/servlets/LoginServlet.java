package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;
import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;

public class LoginServlet extends HttpServlet {
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html");
		try(PrintWriter out = resp.getWriter()){
			
			//fetch username and password from the request
			
			String userEmail= req.getParameter("email");
			String userPassword= req.getParameter("password");
			
			UserDao dao = new UserDao(ConnectionProvider.getConnection());
			User u = dao.getEmailAndPassword(userEmail, userPassword);
			
			if(u==null) {
				
				//login...error msg
				//out.println("Invalid Details..Try Again");
				Message msg = new Message("Invalid Details ! Try with another","error","alert-danger");
				HttpSession s= req.getSession();
				s.setAttribute("msg", msg);
				
				resp.sendRedirect("login_page.jsp");
				
			}else {
				
				//login successfull
				
				HttpSession s= req.getSession();
				s.setAttribute("currentUser", u);
				resp.sendRedirect("profile.jsp");
				
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
