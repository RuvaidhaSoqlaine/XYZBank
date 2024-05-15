package XYZBankAutomation.XYZBank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StandAloneTest {

	/**
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[@ng-click='addCust()']")).click();

		FileInputStream read = new FileInputStream("C:\\Users\\RSOQLAIN\\Desktop\\XYZBank.xlsx");

		XSSFWorkbook s = new XSSFWorkbook(read);

		XSSFSheet sheet = s.getSheet("Sheet1");

		String first_name = sheet.getRow(1).getCell(0).getStringCellValue();
		String last_name = sheet.getRow(1).getCell(1).getStringCellValue();
		String post_code = sheet.getRow(1).getCell(2).getStringCellValue();

		// s.close();

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys(first_name);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(last_name);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys(post_code);

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String Message = driver.switchTo().alert().getText();
		System.out.println(Message);

		// validate the text using assertions
		Assert.assertTrue(Message.equalsIgnoreCase("Customer added successfully with customer id :6"));

		// Writing data into excel

		XSSFCell cell = sheet.getRow(1).createCell(7);
		cell.setCellValue(Message);

//To write into already existing Excel File
		FileOutputStream write = new FileOutputStream("C:\\Users\\RSOQLAIN\\Desktop\\XYZBank.xlsx");
		s.write(write);

		//s.close();

		driver.switchTo().alert().accept();

		driver.findElement(By.xpath("//button[@ng-click='home()']")).click();
		driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();

		WebElement your_name = driver.findElement(By.id("userSelect"));
		Select dropdownYN = new Select(your_name);
		dropdownYN.selectByVisibleText("Ruvaidha Soqlaine U");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// uses.clickHome();

		driver.findElement(By.xpath("//button[@ng-click='home()']")).click();
		driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
		driver.findElement(By.xpath("//button[@ng-click='openAccount()']")).click();
		// select[@name='userSelect']
		WebElement customer_name = driver.findElement(By.id("userSelect"));
		Select dropdownCN = new Select(customer_name);
		dropdownCN.selectByVisibleText("Ruvaidha Soqlaine U");

		WebElement currency = driver.findElement(By.name("currency"));
		Select dropdownCR = new Select(currency);
		String cur=sheet.getRow(1).getCell(3).getStringCellValue();

		//dropdownCR.selectByVisibleText(cur);
		//or
		dropdownCR.selectByValue(cur);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String Message2 = driver.switchTo().alert().getText();
		System.out.println(Message2);

		Assert.assertTrue(Message2.equalsIgnoreCase("Account created successfully with account Number :1016"));

		XSSFCell cell2 = sheet.getRow(1).createCell(16);
		cell2.setCellValue(Message2);
		String[] Mes= Message2.split(":");
		String AcNo = Mes[1].trim();
		System.out.println(AcNo);
		
		FileOutputStream write2 = new FileOutputStream("C:\\Users\\RSOQLAIN\\Desktop\\XYZBank.xlsx");
		s.write(write2);
		//s.close();
		
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@ng-click='showCust()']")).click();		
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys(AcNo);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("./ScreenShot/.png"));
		
		driver.findElement(By.xpath("//button[@ng-click='home()']")).click();
		
		driver.findElement(By.xpath("//button[@ng-click='customer()']")).click();

		WebElement Cust_your_name = driver.findElement(By.id("userSelect"));
		Select Cust_dropdownYN = new Select(Cust_your_name);
		Cust_dropdownYN.selectByVisibleText("Ruvaidha Soqlaine U");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//button[@ng-click='deposit()']")).click();
		
		double Amount=sheet.getRow(1).getCell(4).getNumericCellValue();
		System.out.println(Amount);	
		String StringAmount= String.valueOf(Amount);
	
		driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(StringAmount);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		String Balance=driver.findElement(By.xpath("//strong[@class='ng-binding'] [2]")).getText();

		//Assert.assertTrue(Balance.contains("10"));
		
		driver.findElement(By.xpath("//button[@ng-click='withdrawl()']")).click();
		Thread.sleep(3000);
		double WithdrawAmount=sheet.getRow(1).getCell(5).getNumericCellValue();
		System.out.println(WithdrawAmount);	
		String StringWithdrawAmount= String.valueOf(WithdrawAmount);
	
		driver.findElement(By.xpath("//input[@ng-model='amount']")).sendKeys(StringWithdrawAmount);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String TransactionMsg= driver.findElement(By.xpath("//span[@ng-show='message']")).getText();
		Assert.assertTrue(TransactionMsg.contains("Transaction successful"));
		
		String NewBalance=driver.findElement(By.xpath("//strong[@class='ng-binding'] [2]")).getText();
		//Assert.assertTrue(NewBalance.contains(500));
		System.out.println(NewBalance);
		
		driver.findElement(By.xpath("//button[@ng-click='transactions()']")).click();
		Thread.sleep(3000);

		TakesScreenshot ts1=(TakesScreenshot)driver;
		File file1=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("./ScreenShot1/.png"));

	}

}
