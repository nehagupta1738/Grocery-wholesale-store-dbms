package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Review;

@Repository
public class ReviewDao {
	@Autowired
	private JdbcTemplate jdbctempelate;
	
	
	public int insertreview(String email,int productid, String description)
	{
		String query="insert into review (email,productid,description) values(?,?,?)";
		int r=this.jdbctempelate.update(query,email,productid,description);
		return r;
	}
    
	public List<Review> showreview(int productid)
    {
    	String query="select * from review where productid=?";
    	RowMapper<Review> rm= new RawMappingReview();
    	List<Review> r=this.jdbctempelate.query(query,rm,productid);
    	return r;
    }
}
