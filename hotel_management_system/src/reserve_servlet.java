

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
 * Servlet implementation class reserve_servlet
 */
@WebServlet("/reserve_servlet")
public class reserve_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reserve_servlet() {
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
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String x=request.getParameter("name");
		String m=request.getParameter("phone");
		String g=request.getParameter("date");
		String h=request.getParameter("email");
        String y=request.getParameter("number");
        String z=request.getParameter("time");
        try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
		System.out.println("successfully connected");
		String str1="insert into reserve values(?,?,?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(str1);
		st.setString(1,x);
		st.setString(2, m);
		st.setString(3, g);
		st.setString(4, h);
		st.setString(5, y);
		st.setString(6, z);
		
	
		
		st .executeUpdate();
		System.out.println("data inserted");
		
		conn.close();
		}
		catch(Exception q)
		{
			q.printStackTrace();;
		}
		
		
        
	}

}
