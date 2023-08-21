package com.cgi.sp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cgi.sp.domain.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
