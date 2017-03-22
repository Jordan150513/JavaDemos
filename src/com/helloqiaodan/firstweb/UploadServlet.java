package com.helloqiaodan.firstweb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;


/**
 * Servlet implementation class UploadServlet
 */
// html跳转的		   localhost:8080/01-firstWeb/servlet/UploadServlet?file1=C%3A%5CUsers%5C%E4%B9%94%E4%B8%B9%5CDocuments%5Cgitignore_global.txt&file2=C%3A%5CUsers%5C%E4%B9%94%E4%B8%B9%5CDocuments%5Chgignore_global.txt&description1=git&description2=hp
//直接访问路径：http://localhost:8080/01-firstWeb/servlet/UploadServlet
@WebServlet("/UploadServlet")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.getWriter().println("use post method");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		File file1 = null,file2 = null;
		String description1 = null,description2 = null;
		PrintWriter out = response.getWriter();
		DiskFileUpload diskFileUpload = new DiskFileUpload();
		try{
			List<FileItem> list = diskFileUpload.parseRequest(request);
			out.println("遍历所有的fileItem...<br/>");
			for(FileItem fileItem :list){
				if(fileItem.isFormField()){
					//如果是文本域
					if("description1".equals(fileItem.getString())){
						out.println("遍历到description1...<br/>");
						description1 = new String(fileItem.getString().getBytes(),"UTF-8");
					}
					if("description2".equals(fileItem.getString())){
						out.println("遍历到description2...<br/>");
						description2 = new String(fileItem.getString().getBytes(),"UTF-8");
					}
				}else{
					// 是文件域
					if("file1".equals(fileItem.getFieldName())){
						File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
						out.println(" search file1...<br/>");
						out.println("client file location:"+remoteFile.getAbsolutePath()+"<br/>");
						// 服务器端
						file1 = new File(this.getServletContext().getRealPath("attachment"),remoteFile.getName());
						file1.getParentFile().mkdirs();
						file1.createNewFile();
						
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(file1);
						
						try{
							byte[] buffer= new byte[1024];//字节缓存
							int len = 0;
							while((len=ins.read(buffer))>-1)
								//循环读入缓存
								ous.write(buffer,0,len);
								out.println("have save file1"+file1.getAbsolutePath()+"<br/>");
							}finally{
								ous.close();
								ins.close();
							}
					}
					
					//file2
					if("file2".equals(fileItem.getFieldName())){
						File remoteFile = new File(new String(fileItem.getName().getBytes(),"UTF-8"));
						out.println("search the file1...<br/>");
						out.println("remote file location:"+remoteFile.getAbsolutePath()+"<br/>");
						// 服务器端
						file2 = new File(this.getServletContext().getRealPath("attachment"),remoteFile.getName());
						file2.getParentFile().mkdirs();
						file2.createNewFile();
						
						InputStream ins = fileItem.getInputStream();
						OutputStream ous = new FileOutputStream(file1);
						
						try{
							byte[] buffer= new byte[1024];//字节缓存
							int len = 0;
							while((len=ins.read(buffer))>-1)
								//循环读入缓存
								ous.write(buffer,0,len);
								out.println("have save file:"+file2.getAbsolutePath()+"<br/>");
							}finally{
								ous.close();
								ins.close();
							}
					}
					
				}
			}
			out.println("done");
		}catch(FileUploadException e){}
		
		if(file1 != null){
			out.println("<a href='"+request.getContextPath()+"/attachment/"+file1.getName()+">");

			out.println("<a href='"+request.getContextPath()+"/attachment/"+file2.getName()+">");
		}
		
		
//		閬嶅巻鎵€鏈夌殑fileItem...
//		 search file1...
//		 client file location:C:\Users\涔斾腹\Documents\gitignore_global.txt
//		 have save file1D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01-firstWeb\attachment\gitignore_global.txt
//		 search the file1...
//		 remote file location:C:\Users\涔斾腹\Documents\hgignore_global.txt
//		 have save file:D:\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\01-firstWeb\attachment\hgignore_global.txt
//		 done 	
		
		
		
//		String name = request.getParameter("name");
//		String password = request.getParameter("password");
//		String sex = request.getParameter("sex");
//		 int age = 0;
//		 try{
//			 age = Integer.parseInt(request.getParameter("age"));
//		 }catch(Exception e){}
//		 Date birthday = null;
//		 try{
//			 DateFormat  format = new SimpleDateFormat("yyyy-MM-dd");
//			 birthday = format.parse(request.getParameter("birthday"));
//		 }catch(Exception e){}
//		 
//		 String interesting[] = request.getParameterValues("interesting");
//		 String area = request.getParameter("area");
//		 String description = request.getParameter("description");
//		 response.setContentType("text/html");
//		 PrintWriter out = response.getWriter();
//		 out.println("Thank you for your submit");
//		 out.println("name:"+name);
//		 out.println("password"+password);
//		 out.println("sex:"+sex);
//		 out.println("birthday:"+birthday);
//		 out.println("interesting:"+interesting);
//		 out.println("description:"+description);
		 
		 
	}

}
