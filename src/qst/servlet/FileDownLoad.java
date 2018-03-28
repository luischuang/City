package qst.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 下载文件
 * Servlet implementation class FileDownLoad
 */
@WebServlet("/FileDownLoad")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownLoad() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename=request.getParameter("name");
		//filename=new String(filename.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println(filename);
		OutputStream outputStream=response.getOutputStream();
		byte b[]=new byte[600];
		File fileload=new File(FileDownLoad.class.getResource("/"+filename).getFile());
		String agent=request.getHeader("User-Agent");
		if(agent!=null&&agent.toLowerCase().indexOf("firefox")>0){
			filename=new String(filename.getBytes("UTF-8"),"ISO-8859-1");
		}else {
			filename=URLEncoder.encode(filename,"UTF-8");
		}
		response.setHeader("Content-disposition", "attachment;filename="+filename);
		response.setContentType("application/msword;charset=UTF-8");
		long fileLength=fileload.length();
		String length=String.valueOf(fileLength);
		response.setHeader("Content_length", length);
		
		FileInputStream inputStream=new FileInputStream(fileload);
		int n=0;
		while((n=inputStream.read(b))!=-1){
			outputStream.write(b,0,n);
		}
	}

}
