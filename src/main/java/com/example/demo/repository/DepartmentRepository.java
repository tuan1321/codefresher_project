package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Department;


@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	@Query(value="select * from department where  id =:departmentCode",nativeQuery = true)
	Department findByDepartmentCode(@Param("departmentCode")long departmentCode);
}
