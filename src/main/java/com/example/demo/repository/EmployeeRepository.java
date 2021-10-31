package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query(value="select * from employee where  departmentid =:departmentName",nativeQuery = true)
	List<Employee> findByDepartmentName(@Param("departmentName")long departmentName);
	
	@Query(value="select * from employee where full_name like %?1%",nativeQuery = true)
	List<Employee> searching(@Param("keySearch")String keySearch);
	
	@Query(value="select * from employee where end_date is not null ",nativeQuery = true)
	List<Employee> findActiveEmployeee();
	
}
