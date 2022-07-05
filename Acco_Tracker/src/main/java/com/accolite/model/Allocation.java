package com.accolite.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "allocation")
public class Allocation {
    
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long allocationId;
	private int isActive = 1;
	private String projectId;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate = null;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifiedOn;
	private String modifiedBy;
	
	
	private String employeeId;
	
	
	private long clientId;
	
	
	public long getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(long allocationId) {
		this.allocationId = allocationId;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
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

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public long getClientId() {
		return clientId;
	}

	public void setClientId(long clientId) {
		this.clientId = clientId;
	}

	public Allocation(long allocationId, int isActive, String projectId, Date startDate, Date endDate, Date modifiedOn,
			String modifiedBy, String employeeId, long clientId) {
		super();
		this.allocationId = allocationId;
		this.isActive = isActive;
		this.projectId = projectId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.employeeId = employeeId;
		this.clientId = clientId;
	}

	public Allocation() {
		super();
	}
	
//	(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	
	
}
