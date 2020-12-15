package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Godawn_owner;

public class RawMappingGodawn_owner implements RowMapper<Godawn_owner> {

	public Godawn_owner mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Godawn_owner g=new Godawn_owner();
		g.setOwnerid(rs.getInt(1));
		g.setFirstname(rs.getString(2));
		g.setLastname(rs.getString(3));
		g.setPhone(rs.getString(4));
		return g;
	}

}
