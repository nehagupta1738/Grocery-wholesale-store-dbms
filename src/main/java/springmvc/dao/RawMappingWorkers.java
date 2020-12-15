package springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import springmvc.model.Workers;

public class RawMappingWorkers implements RowMapper<Workers> {

	public Workers mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Workers w=new Workers();
		w.setWorkersid(rs.getInt(1));
		w.setFname(rs.getString(2));
		w.setSname(rs.getString(3));
		w.setSallery(rs.getInt(4));
		w.setPhone(rs.getString(5));
		return w;
	}

}
