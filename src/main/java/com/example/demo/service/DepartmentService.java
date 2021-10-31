package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Department;

public interface DepartmentService {
	// lấy thông tin phòng ban
	List<Department> getAllDepartment();
	
	//	 Ø	Thêm
	Department addDepartment(Department department);
	
	//	 Ø Sửa
	Department findDepartment(long departmentCode);
	
	//	 Ø Xóa
	boolean deleteDepartment(long id);
	
	//get theo id
	Department getById(long id);
}
