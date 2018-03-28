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
 * 根据ID查找信息并发布到后台审核页面
 * Servlet implementation class SingleShowServlet
 */
@WebServlet("/SearchInfoByIdServlet")
public class SearchInfoByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchInfoByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String infoid=request.getParameter("infoid");
		InfoDao infodao=new InfoDao();
		Info info=new Info();
		info=infodao.getInfoById(infoid);
		request.setAttribute("info", info);
		request.getRequestDispatcher("admin/infoCheck.jsp").forward(request, response);
	}

}
