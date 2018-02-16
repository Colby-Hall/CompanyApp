package companyapp.model;

import static org.junit.Assert.*;
import java.time.*;
import java.util.ArrayList;
import java.util.Map;

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
		Employee testEmployee = new Employee("Joe Smith");
		LocalDate testBegin = LocalDate.of(2018, 2, 15);
		LocalDate testEnd = LocalDate.of(2018, 2, 17);
		testEmployee.removeVacDays(testBegin, testEnd);
		assertEquals(5, testEmployee.getVacDays());
	}

	@Test
	public void testCheckVac() {
		Employee testEmployee = new Employee("Joe Smith");
		LocalDate testBegin = LocalDate.of(2018, 2, 15);
		LocalDate testEnd = LocalDate.of(2018, 2, 17);
		LocalDate testEndBad = LocalDate.of(2018, 4, 17);
		assertEquals(true, testEmployee.checkVac(testBegin, testEnd));
		assertEquals(false, testEmployee.checkVac(testBegin, testEndBad));



	}

	@Test
	public void testGetVacDays() {
		Employee testEmployee = new Employee("Joe Smith");
		assertEquals(7, testEmployee.getVacDays());

	}

	@Test
	public void testAddVacation() {
		Employee testEmployee = new Employee("Joe Smith");
		testEmployee.addVacation("one", "two");
		ArrayList<String> vacList = testEmployee.getVacation();
		assertEquals(vacList.get(0), "one - two");


	}

	@Test
	public void testGetVacation() {
		Employee testEmployee = new Employee("Joe Smith");
		testEmployee.addVacation("one", "two");
		ArrayList<String> vacList = testEmployee.getVacation();
		assertEquals(vacList.get(0), "one - two");

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
		assertEquals(10, testEmployee.getExpense("food"), 10);
	}

	@Test
	public void testGetAllExpenses() {
		Employee testEmployee = new Employee("Joe Smith");
		testEmployee.addExpense("food", 10);
		Map<String, Double> testMap = testEmployee.getAllExpenses();
		assertEquals(Double.valueOf(10), testMap.get("food"));

	}

	@Test
	public void testGetPassword() {
		Employee testEmployee = new Employee("Joe Smith");
		assertEquals("password", testEmployee.getPassword());

	}

}
