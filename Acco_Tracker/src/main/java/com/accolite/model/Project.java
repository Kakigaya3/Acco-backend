package com.accolite.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "project")
public class Project {

	@Id
	private String projectId;
	private String projectName;
	private String projectDepartment;
	private String projectLocation;
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "clientId", referencedColumnName = "clientId")
	private long clientId;
	
	private String clientSideManager;
	private int isActive;
	private String modifiedBy;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date modifiedOn;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
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
	public String getProjectLocation() {
		return projectLocation;
	}
	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientSideManager() {
		return clientSideManager;
	}
	public void setClientSideManager(String clientSideManager) {
		this.clientSideManager = clientSideManager;
	}
	public int getIsActive() {
		return isActive;
	}
	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public Date getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public Project(String projectId, String projectName, String projectDepartment, String projectLocation,
			long clientId, String clientSideManager, int isActive, String modifiedBy, Date modifiedOn) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDepartment = projectDepartment;
		this.projectLocation = projectLocation;
		this.clientId = clientId;
		this.clientSideManager = clientSideManager;
		this.isActive = isActive;
		this.modifiedBy = modifiedBy;
		this.modifiedOn = modifiedOn;
	}
	public Project() {
		super();
	}
	
	
	
	
	
	
}
