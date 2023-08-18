package com.cgi.sp.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity(name = "Departments")
public class Department {
	@Id
	@Column(name = "department_id")
	int departmentId ;
	
	@Column(name = "department_name")
	String departmentName;
	
	@OneToMany(mappedBy="department")
	@JsonManagedReference
	List<Employee> empOfDeptt;

	public Department() {
		super();
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public List<Employee> getEmpOfDeptt() {
		return empOfDeptt;
	}

	public void setEmpOfDeptt(List<Employee> empOfDeptt) {
		this.empOfDeptt = empOfDeptt;
	}	
	
	

}
