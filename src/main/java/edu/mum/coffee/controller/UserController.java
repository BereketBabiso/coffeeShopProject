package edu.mum.coffee.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.request.RequestContextHolder;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.domain.ProductType;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;

@Controller
public class UserController {
	
	@Resource
	private PersonService personService;
	@Resource
	private ProductService productService;
	
	
	@RequestMapping(value="/placeOrder")
	public String placeOrder(Model productModel,HttpSession session) {
		List<Product> products = new ArrayList<>();
//		products = productService.getAllProduct();
//		productModel.addAttribute("products", products);
		
		Person prs = (Person) session.getAttribute("person");
		
		System.out.println(">>>>>User Name in the User controller: "+prs.getFirstName());
		
		
		Product p1 = new Product("Piza","small",10,ProductType.LUNCH);
		Product p2 = new Product("Piza","large",10,ProductType.LUNCH);
		Product p3 = new Product("Margarita","medium",10,ProductType.LUNCH);
		
		products.add(p1);
		products.add(p2);
		products.add(p3);
		
		productModel.addAttribute("products", products);
		return "placeOrder";
	}
	
	@RequestMapping(value="/placeOrder", method=RequestMethod.POST)
	public String saveOrder(@RequestParam("productname") String productname,
			@RequestParam("desciption") String desciption,@RequestParam("quantity") String quantity, HttpSession session) {
//		int qty = Integer.parseInt(quantity);
//		List<Product> products = productService.getAllProduct();
//		Product p = null;
//		for(Product prd : products ) {
//			if(prd.getProductName().equals(productname) && prd.getDescription().equals(desciption)) {
//				p=prd;
//				break;
//			}
//		}
		
        Person prs = (Person) session.getAttribute("person");
		
		System.out.println(">>>>>User Name in the User controller: "+prs.getFirstName());
		
		return "redirect:/placeOrder";
	}

}
