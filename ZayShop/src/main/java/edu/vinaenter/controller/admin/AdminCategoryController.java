package edu.vinaenter.controller.admin;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Category;
import edu.vinaenter.service.CatService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CAT)
public class AdminCategoryController {
	
	@Autowired
	 MessageSource messageSource;
	
	@Autowired
	private CatService catService;

	@GetMapping({URLConstant.INDEX, URLConstant.INDEX_PAGE })
	public String index(@ModelAttribute("search") String search,ModelMap model,
			@PathVariable(required = false) Integer page, Category category) {
		if(page == null) {
			page =1;
		}
		int offset = PageUtil.getOffset(page);
		
		//List<Category> catList = catService.getAll();
		List<Category> catList = catService.getAll(offset, GlobalConstant.TOTAL_ROW);
		List<Category> catListSearch = catService.findAllByNameOderByNewName(search);
		model.addAttribute("totalPage", PageUtil.getTotalPage(catService.totalRow()));
		if (!"".equals(search)) {

			model.addAttribute("catList", catListSearch);
			return "admin.cat.index";
		}
		model.addAttribute("currentPage", page);
		model.addAttribute("catList",catList);
		return "admin.cat.index";
	}

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap model) {
		return "admin.cat.add";
	}

	@GetMapping(URLConstant.EDIT+"/{cid}")
	public String edit(@PathVariable(value="cid") int cid, ModelMap model) {
		Category cat = catService.findByid(cid);
		model.addAttribute("cat", cat);
		return "admin.cat.edit"; 
	}
	@PostMapping(URLConstant.EDIT+"/{cid}")
	public String edit(@Valid @ModelAttribute("cat") Category cat,BindingResult rs, RedirectAttributes rd) {
		
		if(catService.update(cat) >0) {
			rd.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		
		return "admin.cat.edit";
	}


	@GetMapping(URLConstant.DELETE+"/{cid}")
	public String del(@PathVariable(value="cid") int cid, RedirectAttributes rd) {
		if(catService.del(cid) >0) {
			rd.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		rd.addFlashAttribute("err",messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.cat.index";
	}

	@PostMapping(URLConstant.ADD)
	public String cat(@Valid @ModelAttribute("cat") Category cat,BindingResult rs, RedirectAttributes rd) {
		if(rs.hasErrors()) {
			return "admin.cat.add";
		}
		if(catService.save(cat) >0) {
			rd.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/cat/index";
		}
		
		return "admin.cat.add";
	}

}
