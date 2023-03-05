package tdtu.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/register"})
public class RegisterServlet extends HttpServlet{
	
	private String getValueArray(String[] arr)
	{
		String result = "";
		if(arr != null)
		{
			for(String i: arr)
			{
				result += i +"<br>";
			}
		}
		return result;
	}
	private boolean checkInfo(String name, String email, String birthday, String gender, String country)
	{
		if(name.equals("") || email.equals("") || birthday.equals("") || gender== null || country.equals("Select a country"))
			return false;
		return true;
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		final PrintWriter writer = response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		String[] ide = request.getParameterValues("favorite_ide[]");
		String toeic = request.getParameter("toeic");
		String message = request.getParameter("message");
		String ide_string = getValueArray(ide);
		if(!checkInfo(name, email, birthday, gender, country))
		{
			writer.println("Vui lòng nhập đầy đủ thông tin về tên, email, ngày sinh, giới tính, quốc gia");
		}else
		{
			writer.println("<table border = \"2\" style=\"width:50%\">");
			writer.println("<tr> <td style=\"text-align: center\"> Họ tên </td>  <td style=\"text-align: center\">" +name+ "</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\"> Email </td>  <td style=\"text-align: center\">" +email+ "</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\"> Ngày sinh </td>  <td style=\"text-align: center\">" +birthday+ "</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\"> Giới tính </td>  <td style=\"text-align: center\">" +gender+ "</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\"> Quốc gia </td>  <td style=\"text-align: center\">" +country+ "</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\" > IDE yêu thích <br>"
								+ "<font color=\"red\">Hãy đảm bảo rằng các IDE bạn chọn đã hiển thị đầy đủ</font> </td> "
								+ "<td style=\"text-align: center\">" +ide_string+ "</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\">Điểm TOEIC</td> <td style=\"text-align: center\"> "+ toeic+"</td> </tr>");
			writer.println("<tr> <td style=\"text-align: center\">Giới thiệu bản thân</td>  <td style=\"text-align: center\">"+ message +"</td> </tr>");
			writer.println("</table>");
		}
		
	}

}
