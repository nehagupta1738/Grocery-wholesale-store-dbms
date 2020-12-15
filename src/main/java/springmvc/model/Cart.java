package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int cartid;
	public String email;
	public int productid;
	public String productname;
	public int prise;
	public int quantity;
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrise() {
		return prise;
	}
	public void setPrise(int prise) {
		this.prise = prise;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cart(int cartid, String email, int productid, String productname, int prise, int quantity) {
		super();
		this.cartid = cartid;
		this.email = email;
		this.productid = productid;
		this.productname = productname;
		this.prise = prise;
		this.quantity = quantity;
	}
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Cart [cartid=" + cartid + ", email=" + email + ", productid=" + productid + ", productname="
				+ productname + ", prise=" + prise + ", quantity=" + quantity + "]";
	}
	
		
}
