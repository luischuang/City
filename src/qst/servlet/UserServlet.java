package qst.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qst.dao.UserDao;
import qst.model.User;

/**
 * 鐢ㄦ埛鐩稿叧鎿嶄綔
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		//String str=new String("".getBytes("ISO-8859-1"),"UTF-8");///澶勭悊get鎻愪氦鐨勪贡鐮侀棶棰�
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String flag=request.getParameter("flag");
		System.out.println(flag);
		String remenberPass=request.getParameter("remenberPass");
		Cookie c=null;
		/**
		 * 鐧诲綍
		 */
		if("login".equals(flag)){
			String userName=request.getParameter("userName");
			String userPassword=request.getParameter("userPassword");
			User user =UserDao.login(userName, userPassword);
			if(user!=null){
				session.setAttribute("user", user);
				if("on".equals(remenberPass)){
					c=new Cookie("userName", userName);
					c.setMaxAge(60*60*24);
					response.addCookie(c);
					c=new Cookie("userPassword", userPassword);
					c.setMaxAge(60*60*24);
					response.addCookie(c);
				}
				if(user.getUser_type()==1)
					response.sendRedirect("admin/adminTemp.jsp");
				else if(user.getUser_type()==0){
					response.sendRedirect("user/usermain.jsp");
				}
			}else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>alert('用户名或密码错误');history.go(-1)</script>");
			}
			/**
			 * 閫�鍑虹櫥褰�
			 */
		}else if("modify".equals(flag)){
			boolean isExist=false;
			int total=0;
			int userId=Integer.parseInt(request.getParameter("user_id").toString());
			String oldPassword=request.getParameter("oldPass");
			String newPassword=request.getParameter("newPass");
			List<User> allUsers=new ArrayList<User>();
			allUsers=UserDao.getAllUsers(""+userId);
			if(allUsers!=null){
				total=allUsers.size();
			}else{
				response.getWriter().println("<script>alert('您已登出，请登录！');");
				response.sendRedirect("login.jsp");
			}
			for(int i=0;i<total;i++){
				User user=allUsers.get(i);

				if(user.getUser_id()==userId&&user.getUser_password().equals(oldPassword)){
					isExist=true;
					break;
				}
			}
			if(isExist){
				if(UserDao.modifyUser(userId, newPassword)){
					response.getWriter().println("<script>alert('更改成功！');history.go(-1)</script>");
				}else{
					response.getWriter().println("<script>alert('发生错误！');history.go(-1)</script>");
				}
			}else{
				response.getWriter().println("<script>alert('原密码错误！');history.go(-1)</script>");
			}
			
			//request.getSession().invalidate();
			//response.sendRedirect("login.jsp");
			/**
			 * 娉ㄥ唽
			 */
		}else if("logout".equals(flag)){
			request.getSession().invalidate();
			response.sendRedirect("login.jsp");
		}else if("register".equals(flag)){
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username.indexOf(" ")!=-1 || password.indexOf(" ")!=-1){
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>alert('用户名或密码不能为空！');history.go(-1)</script>");
			}else{
				if(UserDao.checkUser(username)){
					response.setCharacterEncoding("UTF-8");
					response.setContentType("text/html;charset=UTF-8");
					response.getWriter().println("<script>alert('用户名已存在！');history.go(-1)</script>");
				}else {
					boolean success=UserDao.register(new User(0,username,password,0,0));
					if(success){
						response.sendRedirect("login.jsp");
					}else {
						response.sendRedirect("admin/register.jsp");
					}
				}
			}
			

			/**
			 * 鏌ユ壘鐢ㄦ埛鍒楄〃
			 */
		}else if("userList".equals(flag)){
			int rows=5;
			int goPage=1;
			int total=0;
			int page=0;
			String userid=request.getParameter("userid");
			List<User> allUsers=new ArrayList<User>();
			allUsers=UserDao.getAllUsers(userid);
			if(allUsers!=null){
				total=allUsers.size();
			}
			page=(total+rows-1)/rows;
			if(page==0){
				page=1;
			}
			String pageStr=request.getParameter("goPage");
			if(pageStr!=null&&!"".equals(pageStr)){
				goPage=Integer.parseInt(pageStr);
			}
			
			List<User> userList=new ArrayList<User>();
			userList=UserDao.getUsers(userid,(goPage-1)*rows,rows);
			request.setAttribute("userid", userid);
			request.setAttribute("userList", userList);
			request.setAttribute("size", userList.size());
			request.setAttribute("page", page);
			request.setAttribute("goPage", goPage);
			request.getRequestDispatcher("admin/userList.jsp").forward(request, response);
			/**
			 * 鍒犻櫎鐢ㄦ埛
			 */
		}else if ("del".equals(flag)) {
			String idStr=request.getParameter("uid");
			int uid=Integer.parseInt(idStr);
			boolean f=UserDao.updateUserStateById(uid);
//			boolean f=UserDao.deleteUserById(uid);
			if(f){
				request.getRequestDispatcher("UserServlet?flag=userList").forward(request, response);
			}else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>alert('删除失败！');history.go(-1)</script>");
			}
			/**
			 * 鏇存敼鐢ㄦ埛淇℃伅
			 */
		}else if ("toUpdate".equals(flag)) {
			String idStr=request.getParameter("uid");
			int uid=Integer.parseInt(idStr);
			User user=UserDao.getUserById(uid);
			request.setAttribute("user", user);
			request.getRequestDispatcher("admin/userUpdate.jsp").forward(request, response);

		}else if ("update".equals(flag)) {
			String idStr=request.getParameter("id");
			int id=Integer.parseInt(idStr);
			String password=request.getParameter("password");
			boolean f=UserDao.updateUserById(id,password);
			if(f){
				request.getRequestDispatcher("UserServlet?flag=userList").forward(request, response);
			}else {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println("<script>alert('修改失败！');history.go(-1)</script>");
			}
		}
		
	}
	
	

}
