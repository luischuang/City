package qst.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qst.dao.InfoDao;

/**
 * Servlet implementation class AddInfoToCollectionServlet
 */
@WebServlet("/AddInfoToCollectionServlet")
public class AddInfoToCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddInfoToCollectionServlet() {
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
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		int infoid=Integer.parseInt(request.getParameter("infoid").toString());
		int userid=Integer.parseInt(request.getParameter("userid").toString());
		if(userid!=0){
			InfoDao infodao=new InfoDao();
			if(infodao.addInfoToCollection(userid,infoid)){
				request.getRequestDispatcher("ViewSearchInfoByIdServlet?infoid="+infoid+"&userid="+userid).forward(request, response);
			}
		}else{
			response.getWriter().println("<script>alert('ÇëµÇÂ¼£¡');history.go(-1)</script>");
		}
		
	}

}
