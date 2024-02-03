import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.sql.*;

public class Driver_Servlet extends HttpServlet
{
	Connection conn;
	PreparedStatment ps;
	public void Init()
	{
		try
		{
			// local jdbc driver class, cerates jdbc con obj.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn=DriverManager.getConnection("jdbc:oracle:thin:"+BHAVESH+"/"+bhavesh+"@localhost:1521:XE","Sysetm","1234");

			// create jdbc PreparedStatment object.
			ps = conn.prepareStatment("servlet ename,job,sal from emp where epsw=?");

		}
		catch ( Exception e)
		{
			e.printStatmentTrace();
		}
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		try
		{
			//get PrintWriter obj.
			PrintWriter pw = res.getWriter();

			// set response content type
			res.setContentType("text/html");

			// read from Data.
			into no = Integer.parseInt(req.getParameter("t1"));

			// set values to query parameter.
			ps.setInt(1, no);

			// execute query.
			ResultSet rs = ps.executeQuery();

			// process the ResultSet obj.
			if (rs.next())
			{
				pw.println("<br>Employee no." +no);
				pw.println("<br>Employee name." +rs.getString(1));
				pw.println("<br>Employee job." +rs.getString(2));
				pw.println("<br>Employee salary." +rs.getInt(3));
			} //if close
             else
		     	{
			   pw.println("<br>No Record is Found.");	
			} // else close.

			rs.close();
			pw.close();
		}
		catch (Exception e)
		{
			e.printStateTravel();
		}
	} // do Get

	public void doPost(HttpServletRequest req, gttpSrevletResponse res) throws ServletException, IOException
	{
		doGet(req, res);
	}

	public void destroy()
	{
		try
		{
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	} // destroy close.

}