package haier.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.penghai.haier.model.Order;
import com.penghai.haier.model.Product;
import com.penghai.haier.test.HaierTest;

/**
 * Servlet implementation class StartSchedulingServlet
 */
@WebServlet("/StartSchedulingServlet")
public class StartSchedulingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static int[] months={31,28,31,30,31,30,31,31,30,31,30,31};
	public ArrayList<Order> orders=new ArrayList<Order>();
	public ArrayList<Product> products=new ArrayList<Product>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StartSchedulingServlet() {
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
		products=h.getResults("F:\\中二 POC数据0910V3.xlsx");
		//orders = h.getOrders();
		request.setAttribute("products", products);
		
		request.getRequestDispatcher("HaiEr/outputResult.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
