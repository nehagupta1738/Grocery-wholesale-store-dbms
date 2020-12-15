package springmvc.model;

public class Company {
   
	private int companyid;
	private String name;
	private String city;
	private String address;
	private String email;
	private String phone;
	public int getCompanyid() {
		return companyid;
	}
	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Company(int companyid, String name, String city, String address, String email, String phone) {
		super();
		this.companyid = companyid;
		this.name = name;
		this.city = city;
		this.address = address;
		this.email = email;
		this.phone = phone;
	}
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Company [companyid=" + companyid + ", name=" + name + ", city=" + city + ", address=" + address
				+ ", email=" + email + ", phone=" + phone + "]";
	}
	
}
