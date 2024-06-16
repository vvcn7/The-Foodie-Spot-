import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.io.*;
/**
* Servlet implementation class GetConnector
*/
@WebServlet("/GetConnector")
public class GetConnector extends HttpServlet {
private static final long serialVersionUID = 1L;

 /**
 * @see HttpServlet#HttpServlet()
 */
 public GetConnector() {
 super();
 // TODO Auto-generated constructor stub
 }
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at: ").append(request.getContextPath());
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
// TODO Auto-generated method stub
PrintWriter pw = response.getWriter();
String em=request.getParameter("logemail");
String pn=request.getParameter("logpass");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/thefoodiespot","root", "root");
PreparedStatement ps = c.prepareStatement("insert into login values(?,?)");
ps.setString(1, em);
ps.setString(2, pn);
ps.executeUpdate();
pw.println("Hurrah!! You are the member of our 'THEFODDIESPOT' ");
}
catch (Exception e )
{
e.printStackTrace();
}
}
}