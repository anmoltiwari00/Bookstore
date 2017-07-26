package com.Bookstore.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

//Controller class
@org.springframework.stereotype.Controller
@RequestMapping("/")
public class Controller {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
