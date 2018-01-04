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

public class HandleAlert {
 AndroidDriver driver; 

 @BeforeTest
 public void setUp() throws Exception {
	 File app = new File("D:\\appium\\apkfiles\\softwaretest\\ApiDemos.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
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
 public void okOnAlert() {
  // Scroll till element which contains "App" text.
driver.scrollTo("App");
  // Click on App.
driver.findElement(By.name("App")).click();

  // Scroll till element which contains "Alert Dialogs" text.
driver.scrollTo("Alert Dialogs");
  // Click on Alert Dialogs.
driver.findElement(By.name("Alert Dialogs")).click();
  // Click on "OK Cancel dialog with a message" button.
driver.findElement(By.name("OK Cancel dialog with a message")).click();
  // Get the text from alert dialog.
String msg = driver.findElement(By.id("android:id/alertTitle")).getText();
System.out.println("The Alert MSG is -->" +msg);

  // Click on OK button of alert dialog.
driver.findElement(By.name("OK")).click();
  // Click on Cancel button of alert dialog.
  // driver.findElement(By.name("Cancel")).click();
 }

 @AfterTest
 public void End() {
  driver.quit();
 }
}