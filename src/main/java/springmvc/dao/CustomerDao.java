package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.Customer;

@Repository
public class CustomerDao { 
	
	@Autowired
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	public int insert (Customer customer)
	{  
		String query="insert into customer (firstName, lastName, email, password, address, city, state, pin)" + " values(?,?,?,?,?,?,?,?)";
		try {
			this.jdbctemplate.update(query,customer.getFname(),customer.getLname(),
					customer.getEmail(),customer.getPassword(),customer.getAddress(),customer.getCity(),customer.getState(),
					customer.getPin());
			return 1;
		} catch (Exception e) {
			return 0;
		}
		
		
	}
	
	public List<Customer> showallcustomer()
	{
		String query ="select * from customer";
		RowMapper<Customer> allcustomer=new RawMappingCustomer();
		List<Customer> lc= this.jdbctemplate.query(query,allcustomer);
		return lc;
		
	}
	
	public Customer searchbyid(int id)
	{
		String query="select * from customer where customerid=?";
		RowMapper<Customer> customerbyid= new RawMappingCustomer();
		try {
			Customer c= this.jdbctemplate.queryForObject(query, customerbyid,id);
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	 public Customer verifycustomer(String email,String password)
	    {
	    	String query="select * from customer where email=? and password = ?";
	    	RowMapper<Customer> rawmapper = new RawMappingCustomer();
	    	try {
				
	    		Customer c= jdbctemplate.queryForObject(query, rawmapper,email,password);
	    		return c;
			} catch ( Exception e) {
				// TODO: handle exception
				return null;
			}
	    }
    public int updateprofile(String fname,String sname,String email,String address,String city,String state,int pin)
    {
    	String query="update customer set firstname=?,lastname=?,address=?,city=?,state=?,pin=? where email=?";
    	int r=this.jdbctemplate.update(query,fname,sname, address, city, state, pin , email);
    	return r;
    }
    
    public Customer searchbyemail(String email)
    {
    	String query="select *  from customer where email=?";
    	RowMapper<Customer> rm=new RawMappingCustomer();
    	Customer c=this.jdbctemplate.queryForObject(query,rm,email);
    	return c;
    }
}