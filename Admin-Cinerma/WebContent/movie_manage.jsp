<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*"%>
<%-- <jsp:include page="check.jsp" flush="true" /> --%>
<%-- <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 	 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<!-- <meta http-equiv="keywords" content="JSP,员工管理系统">
<meta http-equiv="description" content="www.xin126.cn原创教程"> -->
<title>電影資訊管理</title>
</head>
<body>
	<table width="491" border="0" align="center" cellpadding="0"
		cellspacing="10">
		<tr>
			<td colspan="3"><div align="center">
					<span class="STYLE2">電影資訊管理</span>
				</div></td>
		</tr>
		<tr>
			<td width="177"><a href="add_movie.jsp">新增電影</a></td>

			<form name="form1" method="post" action="">
				<td width="232">電影名稱： <input name="movie_name_chinese"
					type="text" id="movie_name_chinese">					
				</td>
				<td width="42"><input type="submit" name="Submit" value="搜尋"></td>
			</form>
		</tr>
		<tr>
			<td colspan="3">
				<%
					request.setCharacterEncoding("utf-8");
					String movie_name = request.getParameter("movie_name_chinese");
					MovieDAO dao = new MovieDAODBImpl();
					ArrayList<Movie> movie_list = null;

					if (movie_name == null) {
						movie_name = "";
					}
					if (movie_name == "") {
						movie_list = dao.getAllMovies();
					} else {
						//condition="SELECT * FROM employee_info where employee_name='"+username+"'";
						movie_list = dao.findByName(movie_name);
						
					}
				%>
				<table border='1' width='150%'>
					<tr>
						<th>編號</th>
						<th>電影名稱(中文)</th>
						<th>電影名稱(英文)</th>
						<th>上映日期</th>
						<th>版本</th>
						<th>長度</th>
						<th>演員</th>
						<th>導演</th>
						<th>圖片</th>
						<th>編輯</th>
						<th>刪除</th>
					</tr>
					<%
						if (movie_list != null) {
							for (Movie movie : movie_list) {
					%>
					<tr>
						<td><%=movie.get_m_no()%></td>
						<td><%=movie.get_m_name_c()%></td>
						<td><%=movie.get_m_name_e()%></td>
						<td><%=movie.get_release_date()%></td>
						<td><%=movie.get_version()%></td>
						<td><%=movie.get_m_length()%></td>
						<td><%=movie.get_actor()%></td>
						<td><%=movie.get_director()%></td>
						<td><%=movie.get_picture_url()%></td>
						<td><a href=modify.jsp?id=" + id + ">編輯</a></td>
						<td><a href=delete.jsp?id= " + id + " onclick=return(confirm('確定刪除嗎？'))>刪除</a></td>
					</tr>
					<%
						}
						}
					%>
				</table>
			</td>
		</tr>
	</table>
	<%=movie_name %>
</body>
</html>