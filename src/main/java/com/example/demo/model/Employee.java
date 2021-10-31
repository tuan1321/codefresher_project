package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import java.sql.Date;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	// tên, năm sinh, số chứng minh thư, địa chỉ, ngày bắt đầu vào công ty, ngày nghỉ việc, trình độ văn hóa, ngoại ngữ, tin học, thành tích làm việc, thuộc phòng ban nào, chức vụ
	
	private String fullName;
	private Date dob;
	private String personalID;
	private String address;
	private Date startDate;
	@Column(name = "end_date",nullable = true)
	private Date endDate;
	private String educationalLevel;
	private String englishLevel;
	private String informaticsLevel;
	private String workAchievement;
	@Column(name = "departmentid",nullable = true)
	private String departmentID;
	@Column(name = "positionid",nullable = true)
	private String positionID;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(long id, String fullName, Date dob, String personalID, String address, Date startDate, Date endDate,
			String educationalLevel, String englishLevel, String informaticsLevel, String workAchievement,
			String departmentID, String positionID) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.personalID = personalID;
		this.address = address;
		this.startDate = startDate;
		this.endDate = endDate;
		this.educationalLevel = educationalLevel;
		this.englishLevel = englishLevel;
		this.informaticsLevel = informaticsLevel;
		this.workAchievement = workAchievement;
		this.departmentID = departmentID;
		this.positionID = positionID;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPersonalID() {
		return personalID;
	}

	public void setPersonalID(String personalID) {
		this.personalID = personalID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(String educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public String getEnglishLevel() {
		return englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	public String getInformaticsLevel() {
		return informaticsLevel;
	}

	public void setInformaticsLevel(String informaticsLevel) {
		this.informaticsLevel = informaticsLevel;
	}

	public String getWorkAchievement() {
		return workAchievement;
	}

	public void setWorkAchievement(String workAchievement) {
		this.workAchievement = workAchievement;
	}

	public String getDepartmentID() {
		return departmentID;
	}

	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	public String getPositionID() {
		return positionID;
	}

	public void setPositionID(String positionID) {
		// TODO Auto-generated method stub
		this.positionID = positionID;
	}

	
	
	
}
