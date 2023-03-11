package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
public class HomeController {

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "/pages/home";
	}
}
