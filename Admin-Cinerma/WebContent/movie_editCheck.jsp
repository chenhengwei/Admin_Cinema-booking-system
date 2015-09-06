<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="edu.pccu.Movie.*,java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.nio.file.*"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.io.FilenameUtils"%>    
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
		int movie_no = 0;
		String movie_name_chinese = "";
		String movie_name_eng = "";
		/* String dateString = request.getParameter("release_date");
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date release_date = dateFormat.parse(dateString); */
		String release_date = "";
		String version = "";
		int movie_length = 0;
		String actor = "";
		String director = "";
		String picture_url = "";
		//以下處理上傳作業
		//String saveDirectory = application.getRealPath("/images");
	try {
		//String saveDirectory = getServletContext().getRealPath("/images");
		//String saveDirectory = request.getRequestURI();
		String saveDirectory = "C:/eclipse/workspace/admin system/WebContent/images";
		out.println(saveDirectory); // 設定好絕對路徑(程式在電腦中執行的路徑)
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		ProgressListener progressListener = new ProgressListener() {
			private long megaBytes = -1;

			public void update(long pBytesRead, long pContentLength, int pItems) {
				long mBytes = pBytesRead / 1000000;
				if (megaBytes == mBytes) {
					return;
				}
				megaBytes = mBytes;
				System.out.println("We are currently reading item " + pItems);
				if (pContentLength == -1) {
					System.out.println("So far, " + pBytesRead + " bytes have been read.");
				} else {
					System.out.println(
							"So far, " + pBytesRead + " of " + pContentLength + " bytes have been read.");
				}
			}
		};
		upload.setProgressListener(progressListener);
		List items = upload.parseRequest(request);
		Iterator iter = items.iterator();
		while (iter.hasNext()) {
			FileItem item = (FileItem) iter.next();

			if (item.isFormField()) {
				// Process a regular form field
				//processFormField(item);
				//out.println("<p>a FormField</p>");

				String name = item.getFieldName();
				String value = item.getString("UTF-8").trim();
				//out.println(name + "=" + value+"<br>");
				if(name.equals("movie.get_m_no()")){
					movie_no = Integer.valueOf(value);
					out.println("</br>movie_name_chinese:" + movie_name_chinese + "<br>");
				}				
				if (name.equals("movie_name_chinese")) {
					movie_name_chinese = value;
					out.println("</br>movie_name_chinese:" + movie_name_chinese + "<br>");
				}
				if (name.equals("movie_name_eng")) {
					movie_name_eng = value;
					out.println("movie_name_eng:" + movie_name_eng + "<br>");
				}
				if (name.equals("release_date")) {
					release_date = value;
					out.println("release_date:" + release_date + "<br>");
				}
				if (name.equals("version")) {
					version = value;
					out.println("version:" + version + "<br>");
				}
				if (name.equals("movie_length")) {
					movie_length = Integer.valueOf(value);
					out.println("movie_length:" + movie_length + "<br>");
				}
				if (name.equals("actor")) {
					actor = value;
					out.println("actor:" + actor + "<br>");
				}
				if (name.equals("director")) {
					director = value;
					out.println("director:" + director + "<br>");
				}
			} else {
				//Process a file upload
				//processUploadedFile(item);
				String fileName = item.getName();
				if (fileName != null && !"".equals(fileName)) {
					fileName = FilenameUtils.getName(fileName);
					out.println("fileName saved=" + fileName + "<br>");
					//File uploadedFile = new File(saveDirectory, fileName);
					File uploadedFile = new File("images", fileName);
					//item.write(uploadedFile);					
					picture_url = "images/" + fileName;
					out.print("picture_url:" + "images/" + fileName + "<br>");
				}else{
					picture_url = fileName;
				}
			}
		}
	} catch (FileUploadException e) {
		throw new ServletException("Cannot parse multipart request.", e);
	}
		%>
		<%
		MovieDAO dao = new MovieDAODBImpl();
		Movie modified_movie = new Movie(movie_no, movie_name_chinese, movie_name_eng, release_date, version,
				movie_length, actor, director, picture_url);
		int count = dao.update_Movie2(modified_movie);
		String message = "";
		if (count != -1) {
			//out.print(count + "筆資料更新成功！");
			message = count + "筆資料更新成功！";
			//out.print("<SCRIPT LANGUAGE='JavaScript'>");
			//out.println("<!--");
			//out.print("alert('" + message + "')");
			//out.println("//-->");
			//out.print("</SCRIPT>");
			//response.sendRedirect("movie_manage.jsp");
		} else {
			message = "更新失敗！";
		}
		out.println("<script language='javaScript'>");
		out.println("alert('" + message + "')");
		out.println("window.location = 'movie_manage.jsp'");
		out.println("</script>");
	%>
</body>
</html>