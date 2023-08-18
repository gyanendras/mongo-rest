package com.cgi.sp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.sp.domain.Employee;
import com.cgi.sp.repositories.EmployeeRepository;

@Service
public class EmployeeSerivce implements IEmployeeService {
    
	@Autowired
	EmployeeRepository er;
	
	@Override
	public Iterable<Employee> getAllEmployee() {
		return er.findAll();
	}

}
