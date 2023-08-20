package com.tech.blog.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blog.dao.UserDao;
import com.tech.blog.entities.Message;
import com.tech.blog.entities.User;
import com.tech.blog.helper.ConnectionProvider;


public class LogoutServlet extends HttpServlet {
	
	
protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		resp.setContentType("text/html");
		try(PrintWriter out = resp.getWriter()){
			
			HttpSession s= req.getSession();
			s.removeAttribute("currentUser");
			
			Message m = new Message("Logout Successfully","success","alert-success");
			
			s.setAttribute("msg", m);
			resp.sendRedirect("login_page.jsp");
			
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
