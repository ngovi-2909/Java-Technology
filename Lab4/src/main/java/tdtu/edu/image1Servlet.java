package tdtu.edu;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/image1"})
public class image1Servlet extends HttpServlet{
	@Override
	public void init() throws ServletException{
		System.out.println("Starting Servlet");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.getRequestDispatcher("/WEB-INF/Images/image1.jpg").forward(req, resp);
		String file = "C:\\Users\\leeky\\eclipse-workspace\\Lab4\\src\\main\\webapp\\WEB-INF\\Images\\image1.jpg";
		 // set the content type to image/jpeg.
        resp.setContentType("image/jpeg");  
          
        ServletOutputStream out;
          
        // Writing this image 
        // content as a response 
        out = resp.getOutputStream(); 
          
        // path of the image
        FileInputStream fin = new FileInputStream(file);  
  
        // getting image in BufferedInputStream  
        BufferedInputStream bin = new BufferedInputStream(fin);
        BufferedOutputStream bout = new BufferedOutputStream(out);  
          
        int ch =0;  
        while((ch=bin.read())!=-1)  
        {  
            // display image
            bout.write(ch);  
        }  
          
        // close all classes
        bin.close();  
        fin.close();  
        bout.close();  
        out.close();  
    }  
				
}
