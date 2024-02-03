// Get Detail of all Initialization parameter.

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet1 extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws SrevletException, IOException;
	{
	    res.setContentType("text/html");
		PrintWriter pe = res.getWriter();

		ServletConfig config = getServletConfig();
		Enumeration<String> e = config.getInitParameterNames();

		String str = " ";

		while (e.hasMoreElements())
		{
			str = String (e.nextElement()); // (String) e.nextElement();
			pw.print("<br>Name: " +str);
			pw.print("value: " +config.getInitParameter(str));
		}

		pw.close();
	}
}