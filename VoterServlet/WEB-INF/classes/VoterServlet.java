import java.io.*;
import javax.servlet.*;

public class VoterServlet extends GenericServlet
{
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		PrintWriter pw = resp.getWriter();
		String str = req.getParameter("Age");
		int age = Integer.parseInt(str);
		if(age==18)
		{
			pw.println("<h1> you are eligible to vote </h1>");
		}
		else
		{
			pw.println("<h1> you are not eligible to vote </h1>");
		}

		pw.close();
	}
}