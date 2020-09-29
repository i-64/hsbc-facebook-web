<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.io.IOException,java.io.PrintWriter,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpSession,com.facebook.entity.FacebookUser,com.facebook.service.FacebookService,com.facebook.utilities.ServiceFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	
	FacebookUser u = new FacebookUser();
	u.setEmail(email);
	u.setPassword(password);
	
	FacebookService f = ServiceFactory.createObject();
	
	if (f.loginService(u)) {
		HttpSession s = request.getSession(true);
		s.setAttribute("user", email);
		s.setAttribute("pass", password);
	%>
	Welcome !<br><a href=friendlist.html>Friendlist</a>
	<% } else { %>
	Authentication failed :(
	<% } %>
</body>
</html>