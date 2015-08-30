<%-- <%@page import="edu.pccu.Movie.MovieDAODBImpl"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.text.*,edu.pccu.Movie.*,java.util.*"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增確認</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		String movie_name_chinese = request.getParameter("movie_name_chinese").trim();
		String movie_name_eng = request.getParameter("movie_name_eng").trim();
		/* String dateString = request.getParameter("release_date");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date release_date = dateFormat.parse(dateString); */
		String release_date = request.getParameter("release_date").trim();
		String version = request.getParameter("version").trim();
		int movie_length = Integer.parseInt(request.getParameter("movie_length"));
		String actor = request.getParameter("actor").trim();
		String director = request.getParameter("director").trim();
		String picture_url = request.getParameter("picture_url").trim();
		MovieDAO dao = new MovieDAODBImpl();		
		Movie add_movie = new Movie(movie_name_chinese, movie_name_eng, release_date, version, movie_length, actor,
				director, picture_url);
		int count = dao.add1(add_movie);
		if (count != 0) {
			out.print(count + "筆資料新增成功！");
	%>
	<%-- <script type="text/javascript">
		alert("1筆資料新增成功！");
		//alert('<% %>');
	</script> --%>
	<%
		//response.sendRedirect("movie_manage.jsp");
		} else {
			out.print("新增失敗！");
		}
	%>
</body>
</html>