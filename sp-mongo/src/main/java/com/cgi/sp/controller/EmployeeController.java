package com.cgi.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.sp.domain.Employee;
import com.cgi.sp.services.IEmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	IEmployeeService er;

	@GetMapping("/employees")
	Iterable<Employee> getAllEmployee() {
		return er.getAllEmployee();

	}

}
