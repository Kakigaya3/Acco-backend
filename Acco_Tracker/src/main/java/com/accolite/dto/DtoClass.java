package com.accolite.dto;

public class DtoClass {

	
	private String employeeId;
	private String employeeName;
	private String employeeEmail;
	private String projectName;
    private String projectDepartment;
    private String clientName;
    private String projectLocation;
    private int isActive;
    
    public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
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
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDepartment() {
		return projectDepartment;
	}
	public void setProjectDepartment(String projectDepartment) {
		this.projectDepartment = projectDepartment;
	}
	public String getClientName() {
		return clientName;
	}
	public void setclientName(String clientName) {
		this.clientName = clientName;
	}
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	
	public DtoClass(String employeeId, String employeeName, String employeeEmail, String projectName,
			String projectDepartment, String clientName, String projectLocation, int isActive) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.projectName = projectName;
		this.projectDepartment = projectDepartment;
		this.clientName = clientName;
		this.projectLocation = projectLocation;
		this.isActive = isActive;
	}
	public DtoClass() {
		super();
	}	
	
}
