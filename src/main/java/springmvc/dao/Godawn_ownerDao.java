package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Godawn_owner;


@Repository
public class Godawn_ownerDao {
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	public int insert (Godawn_owner Gowner)
	{
		String query="insert into godawn_owner (firstname,lastname,phone) values(?,?,?)";
	    int r=this.jdbctemplate.update(query,Gowner.getFirstname(),Gowner.getLastname(),Gowner.getPhone());
	    return r;
	}
	
	public List<Godawn_owner> showallowners()
	{
		String query ="select * from godawn_owner";
		RowMapper<Godawn_owner> allowner=new RawMappingGodawn_owner();
		List<Godawn_owner> ow= this.jdbctemplate.query(query,allowner);
		return ow;
		
	}
	
	public Godawn_owner searchbyid(int id)
	{
		String query="select * from godawn_owner where ownerid=?";
		RowMapper<Godawn_owner> ownerbyid= new RawMappingGodawn_owner();
		try {
			Godawn_owner g= this.jdbctemplate.queryForObject(query, ownerbyid,id);
			return g;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public int deltownerbyid(int id)
	{
		String query="delete from godawn_owner where ownerid=?";
		 int r=this.jdbctemplate.update(query, id);
		  return r;
	}

}
