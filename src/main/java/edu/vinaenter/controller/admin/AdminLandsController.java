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
import edu.vinaenter.model.Lands;
import edu.vinaenter.service.CatService;
import edu.vinaenter.service.LandsService;
import edu.vinaenter.util.FileUtil;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_NEWS)
public class AdminLandsController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	LandsService landsService;

	@Autowired
	CatService catService;

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE })

	// offset = (page -1)*rowCount
	public String index(@ModelAttribute("search") String search, Model model,
			@PathVariable(required = false) Integer page, Lands lands) {

		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);

		List<Lands> landsList = landsService.getAll(offset, GlobalConstant.TOTAL_ROW);
		List<Lands> landsListSearch = landsService.findAllByNameOderByNewName(search);
		model.addAttribute("totalPage", PageUtil.getTotalPage(landsService.totalRow()));
		if (!"".equals(search)) {

			model.addAttribute("landsList", landsListSearch);
			return "admin.news.index";
		}
		model.addAttribute("currentPage", page);
		model.addAttribute("landsList", landsList);
		return "admin.news.index";
	}

	@GetMapping(URLConstant.ADD)
	public String add(ModelMap modelMap) {
		modelMap.addAttribute("cat", catService.getAll());
		return "admin.news.add";
	}

	@PostMapping(URLConstant.ADD)
	public String cat(@Valid @ModelAttribute("lands") Lands lands,BindingResult rs, RedirectAttributes rd,
			@RequestParam("file") MultipartFile file, HttpServletRequest request, ModelMap modelMap) {
		String fileName = FileUtil.upload(file, request);
		lands.setPicture(fileName);
		
		if(rs.hasErrors()) {
			modelMap.addAttribute("cat", catService.getAll());
			return "admin.news.add";
		}
		if (landsService.save(lands) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}

		return "admin.news.add";
	}

	@GetMapping(URLConstant.EDIT + "/{lid}")
	public String edit(ModelMap modelMap, @PathVariable("lid") int lid) {
		Lands lands = landsService.findByid(lid);
		// System.out.println("ảnh: "+ lands.getPicture());
		modelMap.addAttribute("lands", lands);
		modelMap.addAttribute("cat", catService.getAll());
		return "admin.news.edit";
	}

	@PostMapping(URLConstant.EDIT + "/{lid}")
	public String edit(@ModelAttribute("lands") Lands lands, BindingResult result, RedirectAttributes rd,
			ModelMap modelMap, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String fileName = FileUtil.upload(file, request);

		if (result.hasErrors()) {
			modelMap.addAttribute("cat", catService.getAll());
			return "admin.news.edit";
		}
		Lands oldLand = landsService.findByid(lands.getLid());
		if (fileName.isEmpty()) {
			fileName = oldLand.getPicture();

		}
		lands.setPicture(fileName);

		if (landsService.update(lands) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}
		return "admin.news.edit";
	}

	@GetMapping(URLConstant.DELETE + "/{lid}")
	public String del(@PathVariable int lid, RedirectAttributes rd) {
		if (landsService.del(lid) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/news/index";
		}
		rd.addFlashAttribute("err", messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.news.index";
	}

}
