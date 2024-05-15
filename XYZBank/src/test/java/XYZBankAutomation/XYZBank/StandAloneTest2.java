package XYZBankAutomation.XYZBank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StandAloneTest2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();






		WebElement your_name = driver.findElement(By.id("userSelect"));
		Select dropdownYN = new Select(your_name);
		dropdownYN.selectByVisibleText("Ruvaidha Soqlaine U");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// uses.clickHome();

		driver.findElement(By.xpath("//button[@ng-click='manager()']")).click();
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
