package qst.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qst.dao.InfoDao;
import qst.model.Info;

/**
 * 根据付费状态和审核状态及信息类型查找信息
 * Servlet implementation class InfoListServlet
 */
@WebServlet("/InfoListServlet")
public class InfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfoListServlet() {
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
		String infopaystate=request.getParameter("payforType");
		String infocheckstate=request.getParameter("stateType");
		String infotypeid=request.getParameter("infoType");
//		System.out.println("infopaystate:"+infopaystate);
//		System.out.println("infocheckstate:"+infocheckstate);
//		System.out.println("infotypeid:"+infotypeid);
		InfoDao infoDao=new InfoDao();
		
		int currentPage=1;
		String newCurrentPage=request.getParameter("currentPage");
		if(newCurrentPage !=null&& !newCurrentPage.equals("")){
			currentPage=Integer.parseInt(newCurrentPage);
		}
		int total=infoDao.infoList(infopaystate,infocheckstate,infotypeid).size();
		//System.out.println("总数"+total);
		int totalPage=(total%5>0 ? total/5+1 : total/5);
		if(currentPage>totalPage){
			currentPage=totalPage;
		}
		if (currentPage<1) {
			currentPage=1;
		}
		int start=(currentPage-1)*5;
		//System.out.println("start"+start);
		int end=5;
		List<Info> list =infoDao.infoListByPage(infopaystate, infocheckstate, infotypeid,start,end);
		int num= list.size();
		//System.out.println(num);
		request.setAttribute("list", list);
		request.setAttribute("infopaystate", infopaystate);
		request.setAttribute("infocheckstate", infocheckstate);
		request.setAttribute("infotypeid", infotypeid);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("total", total);
		request.setAttribute("totalPage", totalPage);
		request.getRequestDispatcher("admin/infoList.jsp").forward(request, response);
	}

}
