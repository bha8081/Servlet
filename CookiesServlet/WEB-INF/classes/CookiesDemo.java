import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.ServletException;
import javax.servlet.http.Cookie;
import javax.httpServlet;
import javax.http.HttpServlet;
import javax.http.HttpServletRequest;
import javax.http.HttpServletResponse;

public class CookiesDemo extends HttpServlet
{
  protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text\html");
		try(PrintWriter pw = res.getWriter())
		{
			out.println("<!DOCTYE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>My Cookies</title>");
			out.println("</head>");
			out.println("<body>");

			//getting all the cookies.
			Cookie[] cookies = req.getCookies();

			boolean f = false;
			String name = "";

			if (cookies==null)
			{
				out.println("<h1> You are new user go to home page and submit your name ");
				return;
			}else
			{
				for (Cookie c:cookies)
				{
                String tname = c.getName();
				if(tname.equals("user_name"))
					{
						f = true;

						name = c.getValue();
					}
				}
			}

            if(f) {
		//	String name = request.getParameter("name");
			out.println("<h2> Hello , " + name + "welcome to my website...</h2>");
            
			out.println("<h1>Thankyou</h1>");
			}else
			{
				out.println("<h1> You are new user go to home page and submit your name ");
			}
		//	out.println("<h1><a href='servlet2'> Go to servlet 2</a></h1>");
            
			//create the cookies.
			Cookie c = new Cookie("user_name", name);
			res.addCookie(c);


			out.println("</body>");
			out.println("</html>");
		}
//		catch ()
//		{
//		}
	}
}