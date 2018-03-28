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
 * 设置信息为付费
 * Servlet implementation class SetInfoPayServlet
 */
@WebServlet("/SetInfoPayServlet")
public class SetInfoPayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetInfoPayServlet() {
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
		String infoidStr=request.getParameter("infoid");
		int infoid=0;
		infoid=Integer.parseInt(infoidStr);
		InfoDao infoDao=new InfoDao();
		Info info=new Info();
		info.setInfoid(infoid);
		if(infoDao.getModifyByiId2(info)){
			info=infoDao.getInfoById(infoidStr);
			request.setAttribute("info", info);
			request.getRequestDispatcher("admin/infoCheck.jsp").forward(request, response);
		}

	}

}
