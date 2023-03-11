package com.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Transactional
public class AccessDenied {

	@RequestMapping(value = {"/403" }, method = RequestMethod.GET)
	public String welcomePage(Model model) {
		return "/pages/403Page";
	}
}
