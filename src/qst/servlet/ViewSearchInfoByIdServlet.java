package qst.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qst.dao.InfoDao;
import qst.model.Info;
import qst.model.User;

/**
 * 查找用户信息并发送到前台
 * Servlet implementation class ViewSearchInfoByIdServlet
 */
@WebServlet("/ViewSearchInfoByIdServlet")
public class ViewSearchInfoByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewSearchInfoByIdServlet() {
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
		HttpSession session=request.getSession();
		int userid=0;
		String user=request.getParameter("userid");
		if(user!=null&&!"".equals(user)){
			userid=Integer.parseInt(user);
		}

		String infoid=request.getParameter("infoid");
		int isCollection=0;
		InfoDao infodao=new InfoDao();
		Info info=new Info();
		info=infodao.getInfoById(infoid);
		if(infodao.findInfoIsCollection(userid,Integer.parseInt(infoid))){
			isCollection=1;
		}
		request.setAttribute("isCollection", isCollection);
		request.setAttribute("userid", userid);
		request.setAttribute("info", info);
		request.getRequestDispatcher("view/singleshow.jsp").forward(request, response);
		
	}

}
