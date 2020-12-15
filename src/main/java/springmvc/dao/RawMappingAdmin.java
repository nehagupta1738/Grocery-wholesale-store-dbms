package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Admin;

public class RawMappingAdmin implements RowMapper<Admin> {

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
	
		Admin a= new Admin();
		a.setAdminid(rs.getInt(1));
		a.setFirstname(rs.getString(2));
		a.setLastname(rs.getString(3));
		a.setEmail(rs.getString(4));
		a.setPassword(rs.getString(5));
		a.setPhone(rs.getString(6));
		return a;
	}
	

}
