package com.facebookweb.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.utilities.ServiceFactory;

/**
 * Servlet implementation class FriendistServlet
 */
public class FriendistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession s = request.getSession(true);
		String email = s.getAttribute("user").toString();
		String password = s.getAttribute("pass").toString();
		
		FacebookUser u = new FacebookUser();
		u.setEmail(email);
		u.setPassword(password);
		
		FacebookService f = ServiceFactory.createObject();
		ArrayList<FacebookUser> friends = f.friendlist(u);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Friends</h2>");
		
		for (FacebookUser user: friends) {
			
			out.println(user.getEmail());
		}
		out.println("</html></body>");
	}

}
