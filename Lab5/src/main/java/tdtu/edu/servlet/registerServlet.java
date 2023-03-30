package tdtu.edu.servlet;

import tdtu.edu.model.*;
import tdtu.edu.dao.UserDao;
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

@WebServlet(urlPatterns = {"/register"})
public class registerServlet extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(req, resp);
		
				
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username =req.getParameter("name");
		String email =req.getParameter("email");
		String password =req.getParameter("password");
		String password_confirm = req.getParameter("password_confirm");
		UserDao userDao = new UserDao();
		if(userDao.checkUsername(username))
		{
			req.setAttribute("flash_message", "Username has already exist");
			req.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(req, resp);
		}else if(userDao.checkEmail(email))
		{
			req.setAttribute("flash_message", "Email has already exist");
			req.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(req, resp);
		}else if(!password.equals(password_confirm))
		{
			req.setAttribute("flash_message", "Password does not match");
			req.getRequestDispatcher("WEB-INF/jsp/register.jsp").forward(req, resp);
		}else
		{
			User user = new User(username, email, password);
			userDao.add(user);
			resp.sendRedirect("login");
		}
		
	}

}

