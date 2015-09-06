<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客戶訂票訊管理</title>
<link rel="stylesheet" href="css/mystyle.css">
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
				AllJoinDAO dao = new AllJoinDAODBImpl();
				ArrayList<AllJoin> join_list = dao.getAllTickets();
				if (option.equals("搜尋")) {
					join_list = dao.getOrderedTickets(mail_account.trim());
				} else if (option.equals("顯示所有訂單")) {
					join_list = dao.getAllTickets();
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
					<!-- <th>客戶名稱</th> -->
					<th>有(無)效訂單</th>
					
					<th>電影編號</th>
					<th>廳別</th>
					<th>播映時間(合併)</th>
					<th>座位(合併)</th>
					<th>座位售出</th>				
					<th>電影名稱(中文)</th>					
					<th>版本</th>
					<th>seat_list</th>				
					<!-- <th>編輯</th> -->
					<th>刪除</th>
				</tr>
				<%
					if (join_list != null) {						
						for (AllJoin ticket : join_list) {
				%>
				<tr>
					<td><%=ticket.getT_ticket_no()%></td>
					<td><%=ticket.getMail_account()%></td>
					<td><%=ticket.getPhone_password()%></td>
					<td><%=ticket.getOrder_date()%></td>
					<td><%=ticket.getT_session_ID()%></td>
					<td><%=ticket.getPeople()%></td>
					<%-- <td><%=ticket.getCustomer_name()%></td> --%>
					<td><%=ticket.getT_valid()%></td>					
					<td><%=ticket.getS_movie_no()%></td>
					<td><%=ticket.getS_room()%></td>
					<td><%=ticket.getShow_date() + " " + ticket.getShow_time()%></td>
					<td><%="R" + ticket.getR_axis() + "S" + ticket.getS_axis()%></td>
					<td><%=ticket.getSold()%></td>
					<td><%=ticket.getMovie_name_chinese()%></td>					
					<td><%=ticket.getVersion()%></td>
					<td><%=ticket.getSeat_list()%></td>
					
					<!-- <td><a href=modify.jsp?id=" + id + ">編輯</a></td> -->
					<%-- <td><a href="movie_edit.jsp?id=<%=movie.get_m_no()%>">編輯</a></td> --%>
					<td><a href="ticket_cancel.jsp?id=<%=ticket.getT_ticket_no()%>"
						onclick=return(confirm('確定取消訂單嗎？'))>取消</a></td>
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