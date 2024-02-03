import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletConfigDemo extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter pe = res.getWriter();

		ServletConfig config = getServletConfig();
		String driver = config.getInitParameter("driver");
		pe.println("Driver is " +driver);
		pe.close();
	}
}