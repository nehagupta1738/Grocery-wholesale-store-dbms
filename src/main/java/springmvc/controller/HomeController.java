package springmvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import springmvc.dao.CustomerDao;
import springmvc.model.Customer;

@Controller
public class HomeController {
	@Autowired
	private CustomerDao customerdao;
	
    @RequestMapping("/")
	public String showhome()
	{
		return "home";
	}
    @RequestMapping("/customersignup")
    public String signup()
    {
    	return "customer_signup";
    }
    
	 @RequestMapping("/customer_signin") 
	 public String redirecttologin()
	 { 
		 return  "customer_login";
     }
	 @RequestMapping("/logout")
	 public String adminlogout(HttpSession s)
	 {  
		 s.removeAttribute("admin");
		return "redirect:/"; 
	 }
     
	 @RequestMapping("/customerlogout")
	 public String customerlogout(HttpSession s)
	 {  
		 s.removeAttribute("customer");
		 return "redirect:/"; 
	 }
     
	 
	 
}
