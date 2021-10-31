package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	// tên phòng ban, mã phòng ban, mô tả về phòng ban.
	private String departmentCode;
	private String departmentName;
	private String description;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(long id, String departmentCode, String departmentName, String description) {
		super();
		this.id = id;
		this.departmentCode = departmentCode;
		this.departmentName = departmentName;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
