package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Review;

public class RawMappingReview implements RowMapper<Review>{

	public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Review r=new Review();
		r.setEmail(rs.getString(1));
		r.setProductid(rs.getInt(2));
		r.setDescription(rs.getString(3));
		r.setReviewid(rs.getInt(4));
		return r;
	}

}
