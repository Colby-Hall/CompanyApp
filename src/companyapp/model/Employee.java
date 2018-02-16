package companyapp.model;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Employee {

	private String name;
	private Map<String, Double> expenses = new HashMap<String, Double>();
	private int vacDays;
	private String password;

	public Employee(String name) {
		this.name     = name;
		this.vacDays  = 22;
		this.password = "password";
	}

	public String getName() {
		return name;
	}

	public void removeVacDays(int amount) {
		if (vacDays > amount) {
			vacDays -= amount;
		}
		else {
			vacDays = 0;
		}
	}

	public int getVacDays(){
		return vacDays;
	}

	public void addExpense(String purchaseName, double value) {
		expenses.put(purchaseName, value);
	}

	public double getExpenses(String purchaseName, double cost) {
		return expenses.get(purchaseName);
	}

	public String getPassword() {
		return password;
	}
/*
	public void changePassword(){
		Scanner input = new Scanner(System.in);
		System.out.println("enter an integer");
		String passwordAttempt = input.next();

		if (passwordAttempt == this.password) {
			String newPassword = input.next();
			this.password = newPassword;
			input.close();

		}
	}
*/
}
