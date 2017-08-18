package com.Bookstore.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//Controller class
@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("loginActiveClass", true);
		return "myAccount";
	}
	
	@RequestMapping("/newAccount")
	public String newAccount(Model model) {
		model.addAttribute("newAccountClass", true);
		return "myAccount";
	}
	
	@RequestMapping("/ForgotPassword")
	public String forgotPassword(Model model) {
		model.addAttribute("forgetPasswordClass", true);
		return "myAccount";
	}
	

}
