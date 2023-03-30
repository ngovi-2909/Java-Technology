package tdtu.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = {"/upload"})
@MultipartConfig
public class uploadServlet extends HttpServlet{
	
	private static final String serverPath = "C:\\Users\\leeky\\eclipse-workspace\\Lab4\\src\\main\\webapp\\WEB-INF\\uploads";
	
	 private String getFileName(Part filePart) {
	    String header = filePart.getHeader("content-disposition");
	    String name = header.substring(header.indexOf("filename=\"")+10);
	    return name.substring(0, name.indexOf("\""));
	  }
	 private String getExtension(String filename)
	 {
		 String extension = "";
		 String name = filename.substring(filename.indexOf(".")+1);
		 return name;
	 }
	 private boolean checkExtension(String file)
	 {
		 String[] arr = {"txt", "docx", "doc", "img", "pdf", "rar", "zip"};
		 for(String i: arr)
		 {
			 if(i.equals(file))
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 
	 public Set<String> listFiles(String dir) throws IOException {
		    try (Stream<Path> stream = Files.list(Paths.get(dir))) {
		        return stream
		          .filter(file -> !Files.isDirectory(file))
		          .map(Path::getFileName)
		          .map(Path::toString)
		          .collect(Collectors.toSet());
		    }
		}
	 public boolean checkOverride(String filename) throws IOException
	 {
		 Set<String> arr = listFiles(serverPath);
		 for(String i: arr)
		 {
			 if(i.equals(filename))
			 {
				 return true;
			 }
		 }
		 return false;
	 }
	 public void writeFile(String filename, Part filePart) throws IOException // write file to the server directory
	 {
		 OutputStream out = null;
		 InputStream filecontent = null;
		 try
		 {
			 out = new FileOutputStream(new File(serverPath + File.separator + filename));
	  	      
		      filecontent = filePart.getInputStream();
		      int read = 0;
		      final byte[] bytes = new byte[1024];
		 
		      while ((read = filecontent.read(bytes)) != -1) 
		      {
		        out.write(bytes, 0, read);
		      }
		 }
	      catch(IOException e)
		 {
	    	  e.printStackTrace();
		 }finally
		 {
			 if (out != null) {
		        out.close();
		      }
		      if (filecontent != null) {
		        filecontent.close();
		      }
		 }
	 }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/upload.jsp").forward(req, resp);
				
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	    response.setContentType("text/html;charset=UTF-8");
	    
	    final Part filePart = request.getPart("document");
	    String name = request.getParameter("name"); // name of file user give
	    //System.out.println(name);
	    String file = getFileName(filePart); // get the original file name
	    
	    String override = request.getParameter("override");
	    //System.out.println(checkOverride(file));
	    
	    final PrintWriter writer = response.getWriter();
	    
	    try {
	    	if(checkExtension(getExtension(file)))  // check file extension
	    	{
	    		if(override == null)
	    		{
	    			if(!checkOverride(name))
	    			{
	    				writeFile(name, filePart);
	    				writer.println("File has been uploaded");
	    			}else
	    			{
	    				writer.println("File already exists");
	    			}
	    		}else
	    		{
	    			String pathDownloadFile = "downloadfile?filename="+name;
	    			writeFile(name, filePart);
	    			writer.println("<p>File Uploaded. Click");
	    			writer.println("<a href="+pathDownloadFile +">here</a>");
	    			writer.println("to visite file.</p>");
	    		}
	    	}else
	    	{
	    		writer.println("Unsupported file extension");
	    	}
	     
	    } catch (FileNotFoundException fne) {
	      writer.println("Missing file or no insufficient permissions.");
	      writer.println(" ERROR: " + fne.getMessage());
	    } finally {
	      if (writer != null) {
	        writer.close();
	      }
	    }
	    
	  }
	 
}