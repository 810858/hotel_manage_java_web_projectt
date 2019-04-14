

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
 * Servlet implementation class BOOKSER
 */
@WebServlet("/BOOKSER")
public class BOOKSER extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BOOKSER() {
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
     String w=request.getParameter("idd");
    String q=request.getParameter("ty");
  String l=request.getParameter("tarri");
   String v=request.getParameter("qty");
		String x=request.getParameter("namee");
		String m=request.getParameter("lastt");
		String g=request.getParameter("addd");
		String y=request.getParameter("phone");
        String z=request.getParameter("selct");
        String a=request.getParameter("acco");
        String c=request.getParameter("bday");
        String d=request.getParameter("bdayy");
        String f=request.getParameter("payment");
        
		
		
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
		System.out.println("successfully connected");
		String str1="insert into buk values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(str1);
		st.setString(1,w);
		st.setString(2, q);
		st.setString(3, l);
		st.setString(4, v);
		st.setString(5, x);
		st.setString(6, m);
		st.setString(7, g);
		
		st.setString(8, y);
		
		st.setString(9, z);
		st.setString(10, a);
		st.setString(11, c);
		st.setString(12, d);
		st.setString(13, f);
	
		
		st .executeUpdate();
		System.out.println("data inserted");
		out.println("<html><style>body{\r\n" + 
				"background-image:url(sa.jpg);\r\n" + 
				"height:100vh;\r\n" + 
				"	background-size:cover;\r\n" + 
				"	background-position:center;\r\n" + 
				"	background-size:cover;\r\n" + 
				"	\r\n" + 
				"COLOR:Blue;\r\n" + 
				"FONT SIZE:50PX;}</style><body><h1><font color=red>Your Room Details</h1></font></body></html>");
		out.println("<html><body><h1>Your Room Id:"+w+"</br>"+"Room type:"+q+"</br>"+"Room Tarrif:"+l+"</br>Thank You for Booking room at Avenue</h1></body></html>");
		
		
		conn.close();
		}
		catch(Exception k)
		{
			System.out.println("not"+k);
		}
		
		
		
	}

}
