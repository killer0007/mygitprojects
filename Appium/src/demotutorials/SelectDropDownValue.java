package demotutorials;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SelectDropDownValue {
 AndroidDriver driver;

 @BeforeTest
 public void setUp() throws Exception {
  DesiredCapabilities capabilities = new DesiredCapabilities();
  File app = new File("D:\\appium\\apkfiles\\softwaretest\\ApiDemos.apk");

	capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	capabilities.setCapability("deviceName", "Google Nexus 7");
	capabilities.setCapability("platformVersion", "4.4.4");
	capabilities.setCapability("platformName", "Android");
	capabilities.setCapability("app", app.getAbsolutePath());
  capabilities.setCapability("appPackage", "io.appium.android.apis");
  capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

 @Test
 public void select() throws InterruptedException {
  // Scroll till element which contains "Views" text If It Is not visible on screen.
  driver.scrollTo("Views");
  // Click on Views.
  driver.findElement(By.name("Views")).click();
  // Scroll till element which contains "Controls" text If It Is not visible on screen.
  driver.scrollTo("Controls");
  // Click on Controls.
  driver.findElement(By.name("Controls")).click();
  // Scroll till element which contains "2. Dark Theme" text If It Is not visible on screen.
  driver.scrollTo("2. Dark Theme");
  // Click on 2. Dark Theme.
  driver.findElement(By.name("2. Dark Theme")).click();
  // Typing in text box using sendKeys command.
  driver.findElement(By.id("io.appium.android.apis:id/edit")).sendKeys("Test");
  //To hide keyboard. 
  driver.hideKeyboard();
 }

 @AfterTest
 public void End() {
  driver.quit();
 }
}