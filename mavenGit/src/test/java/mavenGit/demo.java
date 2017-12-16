package mavenGit;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;

public class demo {
	WebDriver driver;
  @Test
  public void f() {
		driver.navigate().to("http://www.thetestroom.com/webapp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getCurrentUrl());
  }
  @BeforeTest
  public void beforeTest() {
		String geckoDriverPath = "D:\\SELENIUM\\gekodriver\\geckodriver-v0.19.1-win64\\geckodriver.exe";
		System.setProperty("webdriver.firefox.marionette", geckoDriverPath);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.privatebrowsing.autostart", true);

		driver = new FirefoxDriver();
	
  }

  @AfterTest
  public void afterTest() {
	  driver.close();
  }

}
