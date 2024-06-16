

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;

@WebServlet("/Connector")
public class Connector extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connector() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw = response.getWriter();
		String un=request.getParameter("logemail");
		String pn=request.getParameter("logpass");
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/thefoodiespot","root", "root");
		PreparedStatement ps = c.prepareStatement("select * from login where logemail=? and logpass=?");
		ps.setString(1, un);
		ps.setString(2, pn);
		ResultSet rs = ps.executeQuery();
		while (rs.next())
		{
		pw.println("You can Access our Menu Card and Order Your Favourite Dishes!!!");
		return;
		}
		pw.println("invalid user");
		return;
		}
		catch (Exception e )
		{
		e.printStackTrace();
		}
		

	}

}
