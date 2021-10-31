package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "position")
public class Position {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	//tên chức vụ, mã chức vụ, mô tả về chức vụ
	private String positionName;
	private String positionCode;
	private String description;
	
	public Position() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Position(long id, String positionName, String positionCode, String description) {
		super();
		this.id = id;
		this.positionName = positionName;
		this.positionCode = positionCode;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(String positionCode) {
		this.positionCode = positionCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
