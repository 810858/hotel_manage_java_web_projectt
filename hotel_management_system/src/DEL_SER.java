

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
 * Servlet implementation class DEL_SER
 */
@WebServlet("/DEL_SER")
public class DEL_SER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DEL_SER() {
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
	     String ROOM_ID=request.getParameter("idd");
	    String ROOM_TYPE=request.getParameter("ty");
	  String TARRIF_PER_ROOM=request.getParameter("tarri");
	   String QUANTITY_OF_ROOMS=request.getParameter("qty");
	   try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
		System.out.println("successfully connected");
		String str1="delete from adding where ROOM_ID=?";
		PreparedStatement st=conn.prepareStatement(str1);
		st.setString(1,ROOM_ID);
		
		st .executeUpdate();
		System.out.println("data deleted");
		response.sendRedirect("delete.jsp");

		conn.close();
		}
		catch(Exception k)
		{
			k.printStackTrace();
		}
		
		
	}

}
