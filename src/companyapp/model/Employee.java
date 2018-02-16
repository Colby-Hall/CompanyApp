package companyapp.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Employee {

	private String name;
	private Map<String, Double> expenses = new HashMap<String, Double>();
	private ArrayList<String> vacation = new ArrayList<String>();
	private long vacDays;
	private String password;

	public Employee(String name) {
		this.name = name;
		this.vacDays = 7;
		this.password = "password";
	}

	public String getName() {
		return name;
	}

	public void removeVacDays(LocalDate begin, LocalDate end) {
		vacDays -= ChronoUnit.DAYS.between(begin, end);
	}

	public Boolean checkVac(LocalDate begin, LocalDate end){
		long days = ChronoUnit.DAYS.between(begin, end);
		if (days + 1 <= vacDays) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getVacDays() {
		return vacDays;
	}

	public void addVacation(String vacStart, String vacEnd) {
		vacation.add(vacStart + " - " + vacEnd);
	}

	public ArrayList<String> getVacation() {
		return vacation;
	}

	public Boolean checkExpense(String cash) {
		for (int i = 0; i < cash.length(); i++){
			if (Character.isAlphabetic(cash.charAt(i))) {
				return false;
				}
		}
		return true;
	}

	public void addExpense(String purchaseName, double value) {
		if (expenses.containsKey(purchaseName)) {
			expenses.put(purchaseName, value + expenses.get(purchaseName));
		} else {
			expenses.put(purchaseName, value);
		}
	}

	public double getExpense(String purchaseName) {
		return expenses.get(purchaseName);
	}

	public Map<String, Double> getAllExpenses() {
		return expenses;
	}

	public String getPassword() {
		return this.password;
	}
}

