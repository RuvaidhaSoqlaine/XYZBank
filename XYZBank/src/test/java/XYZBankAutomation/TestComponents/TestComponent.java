package XYZBankAutomation.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import XYZBankAutomation.PageObjects.HomePage;


public class TestComponent {
	public WebDriver driver;
	public HomePage homepage;
	
	public WebDriver initializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\XYZBankAutomation\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			//WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			// firefox
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Edge
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod
	public HomePage launchApplication() throws IOException {
		driver = initializeDriver();
		homepage = new HomePage(driver);
		homepage.goTo();
		return homepage;
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
