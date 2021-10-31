package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}


	@Override
	public Department getById(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.getOne(id);
	}
	
	@Override
	public boolean deleteDepartment(long id) {
		// TODO Auto-generated method stub
		if(getById(id) != null) {
			departmentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Department findDepartment(long departmentCode) {
		// TODO Auto-generated method stub
		return departmentRepository.findByDepartmentCode(departmentCode);
	}
	
}
