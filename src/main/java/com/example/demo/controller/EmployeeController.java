package com.example.demo.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.model.Position;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.PositionService;



@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private PositionService positionService;
	
	@GetMapping("/employee")
	public ModelAndView showEmployee(Model model) {
		ModelAndView view = new ModelAndView();
		List<Employee> listResult = employeeService.getAllEmployee();
		model.addAttribute("list_employee", listResult);
		String departName = "CÔNG TY";
		model.addAttribute("departName", departName);
		view.setViewName("employee");
		return view;
	}
	
	@GetMapping("/employee/{departmentName}/form")
	public ModelAndView formEmployee(Model model,@RequestParam(value = "id",required = false,defaultValue = "0")long id,@PathVariable(value = "departmentName")String departmentName) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employeeForm");
		//create an LocalDateTime object

	    if(id !=0) {
	    	
			String message ="Cập nhật";
			model.addAttribute("tin_nhan",message);
			model.addAttribute("employee",employeeService.getById(id));
			model.addAttribute("departmentName",departmentName);
			
			List<Department> department = departmentService.getAllDepartment();
			model.addAttribute("list_department", department);
			List<Position> position = positionService.getAllPosition();
			model.addAttribute("list_position", position);
		}else {
		    LocalDateTime lt = LocalDateTime.now();
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		    String curdate = lt.format(formatter);
		    model.addAttribute("curdate",curdate);
		    
			List<Department> department = departmentService.getAllDepartment();
			model.addAttribute("list_department", department);
			List<Position> position = positionService.getAllPosition();
			model.addAttribute("list_position", position);
			
			String message ="Tạo mới";
			model.addAttribute("tin_nhan",message);
			model.addAttribute("employee",new Employee());
		}
		return modelAndView;
	}
	
	@GetMapping("/department/{departmentName}/employee/create")
	public String createEmployee(Model model,@PathVariable(value = "departmentName")String departmentName) {
		//create an LocalDateTime object
	    LocalDateTime lt = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
	    String curdate = lt.format(formatter);
	    model.addAttribute("curdate",curdate);
		model.addAttribute("employee",new Employee());
		model.addAttribute("departmentName",departmentName);
		List<Department> department = departmentService.getAllDepartment();
		model.addAttribute("list_department", department);
		List<Position> position = positionService.getAllPosition();
		model.addAttribute("list_position", position);
		String message ="Tạo mới";
		model.addAttribute("tin_nhan",message);
		return "employeeForm";
	}
	
	@GetMapping("/employee/info")
	public ModelAndView infoEmployee(Model model,@RequestParam("id")long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("employeeInfo");
		model.addAttribute("employee",employeeService.getById(id));
		List<Department> department = departmentService.getAllDepartment();
		model.addAttribute("list_department", department);
		List<Position> position = positionService.getAllPosition();
		model.addAttribute("list_position", position);
		
		return modelAndView;
	}
	
	@PostMapping("/department/{departmentName}/employee/save")
	public RedirectView saveEmployee(@PathVariable(value = "departmentName")String departmentName,@RequestParam(value = "id",required = false,defaultValue = "0")long id,@RequestParam("fullName") String fullName,@RequestParam("dob") Date dob,
			@RequestParam("personalID") String personalID,@RequestParam("address") String address,@RequestParam("startDate") Date startDate,
			@RequestParam("educationalLevel") String educationalLevel,@RequestParam("englishLevel") String englishLevel,@RequestParam("informaticsLevel") String informaticsLevel,
			@RequestParam("workAchievement") String workAchievement, @RequestParam("departmentID") String departmentID,@RequestParam("positionID") String positionID, 
			RedirectAttributes redirectAttributes) {
		
		Employee employee ;
		if(id!=0) {
			employee = employeeService.getById(id);
		}else {
			employee =  new Employee();
		}
		employee.setFullName(fullName);
		employee.setDob(dob);
		employee.setPersonalID(personalID);
		employee.setAddress(address);
		employee.setStartDate(startDate);
		employee.setEducationalLevel(educationalLevel);
		employee.setEnglishLevel(englishLevel);
		employee.setInformaticsLevel(informaticsLevel);
		employee.setWorkAchievement(workAchievement);
		employee.setDepartmentID(departmentID);
		employee.setPositionID(positionID);
		System.out.println(positionID);
		
		employeeService.addEmployee(employee);
		redirectAttributes.addFlashAttribute("test","tạo thành công: "+fullName );
		return new RedirectView("/employee",true);
	}
	
	@PostMapping("/employee/save")
	public RedirectView updateEmployee(@RequestParam(value = "id",required = false,defaultValue = "0")long id,@RequestParam("fullName") String fullName,@RequestParam("dob") Date dob,
			@RequestParam("personalID") String personalID,@RequestParam("address") String address,@RequestParam("startDate") Date startDate,
			@RequestParam("educationalLevel") String educationalLevel,@RequestParam("englishLevel") String englishLevel,@RequestParam("informaticsLevel") String informaticsLevel,
			@RequestParam("workAchievement") String workAchievement,@RequestParam(value="departmentID",required = false) String departmentID,@RequestParam(value= "positionID",required = false) String positionID,
			RedirectAttributes redirectAttributes) {
		
		Employee employee ;
		if(id!=0) {
			employee = employeeService.getById(id);
		}else {
			employee =  new Employee();
		}
		employee.setFullName(fullName);
		employee.setDob(dob);
		employee.setPersonalID(personalID);
		employee.setAddress(address);
		employee.setStartDate(startDate);
		employee.setEducationalLevel(educationalLevel);
		employee.setEnglishLevel(englishLevel);
		employee.setInformaticsLevel(informaticsLevel);
		employee.setWorkAchievement(workAchievement);
		employee.setDepartmentID(departmentID);
		employee.setPositionID(positionID);
		
		
		
		employeeService.addEmployee(employee);
		return new RedirectView("/employee",true);
	}

	@PostMapping("/employee/fire")
	public RedirectView fireEmployee(Model model,@RequestParam("id")long id) {
		
		Employee employee ;
		employee = employeeService.getById(id);

	    LocalDateTime lt = LocalDateTime.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-dd");
	    String curdate = lt.format(formatter);
	    Date date = Date.valueOf(curdate);
	    System.out.println(date);
	    
		employee.setEndDate(date);
		employeeService.addEmployee(employee);
		return new RedirectView("/employee/info?id="+id,true);
	}
	
	@GetMapping("/employee/delete")
	public RedirectView deleteEmployee(@RequestParam("id")long id) {
		employeeService.deleteEmployee(id);
		
		return new RedirectView("/employee",true);
	}
	
	@GetMapping("/employee/searching")
	public ModelAndView searching(Model model, @RequestParam("keySearch")String keySearch) {
		ModelAndView view = new ModelAndView();
		view.setViewName("employee");
		List<Employee> employee = employeeService.searching(keySearch);
		model.addAttribute("list_employee", employee);
		return view;
	}
	
	@GetMapping("/employee/active")
	public ModelAndView getActiveEmployee(Model model) {
		ModelAndView view = new ModelAndView();
		view.setViewName("employee");
		List<Employee> employee = employeeService.getActiveEmployee();
		model.addAttribute("list_employee", employee);
		return view;
	}
}
