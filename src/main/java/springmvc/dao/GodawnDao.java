package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Godawn;


@Repository
public class GodawnDao {
    
	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	public int insert (Godawn godawn)
	{
		String query="insert into godawn (house_no,rent,ownerid) values(?,?,?)";
	    int r=this.jdbctemplate.update(query,godawn.getHouse_no(),godawn.getRent(),godawn.getOwnerid());
	    return r;
	}
	
	public List<Godawn> showallgodawns()
	{
		String query ="select * from godawn";
		RowMapper<Godawn> allgodawn=new RawMappingGodawn();
		List<Godawn> ow= this.jdbctemplate.query(query,allgodawn);
		return ow;
		
	}
	
	public Godawn searchbyid(int id)
	{
		String query="select * from godawn where godawn_no=?";
		RowMapper<Godawn> godawnbyid= new RawMappingGodawn();
		try {
			Godawn g= this.jdbctemplate.queryForObject(query, godawnbyid,id);
			return g;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public int deltgodawnbyid(int id)
	{
		String query="delete from godawn where godawn_no=?";
		 int r=this.jdbctemplate.update(query, id);
		  return r;
	}

	
}
