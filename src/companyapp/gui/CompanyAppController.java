package companyapp.gui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import companyapp.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CompanyAppController {

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button submitLogin;

	// https://gjf2a.blogspot.com/2015/01/javafx-observablelist.html
	// All ObservableList and ListView code taken from this post
	@FXML
	private ListView<String> currentUser;

	@FXML
	private ObservableList<String> name = FXCollections.observableArrayList();

	@FXML
	private ListView<String> vacations;

	@FXML
	private ObservableList<String> vacPeriod = FXCollections.observableArrayList();

	@FXML
	private ListView<Map> expenseList;

	@FXML
	private ObservableList<Map> showExpenses = FXCollections.observableArrayList();

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
	public void initialize() {
		currentUser.setItems(name);
		vacations.setItems(vacPeriod);
		expenseList.setItems(showExpenses);
		expenseType.setEditable(false);
		expenseAmount.setEditable(false);
		submitDays.setDisable(true);
		submitExpense.setDisable(true);

	}

	Employer business = new Employer("Acme");

	public void login() {
		String enteredName = username.getText();
		String enteredPassword = password.getText();
		Employee loginEmployee = new Employee(enteredName);

		if (enteredPassword.equals(loginEmployee.getPassword())) {

			if (!business.getEmployee(loginEmployee)) {
				business.addEmployee(loginEmployee);
				business.setCurrent(loginEmployee);
			}

			else {
				business.setCurrent(loginEmployee);
			}
			name.clear();
			name.add(business.getCurrent().getName());
			username.clear();
			password.clear();
			expenseType.setEditable(true);
			expenseAmount.setEditable(true);
			submitDays.setDisable(false);
			submitExpense.setDisable(false);

		} else {
			// http://code.makery.ch/blog/javafx-dialogs-official/
			// Error box reference

			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Invalid Login Info");
			alert.showAndWait();

		}
	}

	// https://stackoverflow.com/questions/33789307/converting-datepicker-to-string-in-java
	// DatePicker conversion taken from here

	public void calcVacation() {

		LocalDate begin = startDate.getValue();
		LocalDate end = endDate.getValue();



		String beginString = startDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		String endString = endDate.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		if (business.getCurrent().checkVac(begin, end)) {
			business.getCurrent().removeVacDays(begin, end);
			business.getCurrent().addVacation(beginString, endString);
			vacPeriod.clear();
			vacPeriod.addAll(business.getCurrent().getVacation());
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Invalid Date Selection");
			alert.showAndWait();
		}
	}

	public void incExpense() {
		String name = expenseType.getText();
		String money = expenseAmount.getText();
		if (business.getCurrent().checkExpense(money)) {
			double expense = Double.parseDouble(expenseAmount.getText());
			business.getCurrent().addExpense(name, expense);
			showExpenses.clear();
			showExpenses.addAll(business.getCurrent().getAllExpenses());
		} else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setContentText("Invalid Expense Format");
			alert.showAndWait();
		}

	}
}
