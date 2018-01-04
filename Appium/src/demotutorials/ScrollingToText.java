package demotutorials;

import io.appium.java_client.android.AndroidDriver;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScrollingToText {
 AndroidDriver driver;

 @BeforeTest
 public void setUp() throws Exception {
  DesiredCapabilities capabilities = new DesiredCapabilities();
  capabilities.setCapability("deviceName", "ZX1B32FFXF");
  capabilities.setCapability("browserName", "Android");
  capabilities.setCapability("platformVersion", "4.4.2");
  capabilities.setCapability("platformName", "Android");
  capabilities.setCapability("appPackage", "io.appium.android.apis");
  capabilities.setCapability("appActivity","io.appium.android.apis.ApiDemos");
  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
 }

 @Test
 public void ScrollToText() throws InterruptedException {
  //Scroll till element which contains "Views" text If It Is not visible on screen.
  driver.scrollTo("Views");
  // Click on Views/.
  driver.findElement(By.name("Views")).click();
  System.out.println("Scrolling has been started to find text -> Tabs.");
  // Scroll till element which contains Tabs text.
  driver.scrollTo("Tabs");
  System.out.println("Tabs text has been found and now clicking on It.");
  // Click on Tabs.
  driver.findElement(By.name("Tabs")).click();
 }

 @AfterTest
 public void End() {
  driver.quit();
 }
}