package controller;


import java.util.HashMap;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import model.Category;
import model.Product;
import service.CategoryService;
import service.ProductService;


 
@Controller
public class HomeController {

	@Autowired
	private CategoryService categoryService; 

	@Autowired
	private ProductService productService; 
	
    static ModelAndView modelViewObj;
	
	  @RequestMapping(value = {"/home", "/"}, method = RequestMethod.GET)
	    public String home(ModelMap map,  jakarta.servlet.http.HttpServletRequest request) 
	    {
		    HttpSession session = request.getSession();
			List<Product> list = productService.getAllProducts();
			
			// use MAP to map the category names to product rows
			 HashMap<Long, String> mapCats = new HashMap<Long, String>();
			  for(Product product: list) {
				  Category category = categoryService.getCategoryById(product.getCategoryId());
				  if (category != null)
					  mapCats.put(product.getID(), category.getName());
			  }
			  
			map.addAttribute("list", list);
			map.addAttribute("mapCats", mapCats);
		    map.addAttribute("pageTitle", "SPORTY SHOES - HOMEPAGE"); 
	        return "index"; 
	    }
	    
}

