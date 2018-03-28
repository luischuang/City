package haier.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.penghai.haier.model.Order;
import com.penghai.haier.model.Product;
import com.penghai.haier.test.HaierTest;

/**
 * Servlet implementation class UploadHandleServlet
 */
@WebServlet("/UploadHandleServlet")
public class UploadHandleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
	public ArrayList<Order> orders=new ArrayList<Order>();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadHandleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HaierTest h=new HaierTest();
		h.InitData("F:\\嶄屈 POC方象0910V3.xlsx");
		orders = h.getOrders();
		HttpSession session = request.getSession();
		session.setAttribute("orders",orders);
		//request.setAttribute("orders", orders);
		response.sendRedirect("HaiEr/inputData.jsp");
		//request.getRequestDispatcher("HaiEr/inputData.jsp").forward(request, response);
		//response.getWriter().append(orders.get(0).getProductID()).append("。。。。。。。。Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
