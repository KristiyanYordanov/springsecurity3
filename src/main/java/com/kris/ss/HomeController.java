package com.kris.ss;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/")
	public String printWelcome(ModelMap model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "home";
 
	}
	
	@RequestMapping(value = "/home")
	public String home(ModelMap model, Principal principal ) {
		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");
		return "home";
 
	}
 
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/home1", method = RequestMethod.GET)
	public String home1(ModelMap model) {
		return "home1";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String register(ModelMap model) {
		return "register";
	}
	
	@RequestMapping(value="/accessdenied", method = RequestMethod.GET)
	public String accessdenied(ModelMap model) {
		return "accessdenied";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	
	@RequestMapping(value="/adminList", method = RequestMethod.GET)
	public String adminList(ModelMap model) {
		return "admin/adminList";
	}
	
	
	@RequestMapping(value="/userList", method = RequestMethod.GET)
	public String userList(ModelMap model) {
		return "user/userList";
	}
 
 
}
