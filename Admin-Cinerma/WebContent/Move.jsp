<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*, java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//StudentDAO dao = new StudentDAODBlmpl();
MovieDAO dao = new MovieDAODBImpl();
ArrayList<Movie> list = dao.getAllMovies();

%>

<table border="1">
<tr><th>ID</th><th>Name</th><th>Tel</th></tr>
<%
for (Movie m : list) {
%>

<tr><td><%=m.get_m_no() %></td><td><%=m.get_m_name_c() %></td><td><%=m.get_m_name_e() %></td></tr>
<%
}
%>
</table>
</body>
</html>