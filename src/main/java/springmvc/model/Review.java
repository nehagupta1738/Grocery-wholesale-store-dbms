package springmvc.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int reviewid;
	public String email;
	public int productid;
	public String description;
	public int getReviewid() {
		return reviewid;
	}
	public void setReviewid(int reviewid) {
		this.reviewid = reviewid;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Review(int reviewid, String email, int productid, String description) {
		super();
		this.reviewid = reviewid;
		this.email = email;
		this.productid = productid;
		this.description = description;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Review [reviewid=" + reviewid + ", email=" + email + ", productid=" + productid + ", description="
				+ description + "]";
	}
	
}
