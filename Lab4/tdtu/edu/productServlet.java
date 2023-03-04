package tdtu.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.*;

@WebServlet(urlPatterns = {"/Product"})
public class productServlet extends HttpServlet{
	
	private ArrayList<Product> listProduct = new ArrayList<>();
	public void checkExist()
	{
		int temp;
		for(int i=1; i<listProduct.size();i++)
		{
			temp = i - 1;
			if(listProduct.get(i).getId() == listProduct.get(temp).getId())
			{
				listProduct.remove(temp);
			}
		}
	}
	public void init()
	{
		Product product = new Product(1, "Iphone", 50000);
		Product product1 = new Product(2, "Xiaomi", 100000);
		Product product2 = new Product(3, "Huawei", 30000);
		listProduct.add(product);
		listProduct.add(product1);
		listProduct.add(product2);
		checkExist();
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException {
		StringBuffer requestURL = request.getRequestURL();
		init();
		String para = request.getParameter("id");
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		if(para != null)
		{
			int index;
			try
			{
				index = Integer.parseInt(para);
				if(index < listProduct.size())
				{
					JSONObject jsonObject = new JSONObject();
					JSONArray jsonArray = new JSONArray();
					Product product = listProduct.get(index-1);
					jsonObject.put("code", 0);
					jsonObject.put("message", "Doc san pham thanh cong");
					
					Map m1 = new LinkedHashMap(3);
					m1.put("id", product.getId());
					m1.put("name", product.getName());
					m1.put("price", product.getPrice());
					jsonArray.put(m1);
					
					jsonObject.put("data", jsonArray);
					out.print(jsonObject);
					
				}else
				{
					JSONObject jsonObject = new JSONObject();
					String message = "Khong tim thay san pham voi ma so " + index;
					jsonObject.put("code", 2);
					jsonObject.put("message", message);
					out.print(jsonObject);
				}
			}catch(NumberFormatException e)
			{
				e.printStackTrace();
			}
		}else
		{
			JSONObject jsonObject = new JSONObject();
			JSONArray jsonArray = new JSONArray();
			Map m1 = new LinkedHashMap(3);
			
			jsonObject.put("code", 0);
			jsonObject.put("message", "Doc san pham thanh cong");
			for(Product i: listProduct)
			{
				m1.put("id", i.getId());
				m1.put("name", i.getName());
				m1.put("price", i.getPrice());
				jsonArray.put(m1);
			}
			jsonObject.put("data", jsonArray);
			out.print(jsonObject);
		}
		out.flush();
		out.close();
	}
}
