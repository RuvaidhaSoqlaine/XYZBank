package XYZBankAutomation.Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import XYZBankAutomation.PageObjects.AddCustomerPage;
import XYZBankAutomation.TestComponents.TestComponent;

public class AddCustomerTest extends TestComponent{

	@Test
	public void AddCustomer() throws IOException {
		
		launchApplication();
		
	}
}
