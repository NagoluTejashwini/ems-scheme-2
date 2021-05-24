package com.capg.eis.customDB;

import java.util.HashMap;

import com.capg.eis.bean.Employee;

public class EmployeeDB {
public static HashMap<Employee, String> empList = new HashMap<Employee, String>();

public static boolean addEmployee(Employee e, String insuranceScheme) {
	return empList.put(e, insuranceScheme) != null;
}
}
