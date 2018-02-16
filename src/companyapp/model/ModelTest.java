package companyapp.model;

import static org.junit.Assert.*;
import java.time.*;

import org.junit.Test;

public class ModelTest {

	@Test
	public void testEmployee() {
		Employee testEmployee = new Employee("Joe Smith");
		Employer testBusiness = new Employer("ACME Brick");
		testBusiness.addEmployee(testEmployee);
		assertEquals(true, testBusiness.getEmployee(testEmployee));
	}

	@Test
	public void testGetName() {
		Employee testEmployee = new Employee("Joe Smith");
		assertEquals("Joe Smith", testEmployee.getName());
	}
	@Test
	public void testEmployerGetName() {
		Employer testBusiness = new Employer("ACME Brick");
		assertEquals("ACME Brick", testBusiness.getName());

	}
	@Test
	public void testEmployerSetCurrentEmployee() {
		Employer testBusiness = new Employer("ACME Brick");
		Employee testEmployee = new Employee("Joe Smith");
		testBusiness.setCurrent(testEmployee);
		assertEquals(testEmployee, testBusiness.getCurrent());

	}
	@Test
	public void testEmployerGetCurrentEmployee() {
		Employer testBusiness = new Employer("ACME Brick");
		Employee testEmployee = new Employee("Joe Smith");
		testBusiness.setCurrent(testEmployee);
		assertEquals(testEmployee, testBusiness.getCurrent());
	}

	@Test
	public void testRemoveVacDays() {
		fail("Not yet implemented");

	}

	@Test
	public void testCheckVac() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVacDays() {
		Employee testEmployee = new Employee("Joe Smith");
		assertEquals(7, testEmployee.getVacDays());

	}

	@Test
	public void testAddVacation() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetVacation() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckExpense() {
		Employee testEmployee = new Employee("Joe Smith");
		assertEquals(false, testEmployee.checkExpense("50a"));
		assertEquals(true, testEmployee.checkExpense("50"));
	}

	// https://stackoverflow.com/questions/33274030/why-is-my-assertequals-deprecated-in-junit/33274105
	// info on dealing with doubles in JUnit tests

	@Test
	public void testAddExpense() {
		Employee testEmployee = new Employee("Joe Smith");
		testEmployee.addExpense("food", 10);
		testEmployee.addExpense("food", 10);
		assertEquals(20, testEmployee.getExpense("food"), 0);
	}

	@Test
	public void testGetExpense() {
		Employee testEmployee = new Employee("Joe Smith");
		testEmployee.addExpense("food", 10);
		assertEquals(10, testEmployee.getExpense("food"), 0);
	}

	@Test
	public void testGetAllExpenses() {

	}

	@Test
	public void testGetPassword() {
		Employee testEmployee = new Employee("Joe Smith");
		assertEquals("password", testEmployee.getPassword());

	}

}
