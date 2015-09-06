<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="java.io.*"%>
<%@ page import="java.nio.file.*"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="org.apache.commons.fileupload.*"%>
<%@ page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@ page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page import="org.apache.commons.io.FilenameUtils"%>
<%
	String saveDirectory = application.getRealPath("/upload");
	out.println(saveDirectory);		// 設定好絕對路徑(程式在電腦中執行的路徑)
    boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    out.println("<br />isMultipart="+isMultipart+"<br>");
    
    /*
    Part filePart = request.getPart("userfile"); 	// Retrieves <input type="file" name="file">
    if (filePart == null)
    {
    	out.println("filePart is null");
    }
    else
    {
    	InputStream in = filePart.getInputStream();
        Path p = Paths.get(saveDirectory + "/test.png");
        Files.copy(in, p);	
    }
    */
    
    // Create a factory for disk-based file items
    FileItemFactory factory = new DiskFileItemFactory();
 
    // Create a new file upload handler
    ServletFileUpload upload = new ServletFileUpload(factory);

    //Create a progress listener
    ProgressListener progressListener = new ProgressListener(){
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
               System.out.println("So far, " + pBytesRead + " of " + pContentLength
                                  + " bytes have been read.");
           }
       }
    };
    upload.setProgressListener(progressListener);
    
 // Parse the request
    List /* FileItem */ items = upload.parseRequest(request);
 
 // Process the uploaded items
    Iterator iter = items.iterator(); 
    while (iter.hasNext()) {
        FileItem item = (FileItem) iter.next();

        if (item.isFormField()) {
            // Process a regular form field
            //processFormField(item);
            out.println("<p>a FormField</p>");
            
            String name = item.getFieldName();
            String value = item.getString("UTF-8");
            out.println(name + "=" + value+"<br>");
            
            
        } else {
            // Process a file upload
            //processUploadedFile(item);
            
            
            out.println("<p>a file Field</p>");
            
            String fieldName = item.getFieldName();
            String fileName = item.getName();
            String contentType = item.getContentType();
            boolean isInMemory = item.isInMemory();
            long sizeInBytes = item.getSize();
            out.println("fieldName="+fieldName+"<br>");
            out.println("fileName="+fileName+"<br>");
            out.println("contentType="+contentType+"<br>");
            out.println("isInMemory="+isInMemory+"<br>");
            out.println("sizeInBytes="+sizeInBytes+"<br>");
            
            if (fileName != null && !"".equals(fileName)) {
                fileName= FilenameUtils.getName(fileName);
                out.println("fileName saved="+fileName+"<br>");
                File uploadedFile = new File(saveDirectory, fileName);
                item.write(uploadedFile);
            }
            
        }
    }    
%>