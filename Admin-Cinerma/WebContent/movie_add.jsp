<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%-- <jsp:include page="check.jsp" flush="true" /> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="<%=basePath%>">
<title>新增電影資訊</title>
 <meta http-equiv="pragma" content="no-cache">
 <meta http-equiv="cache-control" content="no-cache">
 <meta http-equiv="expires" content="0">

 
<!--  以下2行為日期的元件 -->
 <link href="CalendarControl.css" rel="stylesheet" type="text/css">
 <script src="CalendarControl.js" language="javascript"></script>
</head>
<body>
	<form action="movie_addCheck.jsp" method="POST"
		enctype="multipart/form-data">
		<!-- <form action="upload.jsp" method="POST" enctype="multipart/form-data"> -->
		<table width="300" border="0" align="center" cellpadding="0"
			cellspacing="10">
			<tr>
				<td width="92"><a href="javascript:history.go(-1)">返回上一頁</a></td>
				<td width="178">新增電影資訊頁面</td>
			</tr>
		</table>
		<table width="543" border="0" align="center" cellpadding="0"
			cellspacing="5">
			<tr>
				<td width="185" height="23">電影名稱(中文)：<br></td>
				<td width="353"><input name="movie_name_chinese" type="text"
					id="movie_name_chinese"></td>
			</tr>
			<tr>
				<td width="185" height="23">電影名稱(原文)：<br></td>
				<td width="353"><input name="movie_name_eng" type="text"
					id="movie_name_eng"></td>
			</tr>
			<tr>
				<td>上映日期：</td>
				<td><input name="release_date" type="text" id="release_date"
					value="日期" onfocus="showCalendarControl(this);"> （格式
					1981-01-01） <!-- <input name="todays_date" id="todays_date" class="search-s2 icon-mov" value="日期" onfocus="showCalendarControl(this);" type="text"> -->
				</td>
			</tr>
			<tr>
				<td width="185" height="23">版本：<br></td>
				<td width="353"><input name="version" type="text" id="version"></td>
			</tr>
			<tr>
				<td width="185" height="23">電影長度(分鐘)：<br></td>
				<td width="353"><input name="movie_length" type="text"
					id="movie_length"></td>
			</tr>
			<tr>
				<td width="185" height="23">演員：<br></td>
				<td width="353"><input name="actor" type="text" id="actor"></td>
			</tr>
			<tr>
				<td width="185" height="23">導演：<br></td>
				<td width="353"><input name="director" type="text"
					id="director"></td>
			</tr>
			<td width="185" height="23">圖片：<br></td>
			<td width="353"><input name="picture_url" type="file"
				id="picture_url"></td>
			<!-- <img src="images/the_assassin.jpg"/> -->
			</tr>

			<tr>
				<td><input type="reset" name="Submit2" value="清除"></td>
				<td><input type="submit" name="Submit" value="新增"></td>
			</tr>
		</table>
	</form>

</body>
</html>