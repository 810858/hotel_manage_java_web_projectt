

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register_servlet
 */
@WebServlet("/register_servlet")

public class register_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register_servlet() {
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
		PrintWriter out=response.getWriter();
		String x=request.getParameter("username");
		String m=request.getParameter("email");
		String g=request.getParameter("mobile");
		String h=request.getParameter("password");
        String y=request.getParameter("password");
		
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
		System.out.println("successfully connected");
		String str1="insert into login values(?,?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(str1);
		st.setString(1,x);
		st.setString(2, m);
		st.setString(3, g);
		st.setString(4, h);
		st.setString(5, y);
		
		st .executeUpdate();
		System.out.println("data inserted");
		response.sendRedirect("loginn.html");
		conn.close();
		}
		catch(Exception e)
		{
			System.out.println("not"+e);
		}
		
		
		
	}

}
