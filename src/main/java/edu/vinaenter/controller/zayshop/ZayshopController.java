package edu.vinaenter.controller.zayshop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ZayshopController {
	
	
	@GetMapping(value ="")
	public String index() {
		
		return "zayshop.index";
	}
	
	@GetMapping(value = "shop")
	public String shop() {
		
		return "zayshop.shop";
	}
	
	@GetMapping(value = "detail")
	public String detail() {
		
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
