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
import qst.model.User;

/**
 * 鑾峰彇鏈�鏂扮殑鍏嶈垂鍜屼粯璐逛俊鎭苟鍙戝竷鍒伴椤�
 * Servlet implementation class GoindexServlet
 */
@WebServlet("/GoindexServlet")
public class GoindexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoindexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
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
		User user=(User)request.getAttribute("user");
		
		List<Info> freeInfoList=new ArrayList<Info>();
		List<Info> payInfoList=new ArrayList<Info>();
		InfoDao infoDao=new InfoDao();
		
		freeInfoList=infoDao.getFreeInfoList();
		payInfoList=infoDao.getPayInfoList();

		int i=1;
		List<Info> freeInfoList1=new ArrayList<Info>();
		List<Info> freeInfoList2=new ArrayList<Info>();
		for(Info info:freeInfoList){
			if(i<=4){
				if(i%2==1){
					freeInfoList1.add(info);
				}else {
					freeInfoList2.add(info);
				}
				i++;
			}else {
				break;
			}
		}
		i=1;
		List<Info> payInfoList1=new ArrayList<Info>();
		List<Info> payInfoList2=new ArrayList<Info>();
		for(Info info:payInfoList){
			if(i<=8){
				if(i%2==1){
					payInfoList1.add(info);
				}else {
					payInfoList2.add(info);
				}
				i++;
			}else {
				break;
			}
		}
		request.setAttribute("user", user);
		request.setAttribute("freeInfoList1", freeInfoList1);
		request.setAttribute("freeInfoList2", freeInfoList2);
		request.setAttribute("payInfoList1", payInfoList1);
		request.setAttribute("payInfoList2", payInfoList2);
		request.getRequestDispatcher("view/temp.jsp").forward(request, response);
		//response.sendRedirect("view/temp.jsp");
	}

}
