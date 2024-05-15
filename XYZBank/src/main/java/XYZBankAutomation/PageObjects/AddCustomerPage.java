package XYZBankAutomation.PageObjects;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import XYZBankAutomation.AbstractComponents.AbstractComponents;

public class AddCustomerPage extends AbstractComponents {

	public AddCustomerPage(WebDriver driver) {
		super(driver);

		// initialization local driver to main driver
		this.driver = driver;
		// initializing all the webelements to this driver
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	WebDriver driver;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstname;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastname;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postcode;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submit_addcustomer;

	String Message;

	public void AddCustomerDetails() throws IOException {
		firstname.sendKeys(first_name);
		lastname.sendKeys(last_name);
		postcode.sendKeys(post_code);
		submit_addcustomer.click();

	}

	public void Message() {
		
		Message = driver.switchTo().alert().getText();
		System.out.println(Message);
		Assert.assertTrue(Message.equalsIgnoreCase("Customer added successfully with customer id :6"));
	}

	public void writedatainto_Excel() throws IOException {
		
		cell.setCellValue(Message);
		s.write(write);
		driver.switchTo().alert().accept();

		// s.close();
	}

}
