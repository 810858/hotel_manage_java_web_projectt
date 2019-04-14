
public class Cart {
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	String productName;
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Cart [productName=" + productName + ", qty=" + qty + ", price="
				+ price + "]";
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	int qty;
	int price;

}
