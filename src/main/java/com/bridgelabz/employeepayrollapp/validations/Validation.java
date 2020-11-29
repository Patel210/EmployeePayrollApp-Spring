package com.bridgelabz.employeepayrollapp.validations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.exception.InputException;
import com.bridgelabz.employeepayrollapp.exception.InputException.ExceptionType;

public class Validation {
	
	private static final String REGEX_NAME = "(^[A-Z]{1}[a-z]{2,}([\\s][A-Z]{1}[a-z]{2,})?$)";
	private EmployeePayrollDTO employeePayrollDTO;
	
	public Validation(EmployeePayrollDTO employeePayrollDTO) throws InputException {
		this.employeePayrollDTO = employeePayrollDTO;
		this.validate();
	}


	private void validate() throws InputException {
		String name = employeePayrollDTO.name;
		if (!name.matches(REGEX_NAME)) {
			throw new InputException("Invalid Name!", ExceptionType.INCORRECT_NAME);
		}
		
		String gender = employeePayrollDTO.gender;
		if (!(gender.equals("Male") || gender.equals("Female"))) {
			throw new InputException("Incorrect Gender!", ExceptionType.INCORRECT_GENDER);
		}
		
		Date startDate = employeePayrollDTO.startDate;
		Date now = new Date();
	    if (startDate.after(now)) {
	    	throw new InputException("Incorrect Date! Date Cannot Be A Future Date!", ExceptionType.INCORRECT_DATE);
	    }
	    long difference = Math.abs(now.getTime() - startDate.getTime());
	    if (difference / (1000 * 60 * 60 * 24) > 30) {
	    	throw new InputException("Start Date is beyond 30 Days!", ExceptionType.INCORRECT_DATE);
	    }
	    
	    String[] departments = employeePayrollDTO.departments;
	    String[] validDepartmentsArray = {"HR", "Sales", "Finance", "Engineer", "Others"};
	    List<String> validDepartmentsList = Arrays.asList(validDepartmentsArray);
	    for (String department : departments) {
	    	if (!validDepartmentsList.contains(department)) {
	    		throw new InputException("Invalid Department Added!", ExceptionType.INCORRECT_DEPARTMENT);
	    	}
	    }
	}
}
