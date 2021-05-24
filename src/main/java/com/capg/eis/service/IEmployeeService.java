package com.capg.eis.service;

import java.util.HashMap;
import java.util.List;

import com.capg.eis.bean.Employee;

public interface IEmployeeService {
	public boolean insertEmployee(Employee e, String scheme);
	public HashMap<Employee, String> getAllEmployees();
	public List<Employee> getAllEmployeesByScheme(String Scheme);
	public List<Employee> doUpdate(String designation);
}
