package tdtu.edu.servlet;


import tdtu.edu.model.*;
import tdtu.edu.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/login"})
public class loginServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);;
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDao userDao = new UserDao();
		if(!userDao.checkUsername(username))
		{
			req.setAttribute("flash_message", "Username does not exist");
			req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
		}else if(!userDao.checkPassword(password))
		{
			req.setAttribute("flash_message", "Password incorrect");
			req.getRequestDispatcher("WEB-INF/jsp/login.jsp").forward(req, resp);
		}else
		{
			resp.sendRedirect("home");
		}
	}
}
