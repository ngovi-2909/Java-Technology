package tdtu.edu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/image2"})
public class image2Servlet extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	 
	    public void doGet(HttpServletRequest request,
	                      HttpServletResponse response)
	        throws ServletException, IOException
	    {
	 
	        // Get PrintWriter object
	        PrintWriter out = response.getWriter();
	        // File name
	        String imageName = "image2.jpg";
	        // File path
	        String imagePath = "C:\\Users\\leeky\\eclipse-workspace\\Lab4\\src\\main\\webapp\\WEB-INF\\Images\\" ;
	        
	        // Set the content type and header of the response.
	        response.setContentType("image/jpeg");
	        response.setHeader("Content-Disposition",
	                           "attachment; imageName=\""
	                               + imageName + "\"");
	 
	        // Get FileInputStream object to identify the path
	        FileInputStream inputStream
	            = new FileInputStream(imagePath + imageName);
	 
	        // Loop through the document and write into the
	        // output.
	        int in;
	        while ((in = inputStream.read()) != -1) {
	            out.write(in);
	        }
	 
	        // Close FileInputStream and PrintWriter object
	        inputStream.close();
	        out.close();
	    }

}
