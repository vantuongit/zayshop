package edu.vinaenter.controller.admin;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.vinaenter.constants.GlobalConstant;
import edu.vinaenter.constants.URLConstant;
import edu.vinaenter.model.Contact;
import edu.vinaenter.service.ContactService;
import edu.vinaenter.util.PageUtil;

@Controller
@RequestMapping(URLConstant.URL_ADMIN_CONTACT)
public class AdminContactController {
	@Autowired
	 MessageSource messageSource;
	
	@Autowired
	private ContactService contactService;
	
	@GetMapping({URLConstant.INDEX, URLConstant.INDEX_PAGE})
	public String index(@ModelAttribute("search") String search,ModelMap model,
			@PathVariable(required = false) Integer page,Contact contact) {
		
		int offset = PageUtil.getOffset(page);
		List<Contact> contactList = contactService.getAll(offset, GlobalConstant.TOTAL_ROW);
		List<Contact> contactListSearch = contactService.findAllByNameOderByNewName(search);
		model.addAttribute("totalPage", PageUtil.getTotalPage(contactService.totalRow()));
		if (!"".equals(search)) {

			model.addAttribute("contactList", contactListSearch);
			return "admin.contact.index";
		}
		model.addAttribute("currentPage", page);
		model.addAttribute("contactList", contactList);
		return "admin.contact.index";
	}
	
	@GetMapping(URLConstant.DELETE +"/{ct_id}")
	public String del(@PathVariable(value="ct_id") int ct_id, RedirectAttributes rd) {
		if(contactService.del(ct_id) > 0) {
			rd.addFlashAttribute("msg",messageSource.getMessage("msg.success", null, Locale.getDefault()));
			return "redirect:/admin/contact/index";
		}
		rd.addFlashAttribute("err",messageSource.getMessage("err.error", null, Locale.getDefault()));
		return "admin.contact.index";
	}

}
