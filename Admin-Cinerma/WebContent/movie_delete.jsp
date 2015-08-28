<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>刪除電影資訊</title>
</head>
<body>
<%
Movie movie = new Movie(
		Integer.valueOf(request.getParameter("id")),"","","","",0,"","","");
MovieDAO dao = new MovieDAODBImpl();

int count = dao.remove_Movie2(movie);
String message = "";
if(count >= 0){
	message = "成功刪除"+ count +"筆資料!!";
}else{
	message = "資料刪除失敗!!";
}
out.print(count);
//JOptionPane.showMessageDialog(null, "哈囉");
//response.sendRedirect("StudentList.jsp");
%>
</body>
</html>