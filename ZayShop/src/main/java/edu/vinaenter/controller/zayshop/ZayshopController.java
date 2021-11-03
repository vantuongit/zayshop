package edu.vinaenter.controller.zayshop;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Category;
import edu.vinaenter.model.Products;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.service.ProductsService;
import edu.vinaenter.util.PageUtil;


@Controller
public class ZayshopController {
	
	@Autowired
	 MessageSource messageSource;
	
	@Autowired
	ProductsService ProductsService;
	
	@Autowired
	ContactService contactService;
	
	@Autowired
	CatService catService;
	
	@GetMapping({"", URLConstant.INDEX_PAGE })
	public String index(ModelMap model, Products Products) {
		List<Products> ProductsList = ProductsService.getAll(0, GlobalConstant.TOTAL_ROW);
		model.addAttribute("ProductsList", ProductsList);
		return "zayshop.index";
	}
	
	@GetMapping({"shop", URLConstant.SHOP_PAGE })
	public String shop(@ModelAttribute("search") String search, ModelMap model,@PathVariable(required = false) Integer page, Products products) {
		int offset = PageUtil.getOffset(page);
		List<Category> catList = catService.getAll();
		model.addAttribute("catList", catList);
		List<Products> productsList = ProductsService.getAll(offset, GlobalConstant.TOTAL_ROW);
		List<Products> listLandsSearch = ProductsService.findAllByNameOderByNewName(search);
		if(!"".equals(search)) {
			
			model.addAttribute("productsList", listLandsSearch);
			return "zayshop.shop";
		}
		model.addAttribute("productsList", productsList);
		model.addAttribute("totalPage", PageUtil.getTotalPage(ProductsService.totalRow()));
		model.addAttribute("currentPage", page);
		return "zayshop.shop";
	}
	

	@GetMapping("detail/{pid}")
	public String detail(@PathVariable(value="pid") int pid,@PathVariable(required = false) Integer page, ModelMap model, HttpSession session) {
		Products products =  ProductsService.findByid(pid);
		List<Products> productsList = ProductsService.getAllLimit(3);
		model.addAttribute("productsList", productsList);
		
		String hasVisited = (String) session.getAttribute("hasVisited: " + pid);
		if(hasVisited == null) {
			session.setAttribute("hasVisited: " + pid, "yes");
			session.setMaxInactiveInterval(3600); // thời gian reset session
			ProductsService.counterView(pid);
		}
		model.addAttribute("products", products);
		return "zayshop.detail";
	}
	
	@GetMapping(value = "contact")
	public String contact() {
		
		return "zayshop.contact";
	}
	@GetMapping(value = "about")
	public String about() {
		
		return "zayshop.about";
	}
}
