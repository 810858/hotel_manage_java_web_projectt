import java.util.ArrayList;
import java.util.ListIterator;

public class MyCart {
	ArrayList<Cart> al;
	Cart c1=new Cart();
	
	public MyCart()
	{
		al=new ArrayList<Cart>();
		
	}
	public ArrayList<Cart> getAl() {
		return al;
	}

	public void setAl(ArrayList<Cart> al) {
		this.al = al;
	}
	public void addToCart(String productName, int price,int qty){
	
				Cart c=new Cart();
				
				ListIterator itr=al.listIterator();
				while(itr.hasNext())
				{
					Cart cart=(Cart)itr.next();
					if(cart.getProductName().equals(productName))
					{
						itr.remove();
						qty+=cart.getQty();
						break;
					}
					
				}	
				c.setProductName(productName);
						c.setPrice(price);
						c.setQty(qty);
						al.add(c);
			
		
    }
	public void removeFromCart(String productName){
		//Cart c1=new Cart();
		ListIterator itr=al.listIterator();
		while(itr.hasNext())
		{
			Cart cart=(Cart)itr.next();
			if(cart.getProductName().equals(productName))
			{
				itr.remove();
			}
		}
	}
		
	public void updateToCart(String productName,int price,int qty)
	{
		Cart c=new Cart();
		
		ListIterator itr=al.listIterator();
		while(itr.hasNext())
		{
			Cart cart=(Cart)itr.next();
			if(cart.getProductName().equals(productName))
			{
			itr.remove();
				cart.qty=qty;
			
				break;
			}
			
		}	
		//c.setProductName(productName);
				
		c.setProductName(productName);
		c.setPrice(price);
		c.setQty(qty);
		al.add(c);
		
		
}
}
