

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addToCart
 */
@WebServlet("/addToCart")
public class addToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addToCart() {
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
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
        
          
       
       
       HttpSession session = request.getSession();
       MyCart c;
       c = (MyCart) session.getAttribute("cart");
       if(c == null){
         c = new MyCart();
         session.setAttribute("cart", c);
       }
       
       
		
       String productName=request.getParameter("name");
       System.out.println(productName);
       int price=Integer.parseInt(request.getParameter("price"));
       int qty=Integer.parseInt(request.getParameter("qty"));
       System.out.println(price);
       System.out.println(qty);
     
       
    	  
    	  
    	   
    	   
       
       
    	   
       c.addToCart(productName,price,qty);
       System.out.println(productName);
       System.out.println(price);
       System.out.println(qty);
       
       
     
	
       out.println("<!DOCTYPE html>");
       out.println("<html>");
       out.println("<head>");
       out.println("<title>result</title>");
       out.println("</head>");
       out.println("<body bgcolor=tomato>");
       HttpSession session1=request.getSession(false);
		String fname=(String)session1.getAttribute("User");
	 out.println("Welcome  !!!!!!Enjoy Shopping with Us!!!"+"<form action='logout'><input type='submit' value='Logout'></form>");
	
       out.println("<h1>Item successfully added to cart </h1>");
       out.println("<form action='br.html'>Add more item<input type='submit' value='go'></form>");
       out.println("<hr>");
       out.println("<h2>Cart</h2>");
       ArrayList<Cart> items1=c.getAl();
       out.println("<table border='1px'>");
       out.println("<tr><td>Product Name</td><td>Price</td><td>Quantity</td><td>Subtotal</td><td></td><td></td></tr>");
        System.out.println(items1);
        float total=0.0f;
        float subtotal=0.0f;
       for(Cart c1: items1)
       {
    	   subtotal+=(c1.qty*c1.price);
     out.println("<form action='updateCart'><tr><td>"+c1.productName+"</td><td>"+"Rs"+c1.price+"</td><td contenteditable='true' ><input type='text' name='qty' value='"+c1.qty+"'></input><td>"+(c1.qty*c1.price)+"</td>"+"");
     
      	 
     	 
     	  
       }
     
       System.out.println(subtotal);
       out.println("<form><tr><td>Total:</td><td><td></td><td>"+subtotal+"</td></tr></form>");
       out.println("</table><br/><br/><br/><center>");
       out.println("<form action='transaction.html' target='myframe1'><input type='submit' value='Proceed to Payment'></form></center>");
       out.println("</body>");
       out.println("</html>");
       }

	
}

