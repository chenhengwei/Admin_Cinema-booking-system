<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border='1' width='100%'>
<tr>
<th >雇员号</th >
<th >姓名</th >
<th >出生日期</th >
<th >薪水</th >
<th >编辑</th >
<th >删除</th >
</tr>

<tr>
<td >" + id + "</td>
<td >" + rs.getString("employee_name") + "</td>
<td >" + rs.getDate("birthday") + "</td>
<td >" + rs.getInt("salary") + "</td>
<td><a href=modify.jsp?id=" + id + ">编辑</a></td>
<td><a href=delete.jsp?id=" + id + " onclick=return(confirm('确定删除吗？'))>删除</a></td>
</tr>
</table>
</body>
</html>