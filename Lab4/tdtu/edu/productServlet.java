package tdtu.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.*;

@WebServlet(urlPatterns = {"/Product"})
public class productServlet extends HttpServlet{
	

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		ArrayList<Product> listProduct = new ArrayList<>();
		Product product = new Product(1, "Iphone", 50000);
		Product product1 = new Product(2, "Xiaomi", 100000);
		Product product2 = new Product(3, "Huawei", 30000);
		listProduct.add(product);
		listProduct.add(product1);
		listProduct.add(product2);
		String productJsonString = new Gson().toJson(listProduct);

		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		out.print(productJsonString);
		out.flush();   
	}
}
