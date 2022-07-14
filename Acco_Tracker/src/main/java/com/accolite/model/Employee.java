package com.accolite.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "employee")
public class Employee {
     
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long sno;
	private long employeeId;
	private String employeeName;
	private String employeeEmail;
	private String techStack;
	private long years;
	@Max(value = 12)
	private long months;
	public String status = "active";
	private String modifiedBy;
	private LocalDateTime modifiedOn;
	
	public Employee() {
		super();
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getTechStack() {
		return techStack;
	}

	public void setTechStack(String techStack) {
		this.techStack = techStack;
	}

	public long getYears() {
		return years;
	}

	public void setYears(long years) {
		this.years = years;
	}

	public long getMonths() {
		return months;
	}

	public void setMonths(long months) {
		this.months = months;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public LocalDateTime getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(LocalDateTime modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Employee(long employeeId, String employeeName, String employeeEmail, String techStack, long years,
			long months, String status, String modifiedBy, LocalDateTime modifiedOn) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.techStack = techStack;
		this.years = years;
		this.months = months;
		this.status = status;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}	
}
