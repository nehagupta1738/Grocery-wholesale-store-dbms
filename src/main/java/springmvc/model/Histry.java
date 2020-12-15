package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.mysql.fabric.xmlrpc.base.Data;

public class Histry {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int cartid;
	public String email;
	public int productid;
	public int quantity;
	public String productname;
	public int prise;
	public Data date;
	public int histryid;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
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
	public Data getDate() {
		return date;
	}
	public void setDate(Data date) {
		this.date = date;
	}
	public int getHistryid() {
		return histryid;
	}
	public void setHistryid(int histryid) {
		this.histryid = histryid;
	}
	public Histry(int cartid, String email, int productid, int quantity, String productname, int prise, Data date,
			int histryid) {
		super();
		this.cartid = cartid;
		this.email = email;
		this.productid = productid;
		this.quantity = quantity;
		this.productname = productname;
		this.prise = prise;
		this.date = date;
		this.histryid = histryid;
	}
	public Histry() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Histry [cartid=" + cartid + ", email=" + email + ", productid=" + productid + ", quantity=" + quantity
				+ ", productname=" + productname + ", prise=" + prise + ", date=" + date + ", histryid=" + histryid
				+ "]";
	}
			
}
