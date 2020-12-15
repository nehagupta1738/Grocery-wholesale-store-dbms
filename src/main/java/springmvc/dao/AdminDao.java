package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Admin;


@Repository
public class AdminDao {
    @Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
    
    public Admin verifyadmin(String email,String password)
    {
    	String query="select * from admin where email=? and password = ?";
    	RowMapper<Admin> rawmapper = new RawMappingAdmin();
    	try {
			
    		Admin a= jdbctemplate.queryForObject(query, rawmapper,email,password);
    		return a;
		} catch ( Exception e) {
			// TODO: handle exception
			return null;
		}
    }
    
    public List<Admin> showadmin()
    {
    	String query="select * from admin";
    	RowMapper<Admin> rowmap= new RawMappingAdmin();
    	List<Admin> adm= this.jdbctemplate.query(query,rowmap);
    	return adm;
    }
    public Admin searchbyemail(String email)
    {
    	String query="select *  from admin where email=?";
    	RowMapper<Admin> rm=new RawMappingAdmin();
    	Admin a=this.jdbctemplate.queryForObject(query,rm,email);
    	return a;
    }
    public int updateprofile(String fname,String sname,String email,String phone)
    {
    	String query="update admin set firstname=?,lastname=?,phone=? where email=?";
    	int r=this.jdbctemplate.update(query,fname,sname,phone,email);
    	return r;
    }
}
