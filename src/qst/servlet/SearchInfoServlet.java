package qst.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qst.dao.InfoDao;
import qst.model.Info;

/**
 * 鏍规嵁鍏抽敭瀛椼�佷俊鎭被鍨嬪拰鏌ユ壘绫诲瀷鏌ユ壘淇℃伅鍒楄〃锛屽苟鍙戝竷鍒伴椤垫煡璇㈤〉闈�
 * Servlet implementation class SelectInfoByTypeServlet
 */
@WebServlet("/SearchInfoServlet")
public class SearchInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchInfoServlet() {
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
		request.setCharacterEncoding("UTF-8");
		String sqlvalue =request.getParameter("sqlvalue");
		String subsql =request.getParameter("subsql");
		String type=request.getParameter("type");

		InfoDao infoDao =new InfoDao();
		int currentPage=1;
		String newCurrentPage=request.getParameter("currentPage");
		if(newCurrentPage !=null&& !newCurrentPage.equals("")){
			currentPage=Integer.parseInt(newCurrentPage);
		}
		int total=infoDao.searchInfo(sqlvalue,subsql,type).size();
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
		System.out.println("start"+start);
		int end=5;
		
		List<Info> list =infoDao.searchInfo(sqlvalue, subsql, type,start,end);
		int num= list.size();
		System.out.println(num);
		request.setAttribute("list", list);
		request.setAttribute("sqlvalue", sqlvalue);
		request.setAttribute("subsql", subsql);
		request.setAttribute("type", type);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("total", total);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("view/searchshow.jsp").forward(request, response);
	}

}
