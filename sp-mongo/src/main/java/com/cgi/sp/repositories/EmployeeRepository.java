package com.cgi.sp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cgi.sp.domain.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
