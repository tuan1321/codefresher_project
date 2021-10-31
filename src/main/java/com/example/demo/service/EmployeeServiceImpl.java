package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepository.save(employee);
	}

	@Override
	public boolean deleteEmployee(long id) {
		// TODO Auto-generated method stub
		if(getById(id) != null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Employee getById(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.getOne(id);
	}

	@Override
	public List<Employee> getAllEmployeeByDepartment(long departmentName) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartmentName(departmentName);
	}

	@Override
	public List<Employee> searching(String keySearch) {
		// TODO Auto-generated method stub
		return employeeRepository.searching(keySearch);
	}

	@Override
	public List<Employee> getActiveEmployee() {
		// TODO Auto-generated method stub
		return employeeRepository.findActiveEmployeee();
	}


}
