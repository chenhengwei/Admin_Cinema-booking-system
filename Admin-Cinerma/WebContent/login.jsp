<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP登入頁面</title>
<script language="javascript">
function check_data()
{
   var flag = true;
   var message = '';

   // ---------- Check ----------
   var stu_name = document.getElementById('stu_name');
   if(stu_name.value=='')
   {
      message = message + '姓名不能為空白\n';
      flag = false;
   }
   // ---------- Check ----------
   var stu_tel = document.getElementById('stu_tel');
   //if(stu_tel.value=='')
	if(isNaN(stu_tel))
   {
      message = message + '電話必須為數字\n';
      flag = false;
   }

   if(!flag) 
   {
      alert(message);
   }
   return flag;
}
</script>
</head>
<body>
<h2>資料輸入：常規表示式檢查</h2>
<form method="post" action="movie_add.jsp" onsubmit="return check_data();">
  <p>Student Name：<input name="stu_name" type="text" id="stu_name" size="20" /> (姓名不得為空白)</p>
  <p>Student Tel：<input name="stu_tel" type="text" id="stu_tel" size="20" /> (必須輸入數字)</p>
  <p><input type="submit" value="送出" /></p>
</form></body>
</html>