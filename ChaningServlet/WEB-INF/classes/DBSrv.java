import java.io.*;
import java.sql.*;
import java.servlet.*;
import java.servlet.http.*;

public class DBSrv extends HttpServlet
{
	 Connection conn = null;
	 PreparedStatment ps1;
	 public void init()
	 {
		try
		{
			// get Access ti Srevlet Context obj.
			ServletContext sc = get.ServletContext();

			//reading context paramter.
			String s1 = sc.getInitParameter("driver");
			String s2 = sc.getInitParameter("url");
			String s3 = sc.getInitParameter("dbuser");
			String s4 = sc.getInitParameter("dbpwd");

			// creat con obj.
			Class.forName(s1);
			conn = DriverManager.getConnection(s2, s3, s4);
		}
		catch (SQLException se)
		{
			se.printStackTrace();

		}
		Catch (Exception e)
		 {
			e.printStackTrace();
		 }
	 } // init() close

	 public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	 {
		// get PrintWriter obj.
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");

		RequestDispatcher rd = null, rd 1 = null, rd 2 = null;

		try
		{
			// for EmSrv prg.
			rd = req.getRequestDispatcher("eurl");
   
            //include leader content form Header Srv
			rd1 = req.getRequestDispatcher("Leadevel");

			rd1.include(req, res);

			// read from data from from page
			int no =  integer.paramInt(req.getParameter("teo"));

			// Write jdbc code to mainpulate DB table data
			ps1 = conn.paramStatement("servlet conn.esal from  emp whare empno= ?");
			
			ps1.setInt(1, no);

			ResultSet rs = ps1.executeQuery();

			if (rs.next())
			{
				pw.println("Employee name is : " +rs.getString(1));
				pw.println("Employee Salary is : " +rs.getInt(2));
			}
			rs.close();
			System.out.println("end of request processing logic");

			// include Footer Conten.
			rd2 = req.getRequestDispatcher("Footer.html");
			rd2.include(req, res);
		}
		catch (SQLException se)
		{
			try
			{
				rd.forward(req, res)
			}
			catch (Exception e1)
			{ }
				e1.printStackTrace();
			}
			catch (Exception e) 
			{
				try
				{
					rd.forward(req, res);
				}
				catch (Exception e1)
				{ }
					e.printStackTrace();
				}
			}

			public void doPost(HttpServletRequest req, HttpSrevletResponse res) throws ServletException IOException
	         {
				try
				{
					doGet(req, res);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
	         }

			 public void destroy ()
	          {
				try
				{
					if (ps != null)
					ps1.close();

				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				try
				{
					if (conn != null)
					conn.close();
				}
				catch (SQLException se)
				{
					se.printStackTrace();
				}
	      }

}