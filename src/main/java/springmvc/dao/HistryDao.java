package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Histry;
import springmvc.model.Product;
@Repository
public class HistryDao {
	 @Autowired
	 private JdbcTemplate jdbctemplate;	
	 
	    public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

		public int insettohistry(String email,int productid,int quantity)
		{
			String query="insert into histry (email,productid,quantity) values (?,?,?)";
			int r=this.jdbctemplate.update(query,email, productid,quantity);
			return r;
		}
	    
	    public List<Histry> showhistry(String email)
	    {
	    	String query="select * from histry where email=?";
	    	RowMapper<Histry> rm= new RawMapperHistry();
	    	List<Histry> h=this.jdbctemplate.query(query,rm,email);
	    	return h;
	    }
	    
	    public List<Histry> totalprofit()
	    {
	    	String query="select * from histry";
	    	RowMapper<Histry> rm=new RawMapperHistry();
	    	List<Histry> h=this.jdbctemplate.query(query,rm);
	    	return h;
	    }
	    public Histry searchbyid(int id)
		{
			String query="select * from histry where histryid=?";
			RowMapper<Histry> rm= new RawMapperHistry();
			try {
				Histry h= this.jdbctemplate.queryForObject(query, rm,id);
				return h;
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
			
		}
}


