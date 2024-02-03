import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Context_Servlet extends HttpServlet
{
   public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();

		// creating Servlet object.
		ServletContext context = getServletContext();

		// Getting the value of initialization parameter.
		String driverName = context.getInitParameter("driver");
	    
		 pw.println("dirver name is = " +driverName);
		 pw.close();
	}
}