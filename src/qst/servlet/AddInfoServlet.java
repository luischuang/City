package qst.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import qst.dao.InfoDao;
import qst.model.Info;
import qst.model.User;

/**
 * 鍙戝竷淇℃伅
 * Servlet implementation class AddInfoServlet
 */
@WebServlet("/AddInfoServlet")
public class AddInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().println("<script>alert('您未登录，请登录再发布。');window.location.href='login.jsp</script>");
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String infoType=request.getParameter("infoType");
		String infoTitle=request.getParameter("infoTitle");
		String infoContent=request.getParameter("infoContent");
		String infoPhone=request.getParameter("infoPhone");
		String infoLinkman=request.getParameter("infoLinkman");
		String infoEmail=request.getParameter("infoEmail");
		//System.out.println(infoContent);
		User user=(User)request.getSession().getAttribute("user");
		//System.out.println(user.getUser_name());
		if(user!=null){
			Info info=new Info();
			info.setInfotypeid(Integer.parseInt(infoType));
			info.setInfoTitle(infoTitle);
			info.setInfouserid(user.getUser_id());
			info.setInfophone(Long.parseLong(infoPhone));
			info.setInfoemail(infoEmail);
			//info.setInfodate(new Date());
			info.setInfocontent(infoContent);
			info.setInfolinkman(infoLinkman);
			InfoDao infoDao= new InfoDao();

			if(infoDao.addInfo(info)>0){
				response.getWriter().println("<script>alert('发布成功！');window.location.href='user/usermain.jsp'</script>");
			}else {
				response.getWriter().println("<script>alert('发布失败！');history.go(-1)</script>");
			}
		}else {
			response.getWriter().println("<script>alert('您未登录，请登录再发布。');window.location.href='login.jsp'</script>");
		}
		
	}

}
