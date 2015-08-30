<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*,javax.swing.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>刪除訂票]資訊</title>
</head>
<body>
<%
Ticket ticket = new Ticket(Integer.valueOf(request.getParameter("id")),"","","",0,0,"");
/* Movie movie = new Movie(
		Integer.valueOf(request.getParameter("id")),"","","","",0,"","","");
MovieDAO dao = new MovieDAODBImpl(); */
TicketDAO dao = new TicketDAODBImpl();
int count = dao.remove_ticket(ticket);
//int count = 1;
String message = "";
if(count >= 0){
	message = "成功刪除"+ count +"筆資料!!";
}else{
	message = "資料刪除失敗!!";
}
out.println("<script language='javaScript'>");
out.println("alert('" + message + "')");
out.println("window.location = 'ticket_manage.jsp'");
out.println("</script>");
%>
</body>
</html>