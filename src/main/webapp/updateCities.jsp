<%@page import="java.util.ArrayList"%>
<%

String prefix = request.getParameter("prefix");
ArrayList <String> list = new ArrayList<>();

response.setContentType("text/html");

list.add("Mumbai");
list.add("Kolkata");
list.add("Delhi");
list.add("Hyderabad");
list.add("Pune");
list.add("Bangalore");
list.add("Noida");
list.add("Ghaziabad");
list.add("Chennai");
list.add("Bhubhaneshwar");
list.add("Thane");
list.add("Nagpur");
list.add("Nasik");
list.add("Palghar");
list.add("Indore");
list.add("Patna");
list.add("Varanasi");
list.add("Kanpur");
list.add("Lucknow");
list.add("Chandigarh");
list.add("Agra");
list.add("Surat");
list.add("Amhedabad");
list.add("Navi Mumbai");
list.add("Ranchi");
list.add("Amritsar");
list.add("Allahbad");
list.add("Dehradun");
list.add("Jammu");
list.add("Bhopal");
list.add("Vishakhapatnam");
list.add("Jaipur");
list.add("Pimpri-Chinchwad");
list.add("Dhanbad");
list.add("Srinagar");
list.add("Raipur");
list.add("Coimbatore");

StringBuilder ret = new StringBuilder();

for (String s: list) {
	if (s.contains(prefix)) {
		ret.append("," + s);
	}
}

out.println(ret.toString());

%>