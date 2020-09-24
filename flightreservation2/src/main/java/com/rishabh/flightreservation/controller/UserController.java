package com.rishabh.flightreservation.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rishabh.flightreservation.entities.User;
import com.rishabh.flightreservation.repos.UserRepository;
import com.rishabh.flightreservation.services.SecurityServices;

import org.slf4j.Logger;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class); 
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired 
	private SecurityServices securityService;
	
	
	@RequestMapping("/showReg")
	public String showregistrationPage() {
		
		LOGGER.info("Inside show Registration Page()");
		
		return "login/registerUser";
	}
	
	@RequestMapping(value="/registerUser", method = RequestMethod.POST)
	public String register(@ModelAttribute("user") User user) {
		
		LOGGER.info("Inside {} Registration() "+user);
		
		user.setPassword(encoder.encode(user.getPassword()));
			
		userRepo.save(user);
		
		System.out.println(user);
		
		return "login/login";		
	}
	
	@RequestMapping("/showlogin")
	public String showLoginPage() {
		
		LOGGER.info("Inside showLoginPage()");
		
		return "login/login";
	}
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	
	public String login(@RequestParam("email")String email,@RequestParam("password")String password,ModelMap modelMap) {
		
		boolean loginResponse=securityService.login(email, password);	
		
		LOGGER.info("Inside login() and email is : "+email);
//		LOGGER.error("ERROR");
//		LOGGER.warn("WARN");
//		LOGGER.info("INFO");
//		LOGGER.debug("DEBUG");	
//		LOGGER.trace("TRACE");
		
		//User user=userRepo.findByEmail(email);
		
//		if(user.getPassword().equals(password)) {
//			return "findFlights";
		
		if(loginResponse) {
			
			return "findFlights";
		}
		else {
			modelMap.addAttribute("msg","Invalid username or password please try again.");	
		}
		return "login/login";
		
	}
	
	
	
	
}
