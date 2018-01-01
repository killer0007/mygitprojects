package testCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginApp1 {
	WebDriver driver;
	@BeforeTest
	public void start() {
		System.setProperty("webdriver.firefox.marionette", "D:\\SELENIUM\\gekodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	@Test
	public void Login() {
		
		
	}

}
