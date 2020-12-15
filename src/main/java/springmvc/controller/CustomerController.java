package springmvc.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import springmvc.dao.AdminDao;
import springmvc.dao.CartDao;
import springmvc.dao.CustomerDao;
import springmvc.dao.HistryDao;
import springmvc.dao.ProductDao;
import springmvc.dao.ReviewDao;
import springmvc.model.Admin;
import springmvc.model.Cart;
import springmvc.model.Customer;
import springmvc.model.Histry;
import springmvc.model.Product;
import springmvc.model.Review;

@Controller
public class CustomerController {
	@Autowired
	CustomerDao customerdao;
	@Autowired
	private AdminDao admindao;
	@Autowired
	private ProductDao productdao;
	@Autowired
	private CartDao cartdao;
	@Autowired
	private HistryDao histrydao;
	@Autowired
	private ReviewDao reviewdao;

	public String bytesToHex(byte bytes[]) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}

	public String encode(String password) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] result = md.digest(password.getBytes(StandardCharsets.UTF_8));
			String hex = bytesToHex(result);
			return hex;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(path = "/customerlogin", method = RequestMethod.POST)
	public String login(@ModelAttribute Customer customer, Model model,ModelMap mp) {
		//System.out.println(customer);
		String password = customer.getPassword();
		String encrypted = encode(password);
		customer.setPassword(encrypted);
		int r = customerdao.insert(customer);
		if (r == 0)
		{   
			mp.put("error", "Already registered with this Email");
			return "customer_signup";
		}

		return "customer_login";
	}

	@RequestMapping(path = "/customer_page", method = RequestMethod.POST)
	public String customerpage(@RequestParam("email") String email, @RequestParam("password") String password, Model m,ModelMap mp,
			HttpSession s) {
		String p = encode(password);
		password = p;
		//System.out.println(password);
		if (customerdao.verifycustomer(email, password) == null)
		{   
			mp.put("error", "Email or password didn't match");
			return "customer_login";
		}
		else {
			m.addAttribute("email", email);

			Customer c = customerdao.searchbyemail(email);
			//System.out.println(c);
			m.addAttribute(c);
			s.setAttribute("customer", c);
			List<Product> cuspro = productdao.showcustomerproduct();
			//System.out.println(cuspro);
			m.addAttribute("cuspro", cuspro);

			List<Admin> admin = admindao.showadmin();
			m.addAttribute("admin", admin);

			List<Cart> cart = cartdao.showcart(email);
			for (Cart c1 : cart) {
				Product p1 = productdao.searchbyid(c1.getProductid());
				c1.setProductname(p1.getName());
				c1.setPrise(p1.getSp() * c1.getQuantity());
			}
			m.addAttribute("cart", cart);

			 List<Histry> histry=histrydao.showhistry(email);
			// System.out.println(histry);
			 
			  for(Histry h1:histry) {
			  Product p2=productdao.searchbyid(h1.getProductid());
			 // System.out.println(h1.getProductid());
			 // System.out.println(p2);
				
				 h1.setProductname(p2.getName());
				 h1.setPrise(p2.getSp()*h1.getQuantity());
				 
			   }
			  m.addAttribute("histry",histry);
			  
			 
			return "customer_page";

		}
	}

	@RequestMapping("/customerhome")
	public String gotohome(Model m, HttpSession s) {
		if (s.getAttribute("customer") == null)
			return "home";
		Customer cus = (Customer) s.getAttribute("customer");
		String email = cus.getEmail();
		m.addAttribute("email", email);

		Customer c = customerdao.searchbyemail(email);
		//System.out.println(c);
		m.addAttribute(c);
		s.setAttribute("customer", c);
		List<Product> cuspro = productdao.showcustomerproduct();
		System.out.println(cuspro);
		m.addAttribute("cuspro", cuspro);

		List<Admin> admin = admindao.showadmin();
		m.addAttribute("admin", admin);

		List<Cart> cart = cartdao.showcart(email);
		for (Cart c1 : cart) {
			Product p1 = productdao.searchbyid(c1.getProductid());
			c1.setProductname(p1.getName());
			c1.setPrise(p1.getSp() * c1.getQuantity());
		}
		m.addAttribute("cart", cart);

		
		  List<Histry> histry=histrydao.showhistry(email); for(Histry h1:histry) {
		  Product p2=productdao.searchbyid(h1.getProductid());
		  h1.setProductname(p2.getName()); h1.setPrise(p2.getSp()*h1.getQuantity()); }
		  m.addAttribute("histry",histry);
		 

		return "customer_page";

	}

	@RequestMapping(path = "/update_cart", method = RequestMethod.POST)
	public String addtocart(@RequestParam("productid") int pid, @RequestParam("quantity") int quantity,
			@RequestParam("customeremail") String email, Model m) {
		Product p = productdao.searchbyid(pid);
		if (p == null)
			return "ProductNotFound";
		m.addAttribute("pid", pid);
		cartdao.insettocart(email, pid, quantity);

		return "cart_updated";
	}

	@RequestMapping(path = "/delete/{cartid}")
	public String deletecart(@PathVariable("cartid") int id, Model m, HttpSession s) {
		if (s.getAttribute("customer") == null)
			return "home";
		/*
		 * Customer c=(Customer) s.getAttribute("customer");
		 */ cartdao.deletecart(id);
		return "delete_cart";
	}

	@RequestMapping(path = "/confirmorder/{cartid}")
	public String placeorder(@PathVariable("cartid") int id, Model m, HttpSession s) {
		if (s.getAttribute("customer") == null)
			return "home";
		Cart c = cartdao.findcart(id);
		cartdao.deletecart(id);
		Product p = productdao.searchbyid(c.getProductid());
		histrydao.insettohistry(c.getEmail(), c.getProductid(), c.getQuantity());
		productdao.buy_product(c.getProductid(), c.getQuantity());
		return "buy_product";
	}

	@RequestMapping(path = "/customer_profile_updated", method = RequestMethod.POST)
	public String profileupdater(@RequestParam("fname") String fname, @RequestParam("lname") String sname,
			@RequestParam("email") String email, @RequestParam("address") String address,
			@RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("pin") int pin,
			Model m, HttpSession s) {
		if (s.getAttribute("customer") == null)
			return "home";
		customerdao.updateprofile(fname, sname, email, address, city, state, pin);
		return "customer_profile_updated";
	}

	@RequestMapping(path = "/review/{histryid}")
	public String review(@PathVariable("histryid") int id, Model m, HttpSession s) {
		if (s.getAttribute("customer") == null)
			return "home";
		Histry h = histrydao.searchbyid(id);
		String email = h.getEmail();
		int productid = h.getProductid();
		m.addAttribute("id", id);
		m.addAttribute("email", email);
		m.addAttribute("productid", productid);
		return "fillreview";

	}
    @RequestMapping(path="/reviewadded" ,method = RequestMethod.POST)
	 public String reviewadded(@RequestParam("email") String email, @RequestParam("productid") int productid ,
			  @RequestParam("description") String description,Model m, HttpSession s) 
	 {
		 if (s.getAttribute("customer") == null)
				return "home";
		 int r=reviewdao.insertreview(email, productid, description);
		 return "reviewadded";
	 }
    @RequestMapping(path="/visitreview/{productid}")
    public String viewreview(@PathVariable("productid") int id,Model m,HttpSession s)
    {
    	if (s.getAttribute("customer") == null)
			return "home";
    	System.out.println(id);
    	List<Review> review=reviewdao.showreview(id);
    	System.out.println(review);
    	m.addAttribute("review",review);
    	return "visitreview";
    }
}
