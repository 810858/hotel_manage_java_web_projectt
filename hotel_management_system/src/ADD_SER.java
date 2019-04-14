

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ADD_SER
 */
@WebServlet("/ADD_SER")
public class ADD_SER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADD_SER() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	     String w=request.getParameter("IDD");
	    String q=request.getParameter("ROOM");
	  String l=request.getParameter("TARRI");
	   String v=request.getParameter("QTY");
	   try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
		System.out.println("successfully connected");
		String str1="insert into adding values(?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(str1);
		st.setString(1,w);
		st.setString(2, q);
		st.setString(3, l);
		st.setString(4, v);
		
		
		st .executeUpdate();
		System.out.println("data inserted");
		response.sendRedirect("addd.jsp");

		conn.close();
		}
		catch(Exception k)
		{
			System.out.println("not"+k);
		}
		
		
	}

}
