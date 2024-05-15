package XYZBankAutomation.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import XYZBankAutomation.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{

	
	// initialization local driver
	WebDriver driver;
	
	public HomePage(WebDriver driver) {

		super(driver);
		// initialization local driver to main driver
		this.driver = driver;
		// initializing all the webelements to this driver
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@ng-click='home()']")
	WebElement Home;
	
	@FindBy(xpath = "//button[@ng-click='customer()']")
	WebElement CustomerLogin;
	
	@FindBy(xpath = "//button[@ng-click='manager()']")
	WebElement BankManagerLogin;
	
	public void goTo() {
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}
	
	public void ClickBankManager() {
		BankManagerLogin.click();
	}
	
	public void ClickCustomer() {
		CustomerLogin.click();
	}

	
}
