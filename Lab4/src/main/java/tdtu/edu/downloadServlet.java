package tdtu.edu;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/download"})
public class downloadServlet extends HttpServlet{
	
	 private static final long serialVersionUID = 1L;
	 
	    public void doGet(HttpServletRequest request,
	                      HttpServletResponse response)
	        throws ServletException, IOException
	    {
	 
	       response.setContentType("text/plain");
           response.setHeader("Content-disposition", "attachment; filename=test.txt");
	       InputStream in = request.getServletContext().getResourceAsStream("/WEB-INF/Files/test.txt");
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
	    	   
	       }
	       
	        in.close();
	    	out.close();
	     }
	    	
}
