package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Godawn_owner {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int ownerid;
	public String firstname;
	public String lastname;
	public String phone;
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Godawn_owner(int ownerid, String firstname, String lastname, String phone) {
		super();
		this.ownerid = ownerid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
	}
	public Godawn_owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Godawn_owner [ownerid=" + ownerid + ", firstname=" + firstname + ", lastname=" + lastname + ", phone="
				+ phone + "]";
	}
	
}
