package com.capg.eis.pi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.capg.eis.service.IEmployeeService;
import com.capg.eis.service.IEmployeeServiceImpl;
import com.capg.eis.bean.Employee;


public class MainPIClass {
	Scanner sc;
	IEmployeeService empService;
	//Employee e = new Employee();
	public MainPIClass() {
		empService = new IEmployeeServiceImpl();
		sc = new Scanner(System.in);
	}
	public static void main(String[] args) {
		MainPIClass obj = new MainPIClass();
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		System.out.println("1.insertEmployeeInformation\n2.displayAllEmployees\n3.displayByScheme\n4.Update\n5.Exit");
		while(run) {
		System.out.println("Enter option");
		int option = Integer.parseInt(sc.nextLine());
		switch(option) {
		case 1:obj.insertEmployeeInforamtion();
				break;
		case 2:obj.displayAllEmployee();
				break;
		case 3:System.out.println("Enter Scheme: ");
			String scheme = sc.nextLine();
			obj.displaybyScheme(scheme);
			break;
		case 4:System.out.println("Enter Designation:");
				String designation = sc.nextLine();
				obj.doUpdate(designation);
				break;
		case 5:System.out.println("You have exited");
			run = false;
				break;
		default:System.out.println("select proper option");
		}
		}
		
		

		
	}
	public void insertEmployeeInforamtion()
	{
		System.out.println(" \n Enter Employee Informations \n");
		System.out.println(" Enter Employee Id ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Employee Name ");
		String empName = sc.nextLine();
		
		System.out.println(" Enter Employee Salary ");
		int salary = Integer.parseInt(sc.nextLine());
		
		System.out.println(" Enter Employee Designation ");
		String Designation = sc.nextLine();
		
		Employee e = new Employee(id, empName, salary, Designation);
		if(salary > 5000 && salary < 20000 && Designation.equals("System Associate")) {
			e.setInsuranceScheme("SchemeC");
			boolean isInserted = empService.insertEmployee(e, e.getInsuranceScheme());
		}
		else if(salary >= 20000 && salary < 40000 && Designation.equals("Programmer")) {
			boolean isInserted = empService.insertEmployee(e, "SchemeB");
		}
		else if(salary >= 40000 && Designation.equals("Manager")) {
			boolean isInserted = empService.insertEmployee(e, "SchemeA");
		}
		else if(salary < 5000 && Designation.equals("Clerk")) {
			boolean isInserted = empService.insertEmployee(e, "NoScheme");
		}
	}
	
	public void displayEmployee(Employee e)
	{
		System.out.println("ID: "+e.getId());
		System.out.println("Name: "+e.getName());
		System.out.println("Salary: "+e.getSalary());
		System.out.println("Designation: "+e.getDesignation());
		System.out.println("InsuranceScheme: "+e.getInsuranceScheme());
		System.out.println("\n---------------------------------------------\n");
		
		
	}
	public void displayAllEmployee()
	{

		System.out.println("\n=========== Employees Information ===========\n");
		HashMap<Employee, String> empList = empService.getAllEmployees();
		for(Map.Entry<Employee, String> pair: empList.entrySet()) {
			System.out.println("Employee details:"+pair.getKey());
		}
	}
	
	public void displaybyScheme(String scheme) {
		System.out.println("\n=========== Employees Information by Scheme ===========\n");
		List<Employee> empList = empService.getAllEmployeesByScheme(scheme);
		for (Employee employee : empList) {
			displayEmployee(employee);
		}
	}
	public void doUpdate(String designation) {
		System.out.println("====Updated information=====");
		List<Employee> empList = empService.doUpdate(designation);
		for(Employee e: empList) {
			displayEmployee(e);
		}
		
	}
	
	
/*>5000 and < 20000
System Associate
Scheme C
>=20000 and <40000
Programmer
Scheme B
>=40000
Manager
Scheme A
<5000 
Clerk
No Scheme

*/
}
