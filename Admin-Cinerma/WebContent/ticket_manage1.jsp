<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客戶訂票訊管理</title>
<link rel="stylesheet" href="bootstrap/css/mystyle.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>訂票資訊管理</h1>
			<form name="form1" method="post" action="">
				客戶e-mail： <input name="mail_account" type="text" id="mail_account">
				<input type="submit" name="Submit" value="搜尋"> <input
					type="submit" name="Submit" value="顯示所有訂單">
			</form>
		</div>
		<div id="leftbar"></div>
		<div id="content">
			<%
				request.setCharacterEncoding("utf-8");
				String mail_account = request.getParameter("mail_account");
				String option = String.valueOf(request.getParameter("Submit"));
				TicketDAO dao = new TicketDAODBImpl();
				ArrayList<Ticket> ticket_list = dao.getAllTickets();
				if (option.equals("搜尋")) {
					ticket_list = dao.getOrderedTickets(mail_account.trim());
				} else if (option.equals("顯示所有訂單")) {
					ticket_list = dao.getAllTickets();
				}
			%>
			<table border='1'
				class="table table-striped table-hover table-bordered">
				<tr>
					<th>訂票序號</th>
					<th>客戶信箱</th>
					<th>手機號碼</th>
					<th>訂票時間</th>
					<th>場次編號</th>
					<th>人數</th>
					<th>客戶名稱</th>
					<!-- <th>編輯</th> -->
					<th>刪除</th>
				</tr>
				<%
					if (ticket_list != null) {
						for (Ticket ticket : ticket_list) {
				%>
				<tr>
					<td><%=ticket.getTicket_no()%></td>
					<td><%=ticket.getMail_account()%></td>
					<td><%=ticket.getPhone_password()%></td>
					<td><%=ticket.getOrder_date()%></td>
					<td><%=ticket.getSession_ID()%></td>
					<td><%=ticket.getPeople()%></td>
					<%-- <td><%=ticket.getCustomer_name()%></td> --%>
					<!-- <td><a href=modify.jsp?id=" + id + ">編輯</a></td> -->
					<%-- <td><a href="movie_edit.jsp?id=<%=movie.get_m_no()%>">編輯</a></td> --%>
					<td><a href="ticket_delete.jsp?id=<%=ticket.getTicket_no()%>"
						onclick=return(confirm('確定刪除嗎？'))>刪除</a></td>
				</tr>
				<%
					}
					}
				%>
			</table>
		</div>
	</div>
</body>
</html>