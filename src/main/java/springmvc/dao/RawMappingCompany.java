package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Company;

public class RawMappingCompany implements RowMapper<Company> {

	public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Company c= new Company();
		c.setCompanyid(rs.getInt(1));
		c.setName(rs.getString(2));
		c.setCity(rs.getString(3));
		c.setAddress(rs.getString(4));
		c.setEmail(rs.getString(5));
		c.setPhone(rs.getString(6));
		return c;
	}

}
