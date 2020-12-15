package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Product;

@Repository
public class ProductDao {
	
    @Autowired 
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
    
	public Product search_by_name(String name)
	{
		String query="select * from product where name=?";
		Product p1;
		RowMapper<Product> rm=new RawMappingProduct();
		  try {
	    	 p1=this.jdbctemplate.queryForObject(query,rm,name);
	    	 return p1;
		   }
		  catch (Exception e) {
			return null;
		 }
		
	}
	public int insert(Product p)
	{
		String query="insert into product(name,sellingprise ,costprise, quantity ,companyid,godawn_no) values(?,?,?,?,?,?)";
		int r=this.jdbctemplate.update(query,p.getName(),p.getSp(),p.getCp(),p.getQuantity(),p.getCompany_id(),p.getGodawn_no());
		return r;
	}
	
	public List<Product> showallproduct()
	{
		String query ="select * from product";
		RowMapper<Product> allproduct=new RawMappingProduct();
		List<Product> pt= this.jdbctemplate.query(query,allproduct);
		return pt;
		
	}
	
	public Product searchbyid(int id)
	{
		String query="select * from product where productid=?";
		RowMapper<Product> productbyid= new RawMappingProduct();
		try {
			Product p= this.jdbctemplate.queryForObject(query, productbyid,id);
			return p;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public int deltproductbyid(int id)
	{
		String query="delete from product where productid=?";
		 int r=this.jdbctemplate.update(query,id);
		  return r;
	}
	

	
	public List<Product> showemptyproduct()
	{
		String query ="select * from product where quantity=0";
		RowMapper<Product> allproduct=new RawMappingProduct();
		List<Product> pt= this.jdbctemplate.query(query,allproduct);
		return pt;
		
	}

	public void update_quantity(Product p) {
		String q="select * from product where name=?";
		RowMapper<Product>  rm=new RawMappingProduct();
		Product p1=this.jdbctemplate.queryForObject(q,rm,p.getName());
		int newq=p1.getQuantity()+p.getQuantity();
		String qq="update product set quantity =? where name=?";
		this.jdbctemplate.update(qq,newq,p1.getName());
	}
	public List<Product> showcustomerproduct()
	{
		String query ="select * from product where not quantity=0 ";
		RowMapper<Product> cusproduct=new RawMappingProduct();
		List<Product> pt= this.jdbctemplate.query(query,cusproduct);
		return pt;
		
	}
	
	public void buy_product(int productid, int quantity) {
		String q="select * from product where productid=?";
		RowMapper<Product>  rm=new RawMappingProduct();
		Product p=this.jdbctemplate.queryForObject(q,rm,productid);
		int newq=p.getQuantity()-quantity;
		String qq="update product set quantity =? where productid=?";
		this.jdbctemplate.update(qq,newq,productid);
	}
}