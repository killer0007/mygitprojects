package demotutorials;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CaptureScreenShot {
 AndroidDriver driver;
 Dimension size;
 String destDir;
 DateFormat dateFormat;

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
  capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

 @Test
 public void ScrollToTab() {
  // Scroll till element which contains "Views" text If It Is not visible on screen.
  driver.scrollTo("Views");
  // Click on Views.
  driver.findElement(By.name("Views")).click();
  // Scroll till element which contains "Tabs" text If It Is not visible on screen.
  driver.scrollTo("Tabs");
  //Call takeScreenShot() function to capture screenshot of android screen.
  takeScreenShot();

 }

 public void takeScreenShot() {
  // Set folder name to store screenshots.
  destDir = "screenshots";
  // Capture screenshot.
  File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
  // Set date format to set It as screenshot file name.
  dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
  // Create folder under project with name "screenshots" provided to destDir.
  new File(destDir).mkdirs();
  // Set file name using current date time.
  String destFile = dateFormat.format(new Date()) + ".png";

  try {
   // Copy paste file at destination folder location
   FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
   System.out.println(destDir + "/" + destFile);
  } catch (IOException e) {
   e.printStackTrace();
  }
 }

 @AfterTest
 public void End() {
  driver.quit();
 }
}