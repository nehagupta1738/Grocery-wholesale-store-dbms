package springmvc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import springmvc.model.Company;

@Repository
public class CompanyDao {
	
	@Autowired 
	private JdbcTemplate jdbctemplate;

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
    
	public int insert (Company company)
	{
		String query="insert into company (Name,City,Address,Email,Phone) values(?,?,?,?,?)";
	    int r=this.jdbctemplate.update(query,company.getName(),company.getCity(),company.getAddress(),company.getEmail(),company.getPhone());
	    return r;
	}
	
	public List<Company> showallcompany()
	{
		String query ="select * from company";
		RowMapper<Company> allcompany=new RawMappingCompany();
		List<Company> cn= this.jdbctemplate.query(query,allcompany);
		return cn;
		
	}
	
	public Company searchbyid(int id)
	{
		String query="select * from company where companyid=?";
		RowMapper<Company> companybyid= new RawMappingCompany();
		try {
			Company c= this.jdbctemplate.queryForObject(query, companybyid,id);
			return c;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
		
	}
	
	public int deltcompanybyid(int id)
	{
		String query="delete from company where companyid=?";
		 int r=this.jdbctemplate.update(query, id);
		  return r;
	}
	
	
	
}
