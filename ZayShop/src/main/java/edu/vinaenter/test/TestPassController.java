package edu.vinaenter.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestPassController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@ResponseBody
	@GetMapping("pass")
	public String index() {
		return bCryptPasswordEncoder.encode("12345");
	}

}
