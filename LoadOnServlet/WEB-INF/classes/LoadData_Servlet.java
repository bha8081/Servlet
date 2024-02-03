import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoadData_Servlet extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		LoadData_Servlet d = new LoadData_Servlet();
		String s = d.toString();

		//refer response for each second.
		res.setHeader("refresh" , "1");
		pw.println("<h1>" + s + "</h1>");
		pw.close();
	}
	
}