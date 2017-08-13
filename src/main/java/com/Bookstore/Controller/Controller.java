package com.Bookstore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

//Controller class
@org.springframework.stereotype.Controller
public class Controller {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/myAccount")
	public String myAccount() {
		return "myAccount";
	}

}
