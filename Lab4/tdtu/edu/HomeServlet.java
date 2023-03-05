package tdtu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns= {"/home"})
public class HomeServlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		response.setContentType("text/html");
		PrintWriter printWriter=response.getWriter();
		printWriter.println("<h1> Welcome to our homepage </h1>");
		redirect(request, response);
	}
	
	public void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		String param = request.getParameter("page");
		switch(param)
		{
			case "contact":
				request.getRequestDispatcher("/WEB-INF/jsp/contact.jsp").forward(request, response);
				break;
			case "help":
				request.getRequestDispatcher("/WEB-INF/jsp/help.jsp").forward(request, response);
				break;
			case "about":
				request.getRequestDispatcher("/WEB-INF/jsp/about.jsp").forward(request, response);
				break;
			default:
				response.sendRedirect("/home");
		}
	}

}
