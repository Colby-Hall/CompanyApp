package companyapp.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import companyapp.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CompanyAppController {

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button submitLogin;

	@FXML
	private DatePicker startDate;

	@FXML
	private DatePicker endDate;

	@FXML
	private Button submitDays;

	@FXML
	private TextField expenseType;

	@FXML
	private TextField expenseAmount;

	@FXML
	private Button submitExpense;

	@FXML
	private TextField test1;
	// tests expenses being added
	// lets people during demo know something is actually happening

	@FXML
	private TextField test2;
	// tests vacation being added
	// lets people during demo know something is actually happening


	@FXML
	private TextField test3;
	// test employees being created
	// lets people during demo know something is actually happening


	@FXML
	public void initialize(){
		expenseType.setEditable(false);
		expenseAmount.setEditable(false);


	}

	Employer business = new Employer("Acme");

	public void login() {
		String user = username.getText();
		Employee loginEmployee = new Employee(user);

		if (!business.getEmployee(loginEmployee)){
		business.addEmployee(loginEmployee);
		business.setCurrent(loginEmployee);
		}
		else {
			business.setCurrent(loginEmployee);
		}
		expenseType.setEditable(true);
		expenseAmount.setEditable(true);


		test3.setText(business.getCurrent().getName());

	}

	// https://stackoverflow.com/questions/33789307/converting-datepicker-to-string-in-java
	// DatePicker conversion taken from here

	public void calcVacation() {
		String begin = startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String end   = endDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		//LocalDate begin = startDate.getValue();
		//LocalDate end   = endDate.getValue();

		int numBegin = Integer.parseInt((begin.substring(begin.length() - 2)));
		int numEnd   = Integer.parseInt((end.substring(begin.length() - 2)));
		business.getCurrent().removeVacDays(numEnd - numBegin  + 1);
		test2.setText("Vacation: " + Integer.toString(numEnd - numBegin) + " days.");
	}

	public void incExpense() {
		String name = expenseType.getText();
		double money   = Double.parseDouble(expenseAmount.getText());
		business.getCurrent().addExpense(name, money);
		test1.setText(name + " : " + expenseAmount.getText());

	}
}
