package com.bridgelabz.employeepayrollapp.dto;

import java.sql.Date;

public class EmployeePayrollDTO {
	public String name;
	public String profilePic;
	public long salary;
	public String[] departments;
	public Date startDate;
	public String notes;
	public String gender;
	
	public EmployeePayrollDTO(String name,String profilePic, String gender, long salary,String[] departments, Date startDate, String notes) {
		super();
		this.name = name;
		this.profilePic = profilePic;
		this.gender = gender;
		this.salary = salary;
		this.departments = departments;
		this.startDate = startDate;
		this.notes = notes;
	}
}
