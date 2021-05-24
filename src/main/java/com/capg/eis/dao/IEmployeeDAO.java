package com.capg.eis.dao;

import java.util.HashMap;
import java.util.List;

import com.capg.eis.bean.Employee;

public interface IEmployeeDAO {
	public boolean insertEmployee(Employee e, String scheme);
	public	HashMap<Employee, String> getAllEmployees();
	public List<Employee> getAllEmployeesByScheme(String Scheme);
	public List<Employee> doUpdate(String designation);
}
