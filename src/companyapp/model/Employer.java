package companyapp.model;

import java.util.ArrayList;

public class Employer {

	private String name;
	private ArrayList<Employee> employees;
	private Employee currentEmployee;

	public Employer(String name) {
		this.name = name;
		this.employees = new ArrayList<Employee>();
	}

	public String getName() {
		return name;
	}

	public void addEmployee(Employee worker) {
		employees.add(worker);
	}

	public Boolean getEmployee(Employee checkedEmployee) {
		return employees.contains(checkedEmployee);
	}

	public Employee getCurrent() {
		return currentEmployee;
	}

	public void setCurrent(Employee current) {
		currentEmployee = current;

	}

}
