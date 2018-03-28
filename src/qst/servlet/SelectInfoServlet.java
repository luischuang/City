package qst.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qst.dao.InfoDao;
import qst.model.Info;

/**
 * 根据ID查找信息并发送到前台详细信息页面
 * Servlet implementation class selectInfoServlet
 */
@WebServlet("/SelectInfoServlet")
public class SelectInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectInfoServlet() {
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
		int infotypeid=Integer.parseInt(request.getParameter("infotypeid"));
		InfoDao infoDao=new InfoDao();
		Info freeInfo=infoDao.selectFreeInfo(infotypeid);
		Info payInfo=infoDao.selectPayInfo(infotypeid);
		request.setAttribute("freeInfo", freeInfo);
		request.setAttribute("payInfo", payInfo);

		//response.sendRedirect("view/listshow.jsp");
		request.getRequestDispatcher("view/listshow.jsp").forward(request, response);
	}

}
