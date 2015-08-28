<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改電影資訊</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String movie_str = request.getParameter("id");
		int movie_no = Integer.valueOf(movie_str);
		//session.setAttribute("movie_str", movie_str);
		//request.setAttribute("test", 444); 
		MovieDAO dao = new MovieDAODBImpl();
		Movie movie = dao.findById_movie_no(movie_no);
		out.println(movie_no);
		out.println("電影:" + movie.get_m_name_c());
	%>
	<table width="300" border="0" align="center" cellpadding="0"
		cellspacing="10">
		<tr>
			<!-- <td width="92"><a href="javascript:history.go(-1)">返回上一頁</a></td> -->
			<td width="178">修改電影資訊頁面</td>
		</tr>
	</table>
	<form name="form1" action="movie_editCheck.jsp" method="post">
		<table width="543" border="0" align="center" cellpadding="0"
			cellspacing="5">
			<tr>
				<td width="185" height="23">電影編號：<br></td>
				<td width="353"> <%=movie.get_m_no() %></td>
			</tr>			
			<tr>
				<td width="185" height="23">電影名稱(中文)：<br></td>
				<td width="353"><input name="movie_name_chinese" type="text"
					id="movie_name_chinese" value=<%=movie.get_m_name_c()%>></td>
			</tr>
			<tr>
				<td width="185" height="23">電影名稱(原文)：<br></td>
				<td width="353"><input name="movie_name_eng" type="text"
					id="movie_name_eng" value=<%=movie.get_m_name_e()%>></td>
			</tr>
			<tr>
				<td>上映日期：</td>
				<td><input name="release_date" type="text" id="release_date"
					value=<%=movie.get_release_date()%>> （格式 1981-01-01）</td>
			</tr>
			<tr>
				<td width="185" height="23">版本：<br></td>
				<td width="353"><input name="version" type="text" id="version"
					value=<%=movie.get_version()%>></td>
			</tr>
			<tr>
				<td width="185" height="23">電影長度(分鐘)：<br></td>
				<td width="353"><input name="movie_length" type="text"
					id="movie_length" value=<%=movie.get_m_length() %>></td>
			</tr>
			<tr>
				<td width="185" height="23">演員：<br></td>
				<td width="353"><input name="actor" type="text" id="actor"
					value=<%=movie.get_actor()%>></td>
			</tr>
			<tr>
				<td width="185" height="23">導演：<br></td>
				<td width="353"><input name="director" type="text"
					id="director" value=<%=movie.get_director() %>></td>
			</tr>
			<td width="185" height="23">圖片：<br></td>
			<td width="353"><input name="picture_url" type="text"
				id="picture_url" value=<%=movie.get_picture_url() %>></td>
			</tr>

			<tr>				
				<td><input type="button" name="cancel" value="取消"
					onclick="javascript:history.go(-1)"></td>
				<td><input type="submit" name="Submit" value="確認"></td>
				<td><input type="hidden" name="movie_no" value="<%=movie_no %>" /></td>
			</tr>
		</table>
	</form>
</body>
</html>