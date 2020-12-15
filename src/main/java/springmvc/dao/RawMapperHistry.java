package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import springmvc.model.Histry;

public class RawMapperHistry implements RowMapper<Histry> {

	public Histry mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Histry c= new Histry();
		c.setEmail(rs.getString(1));
		c.setProductid(rs.getInt(2));
		c.setQuantity(rs.getInt(3));
		c.setHistryid(rs.getInt(4));
		return c;
	}

}
