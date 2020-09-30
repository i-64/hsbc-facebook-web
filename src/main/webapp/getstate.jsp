<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%

Connection con = null;

try {
	
	Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
	con = DriverManager.getConnection("jdbc:derby:/home/i-64/Downloads/mydb1;create=true","mrunal","0348");
	
	String country = request.getParameter("country");
	String state = request.getParameter("prefix");
	
	PreparedStatement ps = con.prepareStatement("select SNAME from STATE where COUNTRYNAME=?");
	ps.setString(1, country);
	
	ResultSet rs = ps.executeQuery();
	String str = "";
	
	while (rs.next()) {
		
		String curr = rs.getString(1);
		if (curr.contains(state))
			str = str + "," + curr;
	}
	
	response.setContentType("text/html");
	out.println(str);
	
} catch (ClassNotFoundException | SQLException e) {
	
	e.printStackTrace();
}
finally {
	
	try {
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
}

%>