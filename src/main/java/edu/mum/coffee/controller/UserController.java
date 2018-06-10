package edu.mum.coffee.controller;

import static org.mockito.Matchers.contains;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;

import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Order;
import edu.mum.coffee.domain.Orderline;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.PersonCreator;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.domain.User;
import edu.mum.coffee.service.OrderService;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import edu.mum.coffee.service.UserService;

@Controller
public class UserController {
	
	@Resource
	private PersonService personService;
	@Resource
	private ProductService productService;
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	
	
	@RequestMapping(value="/placeOrder")
	public String placeOrder(Model productModel,HttpSession session) {
		List<Product> products = new ArrayList<>();
		products = productService.getAllProduct();

		
		List<String> productNames = new ArrayList<>();
		List<String> description = new ArrayList<>();
		for(Product p : products) {
			if(!productNames.contains(p.getProductName())) {
				productNames.add(p.getProductName());
			}
			if(!description.contains(p.getDescription())) {
				description.add(p.getDescription());
			}
		}
		
		productModel.addAttribute("productNames", productNames);
		productModel.addAttribute("description", description);
		
		Person prs = (Person) session.getAttribute("person");
		
		System.out.println(">>>>>User Name in the User controller: "+prs.getFirstName());
		
		
		
//		Product p1 = new Product("Piza","small",10,ProductType.LUNCH);
//		Product p2 = new Product("Piza","large",10,ProductType.LUNCH);
//		Product p3 = new Product("Margarita","medium",10,ProductType.LUNCH);
//		
//		products.add(p1);
//		products.add(p2);
//		products.add(p3);
//		
//		productModel.addAttribute("products", products);
		return "placeOrder";
	}
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public String saveOrder(@RequestParam("productname") String productname,
			@RequestParam("desciption") String desciption,@RequestParam("quantity") String quantity, HttpSession session) {
		System.out.println("the quantity is: "+quantity);
		int qty=quantity.charAt(0)-48;
//		String test ="h";
//		if(quantity.contains(test)) qty = quantity.charAt(0);
//		else qty = Integer.parseInt(quantity);
		
		
		//get product related to this order
		List<Product> products = productService.getAllProduct();
		Product p = null;
		for(Product prd : products ) {
			if(prd.getProductName().equals(productname) && prd.getDescription().equals(desciption)) {
				p=prd;
				break;
			}
		}
		
		//person who is making this order
        Person prs = (Person) session.getAttribute("person");
        System.out.println(">>>>>User Name in PlaceOrder-POST method: "+prs.getFirstName());
        
        //order date
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.println(dateFormat.format(date));
        
        //create order and orderline objects and set their properties
        Order order = new Order();
        order.setOrderDate(date);
        order.setPerson(prs);
        
        Orderline orderLine = new Orderline();
        orderLine.setProduct(p);
        orderLine.setQuantity(qty);
        
        order.addOrderLine(orderLine);
        
        //updating the database
        orderService.save(order);
        
		
		return "user-page";
	}
	
	@RequestMapping(value="/updateprofile")
	public String updateProfile(Model model,HttpSession session) {
		 Person prs = (Person) session.getAttribute("person");
		 Person pp = personService.findById(prs.getId());
		 Address address = pp.getAddress();
		 String email = pp.getEmail();
		 User user = userService.findByEmail(email).get(0);
		 String pw = user.getPassword();
		 
		 PersonCreator pc = new PersonCreator();
		 pc.setId(pp.getId());
		 pc.setFirstName(pp.getFirstName());
		 pc.setLastName(pp.getLastName());
		 pc.setPhone(pp.getPhone());
		 
		 pc.setCity(address.getCity());
		 pc.setState(address.getState());
		 pc.setZipcode(address.getZipcode());
		 pc.setCountry(address.getCountry());
		 
		 pc.setEmail(pp.getEmail());
		 pc.setPassword(pw);
		 
		 model.addAttribute("person", pc);
		
		return "userDetail";
		
	}
	
	@RequestMapping(value="/updateprofile",method=RequestMethod.POST)
	public String updateProfilePost(@ModelAttribute PersonCreator pc,HttpSession session) {
		
		
		Person p = personService.findById(pc.getId());
		p.setFirstName(pc.getFirstName());
		p.setLastName(pc.getLastName());
		p.setEmail(pc.getEmail());
		p.setPhone(pc.getPhone());
		
		
		
	
		
		Address address = p.getAddress();
		address.setCity(pc.getCity());
		address.setState(pc.getState());
		address.setCountry(pc.getCountry());
		address.setZipcode(pc.getZipcode());
		
		p.setAddress(address);	
		
		User user = userService.findByEmail(p.getEmail()).get(0);
		user.setPassword(pc.getPassword());
		
		System.out.println("person id: "+p.getId());
		System.out.println("address id: "+address.getId());
		
		
		
//		System.out.println("+++++++Person ID+++++"+pc.getId());
//		//Person prs = (Person) session.getAttribute("person");
//		 Person pp = personService.findById(pc.getId());
//		 System.out.println("/////"+pp.getFirstName());
//		Address address = pp.getAddress();
//		String email = pp.getEmail();
//		User user = userService.findByEmail(email).get(0);
//		
//		//Update profile related infor
//		pp.setFirstName(pc.getFirstName());
//		pp.setLastName(pc.getLastName());
//		pp.setPhone(pc.getPhone());
//		
//		address.setCity(pc.getCity());
//		address.setState(pc.getState());
//		address.setCountry(pc.getCountry());
//		address.setZipcode(pc.getZipcode());
//		
//		pp.setAddress(address);
//		
//		user.setPassword(pc.getPassword());
		
		session.setAttribute("person", p);
		
		return "user-page";
	}

}
