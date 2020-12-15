package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Customer;

public class RawMappingCustomer implements RowMapper<Customer> { 

	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Customer c=new Customer();
		c.setCustomerid(rs.getInt(1));
		c.setFname(rs.getString(2));
		c.setLname(rs.getString(3));
		c.setEmail(rs.getString(4));
		c.setPassword(rs.getString(5));
		c.setAddress(rs.getString(6));
		c.setCity(rs.getString(7));
		c.setState(rs.getString(8));
		c.setPin(rs.getInt(9));
		return c;
	}
}