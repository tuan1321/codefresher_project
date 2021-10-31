package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Employee;

public interface EmployeeService {
		// lấy thông tin theo mã phòng ban phòng ban
		List<Employee> getAllEmployeeByDepartment(long departmentName);
		
		// lấy thông tin 
		List<Employee> getAllEmployee();
		
		//	 Ø	Thêm
		Employee addEmployee(Employee employee);
		
		//	 Ø Sửa
		Employee updateEmployee(Employee employee);
		
		//	 Ø Xóa
		boolean deleteEmployee(long id);
		
		//get theo id
		Employee getById(long id);
		
		//searching
		List<Employee> searching(String keySearch);
		
		// 
		List<Employee> getActiveEmployee();
			

}
