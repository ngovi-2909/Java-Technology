package tdtu.edu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import tdtu.edu.dao.ProductDao;
import tdtu.edu.model.Product;

@WebServlet(urlPatterns= {"/home"})
public class homeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("option");
		System.out.println(action);
		switch(action)
		{
			case "list":
				try {
					listProduct(req,resp);
				} catch (SQLException | IOException | ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "insert":
				insertProduct(req, resp);
				break;
			case "delete":
				deleteProduct(req, resp);
				break;
		}
		
		
	}
	private void listProduct(HttpServletRequest request, HttpServletResponse response)
    	    throws SQLException, IOException, ServletException {
				ProductDao productDao = new ProductDao();
    	        List<Product> listProduct;
				try {
					listProduct = productDao.getAll();
					request.setAttribute("listProduct", listProduct);
					request.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        
    	    }
	private void insertProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String name = req.getParameter("name");
		String price = req.getParameter("price");
		ProductDao productDao = new ProductDao();
		if(name.equals(""))
		{
			req.setAttribute("message", "Vui lòng nhập tên sản phảm");
			req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
		}else if(price.equals(""))
		{
			req.setAttribute("message", "Vui lòng nhập giá sản phẩm");
			req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
		}else
		{
			Product product = new Product(name, Double.parseDouble(price));
			productDao.add(product);
			try {
				listProduct(req, resp);
			} catch (SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void deleteProduct(HttpServletRequest req, HttpServletResponse resp)
	{
		String idString = req.getParameter("id");
		ProductDao productDao = new ProductDao();
		System.out.println(idString);
		try
		{
			Integer id = Integer.parseInt(idString);
			productDao.removeById(id);
			listProduct(req, resp);
			req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req, resp);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
