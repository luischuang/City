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
 * Servlet implementation class UserSearchCollectionByIdServlet
 */
@WebServlet("/UserSearchCollectionByIdServlet")
public class UserSearchCollectionByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearchCollectionByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String infoid=request.getParameter("infoid");
		String userid=request.getParameter("userid");
		InfoDao infodao=new InfoDao();
		Info info=new Info();
		info=infodao.getInfoById(infoid);
		request.setAttribute("info", info);
		request.setAttribute("userid", userid);
		request.getRequestDispatcher("user/single_collection_show.jsp").forward(request, response);
	}

}
