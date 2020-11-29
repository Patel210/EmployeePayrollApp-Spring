package com.bridgelabz.employeepayrollapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayrollDataRepository;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
	
	@Autowired
	private EmployeePayrollDataRepository employeePayrollRepository;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {
		return (List<EmployeePayrollData>) employeePayrollRepository.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int employeeId) {
		return employeePayrollRepository.findById(employeeId).get();
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = null;
		employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
		employeePayrollRepository.save(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
		EmployeePayrollData employeePayrollData = this.getEmployeePayrollDataById(employeeId);
		employeePayrollData.setName(employeePayrollDTO.name);
		employeePayrollData.setSalary(employeePayrollDTO.salary);
		employeePayrollData.setGender(employeePayrollDTO.gender);
		employeePayrollData.setDepartments(employeePayrollDTO.departments);
		employeePayrollData.setNotes(employeePayrollDTO.notes);
		employeePayrollData.setProfilePic(employeePayrollDTO.profilePic);
		employeePayrollData.setStartDate(employeePayrollDTO.startDate);
		employeePayrollRepository.save(employeePayrollData);
		return employeePayrollData;
	}

	@Override
	public void deleteEmployeePayrollData(int employeeId) {
		employeePayrollRepository.deleteById(employeeId);
	}

}
