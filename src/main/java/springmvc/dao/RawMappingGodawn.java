
package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Godawn;


public class RawMappingGodawn implements RowMapper<Godawn> {

	public Godawn mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Godawn g=new Godawn();
		g.setGodawn_no(rs.getInt(1));
		g.setHouse_no(rs.getString(2));
		g.setRent(rs.getInt(3));
		g.setOwnerid(rs.getInt(4));
		return g;
	}

}
