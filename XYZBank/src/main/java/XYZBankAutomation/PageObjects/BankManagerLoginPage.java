package XYZBankAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@ng-click='addCust()']")
	WebElement AddCustomer;
	
	@FindBy(xpath = "//button[@ng-click='openAccount()']")
	WebElement OpenAccount;
	
	@FindBy(xpath = "//button[@ng-click='showCust()']")
	WebElement Customers;
	
	public void ClickAddCustomer() {
		AddCustomer.click();
	}
	
	public void ClickOpenAccount() {
		OpenAccount.click();
	}
	
	public void ClickCustomers() {
		Customers.click();
	}
}
