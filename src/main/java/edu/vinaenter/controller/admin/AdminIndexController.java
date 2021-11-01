package edu.vinaenter.controller.admin;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.service.UserService;

@Controller
@RequestMapping(value = URLConstant.URL_ADMIN)
public class AdminIndexController {
	
	
	@Resource
	MessageSource messegeSource; 
	@Autowired
	CatService catService;
	
	@Autowired
	LandsService landsService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value = URLConstant.INDEX)
	public String index(ModelMap model) {
		model.addAttribute("totalCat",catService.totalRow() );
		model.addAttribute("totalLands",landsService.totalRow());
		model.addAttribute("totalUser",userService.totalRow());
		return "admin.index";
	}
	
}
