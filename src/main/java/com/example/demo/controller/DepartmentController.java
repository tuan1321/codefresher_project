package com.example.demo.controller;

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
import com.example.demo.service.DepartmentService;
import com.example.demo.service.EmployeeService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/department")
	public ModelAndView showAllDepartment(Model model) {
		ModelAndView view = new ModelAndView();
		List<Department> listResult = departmentService.getAllDepartment();
		model.addAttribute("list_department", listResult);
		view.setViewName("department");
		return view;
	}
	
	@GetMapping("/department/form")
	public ModelAndView formDepartment(Model model,@RequestParam(value = "id",required = false,defaultValue = "0")long id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("departmentForm");
		if(id !=0) {
			String message ="Cập nhật";
			model.addAttribute("tin_nhan",message);
			model.addAttribute("department",departmentService.getById(id));
		}else {
			String message ="Tạo mới";
			model.addAttribute("tin_nhan",message);
			model.addAttribute("department",new Department());
		}
		return modelAndView;
	}
	
	@GetMapping("/department/{departmentName}/employee")
	public ModelAndView formEmployeeByDepartment(Model model,@PathVariable(value = "departmentName")long departmentName) {
		ModelAndView view = new ModelAndView();
		view.setViewName("employee");
		
		List<Employee> listResult = employeeService.getAllEmployeeByDepartment(departmentName);
		model.addAttribute("list_employee", listResult);
		
		Department department = departmentService.findDepartment(departmentName);
		
		Long departName = department.getId();
		
		model.addAttribute("departName", departName);
		model.addAttribute("departmentName", departmentName);
		
		
		return view;
	}
	
//	@GetMapping("/employeeByDepartment/form/create")
//	public ModelAndView createEmployeeByDepartment(Model model,@RequestParam(value = "departmentName")String departmentName) {
//		ModelAndView view = new ModelAndView();
//		view.setViewName("employee");
//		List<Employee> listResult = employeeService.getAllEmployeeByDepartment(departmentName);
//		model.addAttribute("list_employee", listResult);
//		return view;
//	}
	
	@PostMapping("/department/save")
	public RedirectView saveDepartment(@RequestParam(value = "id",required = false,defaultValue = "0")long id,@RequestParam("departmentCode") String departmentCode,@RequestParam("departmentName") String departmentName,
			@RequestParam("description") String description, RedirectAttributes redirectAttributes) {
		
		Department depart ;
		if(id!=0) {
			depart = departmentService.getById(id);
		}else {
			depart =  new Department();
		}
		depart.setDepartmentCode(departmentCode);
		depart.setDepartmentName(departmentName);
		depart.setDescription(description);
		
		departmentService.addDepartment(depart);
		redirectAttributes.addFlashAttribute("test","Tạo thành công user : "+departmentName );
		return new RedirectView("/department",true);
	}
	
	@GetMapping("/department/delete")
	public RedirectView deleteDepartment(@RequestParam("id")long id) {
		departmentService.deleteDepartment(id);
		
		return new RedirectView("/department",true);
	}
}
