package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Godawn {
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int godawn_no;
	public String house_no;
	public int rent;
	public int ownerid;
	public int getGodawn_no() {
		return godawn_no;
	}
	public void setGodawn_no(int godawn_no) {
		this.godawn_no = godawn_no;
	}
	public String getHouse_no() {
		return house_no;
	}
	public void setHouse_no(String house_no) {
		this.house_no = house_no;
	}
	public int getRent() {
		return rent;
	}
	public void setRent(int rent) {
		this.rent = rent;
	}
	public int getOwnerid() {
		return ownerid;
	}
	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}
	public Godawn(int godawn_no, String house_no, int rent, int ownerid) {
		super();
		this.godawn_no = godawn_no;
		this.house_no = house_no;
		this.rent = rent;
		this.ownerid = ownerid;
	}
	public Godawn() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Godawn [godawn_no=" + godawn_no + ", house_no=" + house_no + ", rent=" + rent + ", ownerid=" + ownerid
				+ "]";
	}
	
}
