package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import springmvc.model.Workers;


@Repository
public class WorkersDao {
	
    @Autowired
	public JdbcTemplate jdbctemplate;

	
    
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public int insert (Workers workers)
	{
		String query="insert into workers (firstname,lastname,phone,salery) values(?,?,?,?)";
	    int r=this.jdbctemplate.update(query,workers.getFname(),workers.getSname(),workers.getPhone(),workers.getSallery());
	    return r;
	}
	
	public List<Workers> showallworkers()
	{
		String query ="select * from workers";
		RowMapper<Workers> allworkers=new RawMappingWorkers();
		List<Workers> w= this.jdbctemplate.query(query,allworkers);
		return w;
		
	}
	
	public int deltworkerbyid(int id)
	{
		String query="delete from workers where workerid=?";
		 int r=this.jdbctemplate.update(query, id);
		  return r;
	}
	
	public Workers searchbyid(int id)
	{
		String query="select * from workers where workerid=?";
		RowMapper<Workers> workersbyid= new RawMappingWorkers();
		try {
			Workers w= this.jdbctemplate.queryForObject(query, workersbyid,id);
			return w;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public int updatesallery(int id , int newsallery)
	{
		String query="update workers set salery=? where workerid=?";
		int r=this.jdbctemplate.update(query,newsallery,id);
		return r;
	}
	
	
}
