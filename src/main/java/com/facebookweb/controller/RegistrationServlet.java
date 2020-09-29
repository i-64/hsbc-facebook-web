package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebook.entity.FacebookUser;
import com.facebook.service.FacebookService;
import com.facebook.utilities.ServiceFactory;

/**
 * 
 * @author Mrunal Ahire
 * 
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String state = request.getParameter("state");
		
		FacebookUser u = new FacebookUser();
		
		u.setCountry(country);
		u.setEmail(email);
		u.setName(name);
		u.setPassword(password);
		u.setPhone(phone);
		u.setState(state);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		FacebookService fs = ServiceFactory.createObject();
		
		if (fs.registerService(u) == 1) {
			
			out.println("Successfully created User, proceed to <a href=login.html>Login</a>");
		}
		else {
			
			out.println("Could not create User");
		}
	}
}
