package tdtu.edu;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/downloadfile"})
@MultipartConfig
public class downloadFileServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//req.getRequestDispatcher("/WEB-INF/jsp/download.jsp").forward(req, resp);
		String filePart = request.getParameter("filename");
		System.out.println(filePart);
		response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename="+filePart);
	       InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/uploads/"+filePart);
	       OutputStream out = null;
	       if(in != null)
	       {
	    	    out = response.getOutputStream();
		        byte[] buffer = new byte[1048];
		    
		        int numBytesRead;
		        while ((numBytesRead = in.read(buffer)) > 0) {
		            out.write(buffer, 0, numBytesRead);
		        }
	       }else
	       {
	    	   System.out.println("Error");
	       }
	        in.close();
	    	out.close();
	     
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
