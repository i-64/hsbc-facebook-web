<%@page import="com.facebook.entity.FacebookUser,java.sql.DriverManager,java.sql.PreparedStatement,java.sql.Connection,java.sql.ResultSet,java.lang.ClassNotFoundException,java.sql.SQLException" %>

<%

String email = request.getParameter("email");
response.setContentType("text/html");
Connection con = null;

try {
	
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb1;create=true","mrunal","0348");
	PreparedStatement ps = con.prepareStatement("select * from FBTABLE where email=?");
	ps.setString(1, email);
	ResultSet res = ps.executeQuery();
	
	System.out.println("fuck");
	
	if (res.next())
		out.println("<font color=red> Email already in use, try signing in </font>");
	else
		out.println("<font color=green> good </font>");
	
} catch (ClassNotFoundException | SQLException e) {
	
	e.printStackTrace();
}

%>