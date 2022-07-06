package com.accolite.model;

import java.util.Date;

public class AllocationDto {

	private int isActive;
    private String projectId;
    private Date startDate;
    private Date endDate;
    private Date modifiedOn;
    private String modifiedBy;
    private String employeeId;
    private int clientId;
    
    
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
	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public AllocationDto(int isActive, String projectId, Date startDate, Date endDate, Date modifiedOn,
			String modifiedBy, String employeeId, int clientId) {
		super();
		this.isActive = isActive;
		this.projectId = projectId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.modifiedOn = modifiedOn;
		this.modifiedBy = modifiedBy;
		this.employeeId = employeeId;
		this.clientId = clientId;
	}
	public AllocationDto() {
		super();
	}
    
    
}
