package com.bridgelabz.employeepayrollapp.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;

@Entity
@Table(name = "employees")
public class EmployeePayrollData {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String profilePic;
	private String gender;
	private long salary;
	@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Department> departments;
	private String notes;
	private Date startDate;
	
	public EmployeePayrollData() {
		
	}

	public EmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		super();
		this.name = employeePayrollDTO.name;
		this.salary = employeePayrollDTO.salary;
		this.gender = employeePayrollDTO.gender;
		this.profilePic = employeePayrollDTO.profilePic;
		List<Department> departments = new ArrayList<Department>();
		for(String department : employeePayrollDTO.departments) {
			departments.add(new Department(department));
		}
		this.departments = departments;
		this.notes = employeePayrollDTO.notes;
		this.startDate = employeePayrollDTO.startDate;
	}

	public int getId() {
		return id;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public void setId(int employeeId) {
		this.id = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String[] getDepartments() {
		String array[] = new String[departments.size()];              
		for(int j =0;j<departments.size();j++){
		  array[j] = departments.get(j).getDepartmentName();
		}
		return array;
	}

	public void setDepartments(String[] departments) {
		List<Department> departmentList = new ArrayList<Department>();
		for(String department : departments) {
			departmentList.add(new Department(department));
		}
		this.departments = departmentList;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
