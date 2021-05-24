package com.capg.eis.service;

import com.capg.eis.dao.IEmployeeDAO;

import java.util.HashMap;
import java.util.List;

import com.capg.eis.bean.Employee;
import com.capg.eis.dao.EmployeeDAOImpl;

public class IEmployeeServiceImpl implements IEmployeeService{
	IEmployeeDAO dao;
	public IEmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
		// Animal a = new Dog();
	}
	public boolean insertEmployee(Employee e, String scheme) {
		boolean isInserted = dao.insertEmployee(e, scheme);
		return isInserted;
	}
public HashMap<Employee, String> getAllEmployees() {
		
		return dao.getAllEmployees();
	}
public List<Employee> getAllEmployeesByScheme(String scheme) {
	
	return dao.getAllEmployeesByScheme(scheme);
}
public List<Employee> doUpdate(String designation){
	return dao.doUpdate(designation);
}

}
