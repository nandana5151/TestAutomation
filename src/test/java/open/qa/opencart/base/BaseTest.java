package open.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.democart.factory.DriverFactory;
import com.qa.democart.pages.AccountsPage;
import com.qa.democart.pages.LoginPage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	public Properties prop;
	public LoginPage loginPage;
	public AccountsPage accountPage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_properties();
		driver = df.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
