package com.example.demo.controller;


import java.security.Principal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.UserService;



@Controller
public class DashboardController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private EmployeeService employeeService;
    
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		return view;
	}
	
	@GetMapping("/user")
	public ModelAndView user(Principal principal) {
		ModelAndView view = new ModelAndView();
		view.setViewName("user");
		String username = principal.getName();
		
		view.addObject("user", userService.findByUsername(username));
		return view;
	}
	
	@GetMapping("/user/update")
	public ModelAndView userUpdate(Principal principal) {
		ModelAndView view = new ModelAndView();
		view.setViewName("userForm");
		String username = principal.getName();
		
		view.addObject("user", userService.findByUsername(username));
		return view;
	}
	
	@PostMapping("/user/save")
	public RedirectView updateUserInfo(@RequestParam("username")String username,@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,@RequestParam("company")String company, @RequestParam("email")String email, @RequestParam("country")String country,
			@RequestParam("city")String city, @RequestParam("address")String address, @RequestParam("aboutMe")String aboutMe,
			RedirectAttributes redirectAttributes) {
		
		com.example.demo.model.User user = userService.findByUsername(username);

		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setCompany(company);
		user.setAddress(address);
		user.setCountry(country);
		user.setCity(city);
		user.setAboutMe(aboutMe);
		
		
		userService.addEmployee(user);
		return new RedirectView("/user",true);
	}
	
	@GetMapping("/dashboard")
	public ModelAndView dashboard(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("dashboard");
		
		List<Employee> employee = employeeService.getActiveEmployee();
		model.addAttribute("list_employee", employee);
		return view;
	}
	
}
