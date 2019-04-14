

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
 * Servlet implementation class bookservlet
 */
@WebServlet("/bookservlet")
public class bookservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookservlet() {
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
		
		String x=request.getParameter("namee");
		String m=request.getParameter("lastt");
		String g=request.getParameter("addd");
		String h=request.getParameter("adhar");
        String y=request.getParameter("phone");
        String z=request.getParameter("selct");
        String a=request.getParameter("acco");
        String e=request.getParameter("room");
        String b=request.getParameter("additinal");
        String c=request.getParameter("bday");
        String d=request.getParameter("bdayy");
        String f=request.getParameter("payment");
        String w=request.getParameter("idd");
		String q=request.getParameter("bed");
		String l=request.getParameter("tarri");
       
		
		
		try
		{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection conn;
		conn=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1522/orcl","sys as sysdba","sys");
		System.out.println("successfully connected");
		String str1="insert into booook values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement st=conn.prepareStatement(str1);
		st.setString(1,x);
		st.setString(2, m);
		st.setString(3, g);
		st.setString(4, h);
		st.setString(5, y);
		st.setString(6, z);
		st.setString(7, a);
		st.setString(8, e);
		st.setString(9, b);
		st.setString(10, c);
		st.setString(11, d);
		st.setString(12, f);
		st.setString(13, w);
		st.setString(14, q);
		st.setString(15, l);
	
		
		st .executeUpdate();
		System.out.println("data inserted");
		
		conn.close();
		}
		catch(Exception v)
		{
			System.out.println("not"+v);
		}
		
		
		
	}

	}


