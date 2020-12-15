package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import springmvc.model.Cart;
import springmvc.model.Product;


@Repository
public class CartDao {
	@Autowired
	private JdbcTemplate jdbctemplate;
	
	
	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public int insettocart(String email,int productid,int quantity)
	{
		String query="insert into cart (email,productid,quantity) values (?,?,?)";
		int r=this.jdbctemplate.update(query, email, productid,quantity);
		return r;
	}
	
    public void deletecart(int cartid)
    {
    	String query="delete from cart where cartid=?";
    	int r=this.jdbctemplate.update(query,cartid);
    }
    
  
    public List<Cart> showcart(String email)
    {
    	String query="select * from cart where email=?";
    	RowMapper<Cart> rm= new RawMapperCart();
    	List<Cart> c=this.jdbctemplate.query(query,rm,email);
    	return c;
    }
    
    public Cart findcart(int cartid)
    {
    	String query="select * from cart where cartid=?";
    	RowMapper<Cart> rm= new RawMapperCart();
    	Cart c=this.jdbctemplate.queryForObject(query,rm,cartid);
    	return c;
    }
    
 
}
