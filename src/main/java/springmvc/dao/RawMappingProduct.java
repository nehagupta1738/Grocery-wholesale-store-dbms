package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Product;

public class RawMappingProduct implements RowMapper<Product> {

	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product p = new Product();
		p.setProductid(rs.getInt(1));
		p.setName(rs.getString(2));
		p.setSp(rs.getInt(3));
		p.setCp(rs.getInt(4));
		
		p.setQuantity(rs.getInt(5));
		p.setCompany_id(rs.getInt(6));
		p.setGodawn_no(rs.getInt(7));
		return p;
	}

}