package com.facebookweb.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.utilities.ServiceFactory;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		
		FacebookUser u = new FacebookUser();
		u.setEmail(email);
		u.setPassword(password);
		
		FacebookService f = ServiceFactory.createObject();
		
		if (f.loginService(u)) {
			
			HttpSession s = request.getSession(true);
			s.setAttribute("user", email);
			s.setAttribute("pass", password);
			
			out.println("Welcome !<br><a href=friendlist.html>Friendlist</a>");
		}
		else {
			
			out.println("Authentication failed :(");
		}
		out.println("</html></body>");
	}

}

