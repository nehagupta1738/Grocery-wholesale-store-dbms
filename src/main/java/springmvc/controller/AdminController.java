package springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import springmvc.dao.AdminDao;
import springmvc.dao.CompanyDao;
import springmvc.dao.CustomerDao;
import springmvc.dao.GodawnDao;
import springmvc.dao.Godawn_ownerDao;
import springmvc.dao.HistryDao;
import springmvc.dao.ProductDao;
import springmvc.dao.WorkersDao;
import springmvc.model.Admin;
import springmvc.model.Company;
import springmvc.model.Customer;
import springmvc.model.Godawn;
import springmvc.model.Godawn_owner;
import springmvc.model.Histry;
import springmvc.model.Product;
import springmvc.model.Workers;
@Controller
public class AdminController {
    @Autowired
	private AdminDao admindao;
    @Autowired
	private CustomerDao customerdao;
    @Autowired
    private ProductDao productdao;
    @Autowired
    private CompanyDao companydao;
    @Autowired
    private WorkersDao workersdao;
    @Autowired
    private Godawn_ownerDao godawn_ownerdao;
    @Autowired
    private GodawnDao godawndao;
    @Autowired
    private HistryDao histrydao;
	
    @RequestMapping("/admin_login")
	 public String adminlogin()
	 {
		return "admin_login"; 
	 }

    
	@RequestMapping(path="/admin_page", method=RequestMethod.POST)
	public String adminpage(@RequestParam("email") String email,@RequestParam("password") String password ,Model m,ModelMap mp,HttpSession s)
	{  
		if(admindao.verifyadmin(email,password)==null)
		{   
			mp.put("error", "Email or password didn't match");
			return "admin_login";
		}
		else
		{
			m.addAttribute("email" , email);
			Admin a=admindao.searchbyemail(email);
			s.setAttribute("admin", a);
			List<Customer> cuslist = customerdao.showallcustomer();
			int n=cuslist.size();
			m.addAttribute("n",n);
			m.addAttribute("cuslist",cuslist);
			
			
			List<Product> prolist = productdao.showallproduct();
			//System.out.println(prolist);
			int np=prolist.size();
			m.addAttribute("np",np);
			m.addAttribute("prolist",prolist);
			
			
			List<Product> empro = productdao.showemptyproduct();
			int n2=empro.size();
			m.addAttribute("n2",n2);
			m.addAttribute("empro",empro);
			
			List<Company> comp = companydao.showallcompany();
			int n3=comp.size();
			m.addAttribute("n3",n3);
			m.addAttribute("comp", comp);
			
			List<Workers> wor = workersdao.showallworkers();
			int n4=wor.size();
			m.addAttribute("n4",n4);
			m.addAttribute("wor", wor);
			
			List<Godawn_owner> owner = godawn_ownerdao.showallowners();
			m.addAttribute("owner", owner);
			
			List<Godawn> godawn = godawndao.showallgodawns();
			m.addAttribute("godawn", godawn);
			
			int profit=0;
			 List<Histry> histryprofit=histrydao.totalprofit();
			 System.out.println(histryprofit);
			 for(Histry h:histryprofit)
			 {  
				 Product p1=productdao.searchbyid(h.getProductid());
				 int x1=p1.getSp();
				 int x2=p1.getCp();
				 System.out.println(x1);
				 System.out.println(x2);
				
				profit+=p1.getSp()*h.getQuantity()-p1.getCp()*h.getQuantity();
			 }
			 System.out.println(profit);
			 m.addAttribute("profit",profit);
	
			return "admin_page";
		}
	}
	@RequestMapping("/adminhome")
	public String gotohome(HttpSession s, Model m)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Admin ad= (Admin) s.getAttribute("admin");
		String email=ad.getEmail();
		m.addAttribute("email" , email);
		Admin a=admindao.searchbyemail(email);
		s.setAttribute("admin", a);
		List<Customer> cuslist = customerdao.showallcustomer();
		int n=cuslist.size();
		m.addAttribute("n",n);
		m.addAttribute("cuslist",cuslist);
		
		
		List<Product> prolist = productdao.showallproduct();
		//System.out.println(prolist);
		int np=prolist.size();
		m.addAttribute("np",np);
		m.addAttribute("prolist",prolist);
		
		
		List<Product> empro = productdao.showemptyproduct();
		int n2=empro.size();
		m.addAttribute("n2",n2);
		m.addAttribute("empro",empro);
		
		List<Company> comp = companydao.showallcompany();
		int n3=comp.size();
		m.addAttribute("n3",n3);
		m.addAttribute("comp", comp);
		
		List<Workers> wor = workersdao.showallworkers();
		int n4=wor.size();
		m.addAttribute("n4",n4);
		m.addAttribute("wor", wor);
		
		List<Godawn_owner> owner = godawn_ownerdao.showallowners();
		m.addAttribute("owner", owner);
		
		List<Godawn> godawn = godawndao.showallgodawns();
		m.addAttribute("godawn", godawn);
		
		 int profit=0;
		 List<Histry> histryprofit=histrydao.totalprofit();
		 System.out.println(histryprofit);
		 for(Histry h:histryprofit)
		 {  
			 
			Product p1=productdao.searchbyid(h.getProductid());
			int x1=p1.getSp();
			int x2=p1.getCp();
			System.out.println(x1);
			System.out.println(x2);
			profit+=p1.getSp()*h.getQuantity()-p1.getCp()*h.getQuantity();
		 }
		 System.out.println(profit);
		 m.addAttribute("profit",profit);

		return "admin_page";

	}
	
	@RequestMapping(path="/showcustomer", method=RequestMethod.POST)
	public String showcustomerbyid(@RequestParam("id") int id , Model m,HttpSession s)
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		Customer c=customerdao.searchbyid(id);
		System.out.println(c);
		System.out.println(id);
		if(c==null)
		m.addAttribute("show","null");
		else
		m.addAttribute("show",c);
		return "show_customer_byid";
	}
	
	@RequestMapping(path="/add_product", method=RequestMethod.POST)
	public String addproduct(@ModelAttribute Product p,Model m,HttpSession s)	
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		Company c=companydao.searchbyid(p.getCompany_id());
		Godawn g=godawndao.searchbyid(p.getGodawn_no());
		if(c==null)
			return "companyNotfound";
		else if(g==null)
			return "godawnNotfound";
		System.out.println(p);
		if(productdao.search_by_name(p.getName())==null)
		{
			productdao.insert(p);
		}
		else {
			productdao.update_quantity(p);
		}
		return "add_product_result";
		
	}
	
	@RequestMapping(path="/showproduct", method=RequestMethod.POST)
	public String showproductbyid(@RequestParam("id2") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Product p=productdao.searchbyid(id);
		if(p==null)
		m.addAttribute("show","null");
		else
		m.addAttribute("show",p);
		return "show_product_byid";
	}
	
	@RequestMapping(path="/deleteproduct", method=RequestMethod.POST)
	public String deleteproductbyid(@RequestParam("id3") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		int r=productdao.deltproductbyid(id);
		
		m.addAttribute("r",r);
		System.out.println(r);
		return "delete_product_byid";
	}
	
	
	@RequestMapping(path="/add_company", method=RequestMethod.POST)
	public String addcompany(@ModelAttribute Company c,Model m,HttpSession s)	
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		companydao.insert(c);
		return "add_company_result";
		
	}
	
	@RequestMapping(path="/showcompany", method=RequestMethod.POST)
	public String showcompanybyid(@RequestParam("id4") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Company c=companydao.searchbyid(id);
		if(c==null)
		m.addAttribute("showcompany","null");
		else
		m.addAttribute("showcompany",c);
		return "show_company_byid";
	}
	
	@RequestMapping(path="/deletecompany", method=RequestMethod.POST)
	public String deletecompanybyid(@RequestParam("id5") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		int r=companydao.deltcompanybyid(id);
		
		m.addAttribute("r",r);
		System.out.println(r);
		return "delete_company_byid";
	}
	
	
	@RequestMapping(path="/add_workers", method=RequestMethod.POST)
	public String addworkers(@ModelAttribute Workers w,Model m,HttpSession s)	
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		workersdao.insert(w);
		return "add_workers_result";
		
	}
	
	@RequestMapping(path="/showworkers", method=RequestMethod.POST)
	public String showworkersbyid(@RequestParam("id6") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Workers w=workersdao.searchbyid(id);
		m.addAttribute("showworker",w);
		if(w==null)
		m.addAttribute("showworker","null");
		else
		m.addAttribute("showworker",w);
		return "show_workers_byid";
	}
	
	@RequestMapping(path="/deleteworkers", method=RequestMethod.POST)
	public String deleteworkersbyid(@RequestParam("id7") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		int r=workersdao.deltworkerbyid(id);
		
		m.addAttribute("r",r);
		System.out.println(r);
		return "delete_workers_byid";
	}
	
	@RequestMapping(path="/updateworkers", method=RequestMethod.POST)
	public String updateworkersallery(@RequestParam("id8") int id ,@RequestParam("newsallery") int newsallery, Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Workers w=workersdao.searchbyid(id);
		m.addAttribute("showprevious",w);
		int t=workersdao.updatesallery(id,newsallery);
		m.addAttribute("newsallery",newsallery);
		return "worker_updated_salery";
	}
	
	@RequestMapping(path="/showowner", method=RequestMethod.POST)
	public String showownerbyid(@RequestParam("id9") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Godawn_owner g=godawn_ownerdao.searchbyid(id);
		m.addAttribute("showowner",g);
		System.out.println(g);
		return "show_owner_byid";
	}
	
	@RequestMapping(path="/add_owner", method=RequestMethod.POST)
	public String addproduct(@ModelAttribute Godawn_owner g,Model m,HttpSession s)	
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		godawn_ownerdao.insert(g);
		return "add_owner_result";
		
	}
	
	@RequestMapping(path="/deleteowner", method=RequestMethod.POST)
	public String deleteownerbyid(@RequestParam("id10") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		int r=godawn_ownerdao.deltownerbyid(id);
		m.addAttribute("r",r);
		return "delete_owner_byid";
	}
	
	@RequestMapping(path="/showgodawn", method=RequestMethod.POST)
	public String showgodawnbyid(@RequestParam("id11") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		Godawn g=godawndao.searchbyid(id);
		m.addAttribute("showgodawn",g);
		if(g==null)
		m.addAttribute("showgodawn","null");
		else
		m.addAttribute("showgodawn",g);
		return "show_godawn_byid";
	}
	
	@RequestMapping(path="/add_godawn", method=RequestMethod.POST)
	public String addproduct(@ModelAttribute Godawn g,Model m,HttpSession s)	
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		godawndao.insert(g);
		return "add_godawn_result";
		
	}
	
	@RequestMapping(path="/deletegodawn", method=RequestMethod.POST)
	public String deletegodawnbyid(@RequestParam("id12") int id , Model m,HttpSession s)
	{
		if(s.getAttribute("admin")==null)
			return "home";
		int r=godawndao.deltgodawnbyid(id);
		m.addAttribute("r",r);
		return "delete_godawn_byid";
	}
	@RequestMapping(path="/admin_profile_updated",method=RequestMethod.POST)
	public String updateprofile(@RequestParam("firstname") String firstname, 
			@RequestParam("lastname") String lastname,@RequestParam("email") String email,
			@RequestParam("phone") String phone ,HttpSession s)
	{   
		if(s.getAttribute("admin")==null)
			return "home";
		admindao.updateprofile(firstname, lastname, email, phone);
		return "admin_profile_updated";
	}
}