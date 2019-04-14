
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login_servlet
 */
@WebServlet("/login_servlet")
public class login_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String x=request.getParameter("username");
		String h=request.getParameter("password");
		out.println(x);
		out.println(h);
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			Connection conn;
			conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
			System.out.println("successfully connected");
			PreparedStatement st=conn.prepareStatement("select * from login where username=? and password=?" );
			st.setString(1,x);
			st.setString(2,h);
			ResultSet rs=st.executeQuery();
		if(rs.next())
			{
				response.sendRedirect("nav.html");
			}
			else
			{
				

				RequestDispatcher rd=request.getRequestDispatcher("register.html");
				rd.include(request, response);
			out.print("<html><body>You are Not Register User Please Register Here!!</body></html>");	
			}
		
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}
	}

}
