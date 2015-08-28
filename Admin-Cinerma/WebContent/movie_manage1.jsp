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
<link rel="stylesheet" href="bootstrap/css/mystyle.css">
<!-- 以下5行匯入BootStrap -->
<!-- <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css">
<script src="jquery/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css"> -->

<title>電影資訊管理</title>
</head>
<body>
	<div>
		<h1>電影資訊管理</h1>
	</div>
	<div>
		<table>
			<tr>
				<td><a href="add_movie.jsp">新增電影</a></td>
				<!-- <td>
			<form method="post" action="" class="navbar-form navbar-left"
					role="search">
					<div class="form-group">
						<input type="text" name="movie_name_chinese"
							id="movie_name_chinese" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">搜尋</button>
				</form>
			</td> -->
				<!-- <form name="form1" method="post" action=""> -->
				<td></td>
				<td>電影名稱： <input name="movie_name_chinese" type="text"
					id="movie_name_chinese"> <input type="submit" name="Submit"
					value="搜尋">
				</td>
				<!-- </form> -->
			</tr>
		</table>
		<%
			request.setCharacterEncoding("utf-8");
			String movie_name = request.getParameter("movie_name_chinese");
			//Movie mm = new Movie("aa","bb","2015-08- 24","DD",70,"RR","TT","LL");
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
		<table border='1'
			class="table table-striped table-hover table-bordered">
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
				<!-- <td><a href=modify.jsp?id=" + id + ">編輯</a></td> -->
				<td><a href="movie_edit.jsp?id=<%=movie.get_m_no()%>">編輯</a></td>
				<td><a href=delete.jsp?id= <%=movie.get_m_no()%>
					onclick=return(confirm('確定刪除嗎？'))>刪除</a></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</div>
	<%-- 	<%=movie_name %> --%>
</body>
</html>