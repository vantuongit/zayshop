package edu.vinaenter.controller.admin;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Role;
import edu.vinaenter.model.User;
import edu.vinaenter.service.RoleService;
import edu.vinaenter.service.UserService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_USER)
public class AdminUserController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	UserService userService;

	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping({ URLConstant.INDEX, URLConstant.INDEX_PAGE })
	public String index(@ModelAttribute("search") String search, Model model,
			@PathVariable(required = false) Integer page, User user) {
		if (page == null) {
			page = 1;
		}
		int offset = PageUtil.getOffset(page);

		List<User> userList = userService.getAll(offset, GlobalConstant.TOTAL_ROW);
		List<User> userListSearch = userService.findAllByNameOderByNewName(search);
//		List<User> userList = userService.getAll();
		model.addAttribute("totalPage", PageUtil.getTotalPage(userService.totalRow()));
		
		if (!"".equals(search)) {

			model.addAttribute("userList", userListSearch);
			return "admin.user.index";
		}
		model.addAttribute("currentPage", page);
		model.addAttribute("userList", userList);
		return "admin.user.index";
	}

	@GetMapping(URLConstant.ADD)
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("role", roleService.getItem());
		return "admin.user.add";
	}

	@PostMapping(URLConstant.ADD)
	public String cat(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes rd,
			@RequestParam("role_id") int role_id, ModelMap modelMap) {
		user.setRole(new Role(role_id, null));
		if (result.hasErrors()) {
			modelMap.addAttribute("role", roleService.getItem());
			return "admin.user.add";
		}
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		
		if (userService.hasUser(user.getUsername())) {
			result.rejectValue("username", "usernameExisted");
	} 
		
		if (userService.save(user) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}

		return "admin.user.add";
	}

	@GetMapping(URLConstant.EDIT + "/{u_id}")
	public String edit(@PathVariable int u_id, ModelMap modelMap) {
		User user = userService.findByid(u_id);
		modelMap.addAttribute("user", user);
		List<Role> listRole = roleService.getItem();
		modelMap.addAttribute("role", listRole);
		return "admin.user.edit";
	}

	@PostMapping(URLConstant.EDIT + "/{u_id}")
	public String edit(@Valid @ModelAttribute("user") User user, BindingResult result, RedirectAttributes rd,
			@RequestParam("role_id") int role_id, ModelMap modelMap) {

		user.setRole(new Role(role_id, null));

		if (result.hasErrors()) {
			modelMap.addAttribute("role", roleService.getItem());
			return "admin.user.edit";
		}
		if (userService.update(user) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}

		return "admin.user.edit";
	}

	@GetMapping(URLConstant.DELETE + "/{u_id}")
	public String del(@PathVariable int u_id, RedirectAttributes rd) {
		if (userService.del(u_id) > 0) {
			rd.addFlashAttribute("msg", messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/user/index";
		}
		rd.addFlashAttribute("err", messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.news.index";
	}
}
