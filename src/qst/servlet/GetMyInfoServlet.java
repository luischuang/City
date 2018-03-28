package qst.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import qst.dao.InfoDao;
import qst.model.Info;

/**
 * Servlet implementation class GetMyInfo
 */
@WebServlet("/GetMyInfoServlet")
public class GetMyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMyInfoServlet() {
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
		
		HttpSession session=request.getSession();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String user_id =request.getParameter("user_id");

		InfoDao infoDao =new InfoDao();
		int currentPage=1;
		String newCurrentPage=request.getParameter("currentPage");
		if(newCurrentPage !=null&& !newCurrentPage.equals("")){
			currentPage=Integer.parseInt(newCurrentPage);
		}
		int total=infoDao.searchInfoByUserID(user_id).size();
		int totalPage=(total%5>0 ? total/5+1 : total/5);
		if(totalPage==0){
			totalPage=1;
		}
		if(currentPage>totalPage){
			currentPage=totalPage;
		}
		if (currentPage<1) {
			currentPage=1;
		}
		int start=(currentPage-1)*5;
		int end=5;
		
		List<Info> list =infoDao.searchInfoByUserID(user_id,start,end);
		int num= list.size();
		System.out.println(num);
		request.setAttribute("list", list);
		request.setAttribute("user_id", user_id);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("total", total);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("user/show_my_info.jsp").forward(request, response);
	}

}
