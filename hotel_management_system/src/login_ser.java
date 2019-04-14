

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login_ser
 */
public class login_ser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_ser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String x=request.getParameter("username");
String h=request.getParameter("password");

try
{
Class.forName("oracle.jdbc.OracleDriver");
Connection conn;
conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","hr","hr");
System.out.println("successfully connected");
String str1="insert into login values(?,?)";
PreparedStatement st=conn.prepareStatement(str1);
st.setString(1, x);
st.setString(2, h);
st .executeUpdate();
System.out.println("data inserted");
conn.close();
}
catch(Exception e)
{
	System.out.println("not"+e);
}


	}

}
