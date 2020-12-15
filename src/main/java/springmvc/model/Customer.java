package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	private String fname;
	private String lname;
	private String email;
	private String password;
	private String address;
	private String city;
	private String state;
	private int pin;
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password + ", address=" + address + ", city=" + city + ", state=" + state + ", pin="
				+ pin + "]";
	}
	public Customer(int customerid, String fname, String lname, String email, String password, String address,
			String city, String state, int pin) {
		super();
		this.customerid = customerid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}