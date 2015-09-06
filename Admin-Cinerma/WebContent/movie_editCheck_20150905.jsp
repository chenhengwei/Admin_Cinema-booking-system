<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改確認</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
		//String str_movie_no=(String)session.getAttribute("movie_no");
		//String test=(String)session.getAttribute("test");
		//out.println("電影編號為:" + str_movie_no);
		//out.println("test:" + test); 
		//int movie_no = Integer.valueOf(str_movie_no);
		int movie_no = Integer.valueOf(request.getParameter("movie_no"));

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
		%>
		<%
		MovieDAO dao = new MovieDAODBImpl();
		Movie modified_movie = new Movie(movie_no, movie_name_chinese, movie_name_eng, release_date, version,
				movie_length, actor, director, picture_url);
		int count = dao.update_Movie2(modified_movie);
		if (count != -1) {
			//out.print(count + "筆資料更新成功！");
			String message = count + "筆資料更新成功！";
			//out.print("<SCRIPT LANGUAGE='JavaScript'>");
			//out.println("<!--");
			//out.print("alert('" + message + "')");
			//out.println("//-->");
			//out.print("</SCRIPT>");
			response.sendRedirect("movie_manage.jsp");
		} else {
			out.print("更新失敗！");
		}
	%>
</body>
</html>