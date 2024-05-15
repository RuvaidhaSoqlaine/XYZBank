package XYZBankAutomation.AbstractComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class AbstractComponents {

	WebDriver driver;
	public FileInputStream read; 
	public FileOutputStream write;
	public XSSFWorkbook s;
	public XSSFSheet sheet;
	public XSSFCell cell;
	public String first_name;
	public String last_name;
	public String post_code;
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public void ReadDataFrom_Excel() throws IOException {
	read = new FileInputStream("C:\\Users\\RSOQLAIN\\Desktop\\XYZBank.xlsx");

	s = new XSSFWorkbook(read);

	sheet = s.getSheet("Sheet1");

	first_name = sheet.getRow(1).getCell(0).getStringCellValue();
	last_name = sheet.getRow(1).getCell(1).getStringCellValue();
	post_code = sheet.getRow(1).getCell(2).getStringCellValue();

	}

	public void createcellforMessage1() throws FileNotFoundException {
		cell = sheet.getRow(1).createCell(7);
		write = new FileOutputStream("C:\\Users\\RSOQLAIN\\Desktop\\XYZBank.xlsx");


	}
}
