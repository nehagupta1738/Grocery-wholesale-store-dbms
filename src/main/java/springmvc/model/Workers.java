package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Workers {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int workersid;
	public String fname;
	public String sname;
	public String phone;
	public int sallery;
	public int getWorkersid() {
		return workersid;
	}
	public void setWorkersid(int workersid) {
		this.workersid = workersid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getSallery() {
		return sallery;
	}
	public void setSallery(int sallery) {
		this.sallery = sallery;
	}
	public Workers(int workersid, String fname, String sname, String phone, int sallery) {
		super();
		this.workersid = workersid;
		this.fname = fname;
		this.sname = sname;
		this.phone = phone;
		this.sallery = sallery;
	}
	public Workers() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Workers [workersid=" + workersid + ", fname=" + fname + ", sname=" + sname + ", phone=" + phone
				+ ", sallery=" + sallery + "]";
	}
	
	
}
