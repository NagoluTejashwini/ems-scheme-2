package com.capg.eis.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.capg.eis.bean.Employee;
import com.capg.eis.customDB.EmployeeDB;

public class EmployeeDAOImpl implements IEmployeeDAO{
HashMap<Employee, String> empList = EmployeeDB.empList;

public boolean insertEmployee(Employee e, String insuranceScheme){
	boolean isEmpInserted = EmployeeDB.addEmployee(e, insuranceScheme);
	empList = EmployeeDB.empList;
	return isEmpInserted;
}
public HashMap<Employee, String> getAllEmployees(){
	return empList;
}
public List<Employee> getAllEmployeesByScheme(String Scheme){
	List<Employee> tempList = new ArrayList<Employee>();
	tempList.clear();
	for(Map.Entry<Employee, String> pair: empList.entrySet()) {
		if(pair.getValue().equals(Scheme)) {
			tempList.add(pair.getKey());
		}
		
	}
	return tempList;
	
}
public List<Employee> doUpdate(String designation){
	List<Employee> tempList = new ArrayList<Employee>();
	tempList.clear();
	List<String> schemeList = new ArrayList<String>();
	for(Map.Entry<Employee,String> p : empList.entrySet()) {
		tempList.add(p.getKey());
		schemeList.add(p.getValue());
	}
	
	
	for(Employee e : tempList) {
		if((e.getDesignation()).equals(designation)) {
			e.setDesignation("Programmer");
			e.setSalary(30000);
			e.setInsuranceScheme("SchemeB");
		}
	}
	return tempList;
}

}
