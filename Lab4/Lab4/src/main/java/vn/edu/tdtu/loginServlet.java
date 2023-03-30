package vn.edu.tdtu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/welcome"})
public class loginServlet extends HttpServlet{
	
	private HashMap<String, String> userList;
	
	public void data() throws ServletException{
		userList = new HashMap<>();
		userList.put("52000430", "123");
		userList.put("admin", "admin123");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter=resp.getWriter();
		
		String name ="";
		
		Cookie[] cookies=req.getCookies();
		
		for (Cookie c : cookies) {
			if (c.getName().equals("username")) {
				name=c.getValue();
			}
		}
		if (name.equals("")) {
			resp.sendRedirect("/Lab4");
		}
		printWriter.println("<h1 align= 'center'> Welcome " +name + "</h1>");
		printWriter.println("Name and Password match");
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter printWriter=resp.getWriter();
		String username =req.getParameter("username");
		String password =req.getParameter("password");
		data();
		if (userList.get(username).equals(password) ) {
			Cookie cookie= new Cookie("username", username);
			cookie.setMaxAge(30);
			resp.addCookie(cookie);
			resp.sendRedirect("/Lab4/welcome");
		}else {
			resp.sendRedirect("/Lab4");
		}
		
	}
}
