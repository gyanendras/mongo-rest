package com.cgi.sp.domain;

import java.time.LocalDate;


import java.util.Date;

import jakarta.persistence.*;



import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

//Hibernate is a ORM(Object relation mapping) tool. You have to import Hibernate Jars.

@Component
@Entity(name="Employees")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="employee_id")
	Long employeeId;
	
	@Column(name="first_name")
	String firstName;
	
	@Column(name="last_name")
	String lastName;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	@JsonBackReference
	Department department;
	
	@Column(name="email")
	String email;
	
	@Column(name="hire_date")
	LocalDate hireDate;
	
	@Column(name="job_id")
	String jobId;
	
	
	

	@Transient
	LocalDate dob;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	/*public Department getDept() {
		return department;
	}
*/
	public void setDept(Department department) {
		this.department = department;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getHireDate() {
		return hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

}
