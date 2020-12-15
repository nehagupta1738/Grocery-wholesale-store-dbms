package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Product {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int productid;
	public String name;
	public int cp;
	public int sp;
	public int quantity;
	public int company_id;
	public int godawn_no;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getSp() {
		return sp;
	}
	public void setSp(int sp) {
		this.sp = sp;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCompany_id() {
		return company_id;
	}
	public void setCompany_id(int company_id) {
		this.company_id = company_id;
	}
	public int getGodawn_no() {
		return godawn_no;
	}
	public void setGodawn_no(int godawn_no) {
		this.godawn_no = godawn_no;
	}
	public Product(int productid, String name, int cp, int sp, int quantity, int company_id, int godawn_no) {
		super();
		this.productid = productid;
		this.name = name;
		this.cp = cp;
		this.sp = sp;
		this.quantity = quantity;
		this.company_id = company_id;
		this.godawn_no = godawn_no;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Product [productid=" + productid + ", name=" + name + ", cp=" + cp + ", sp=" + sp + ", quantity="
				+ quantity + ", company_id=" + company_id + ", godawn_no=" + godawn_no + "]";
	}
		
}