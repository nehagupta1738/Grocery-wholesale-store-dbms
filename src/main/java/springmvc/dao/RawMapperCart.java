package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Cart;

public class RawMapperCart implements RowMapper<Cart> {

	public Cart mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Cart c= new Cart();
		c.setCartid(rs.getInt(1));
		c.setEmail(rs.getString(2));
		c.setProductid(rs.getInt(3));
		c.setQuantity(rs.getInt(4));
		return c;
	}

}
