package edu.vinaenter.controller.admin;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Products;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.ProductsService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_NEWS)
public class AdminProductsController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	ProductsService productsService;

	@Autowired
	CatService catService;

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE })

	// offset = (page -1)*rowCount
	public String index(@ModelAttribute("search") String search, Model model,
			@PathVariable(required = false) Integer page, Products lands) {

		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);

		List<Products> productsList = productsService.getAll(offset, GlobalConstant.TOTAL_ROW);
		List<Products> productsListSearch = productsService.findAllByNameOderByNewName(search);
		model.addAttribute("totalPage", PageUtil.getTotalPage(productsService.totalRow()));
		if (!"".equals(search)) {

			model.addAttribute("productsList", productsListSearch);
			return "admin.news.index";
		}
		model.addAttribute("currentPage", page);
		model.addAttribute("productsList", productsList);
		return "admin.news.index";
	}

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("cat", catService.getAll());
		return "admin.news.add";
	}

	@PostMapping(URLConstant.ADD)
	public String cat(@Valid @ModelAttribute("lands") Products products,BindingResult rs, RedirectAttributes rd,
			@RequestParam("file") MultipartFile file, HttpServletRequest request, ModelMap modelMap) {
		String fileName = FileUtil.upload(file, request);
		products.setPicture(fileName);
		
		if(rs.hasErrors()) {
			modelMap.addAttribute("cat", catService.getAll());
			return "admin.news.add";
		}
		if (productsService.save(products) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}

		return "admin.news.add";
	}

	@GetMapping(URLConstant.EDIT + "/{pid}")
	public String edit(ModelMap modelMap, @PathVariable("pid") int pid) {
		Products products = productsService.findByid(pid);
		// System.out.println("ảnh: "+ lands.getPicture());
		modelMap.addAttribute("products", products);
		modelMap.addAttribute("cat", catService.getAll());
		return "admin.news.edit";
	}

	@PostMapping(URLConstant.EDIT + "/{pid}")
	public String edit(@ModelAttribute("products") Products products, BindingResult result, RedirectAttributes rd,
			ModelMap modelMap, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = FileUtil.upload(file, request);

		if (result.hasErrors()) {
			modelMap.addAttribute("cat", catService.getAll());
			return "admin.news.edit";
		}
		Products oldProduct = productsService.findByid(products.getPid());
		if (fileName.isEmpty()) {
			fileName = oldProduct.getPicture();

		}
		products.setPicture(fileName);

		if (productsService.update(products) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}
		return "admin.news.edit";
	}

	@GetMapping(URLConstant.DELETE + "/{pid}")
	public String del(@PathVariable int pid, RedirectAttributes rd) {
		if (productsService.del(pid) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}
		rd.addFlashAttribute("err", messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.news.index";
	}

}
