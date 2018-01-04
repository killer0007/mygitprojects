package amazon;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class first {
	AppiumDriver driver;
	@Before

	public void testCaseSetup()throws Exception {
	   //service.start();
	   //reader.readFile();
		
	   DesiredCapabilities cap = new DesiredCapabilities();
		
	   cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	   cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");
	   cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
	   cap.setCapability(MobileCapabilityType.APP, "c://apk//sample.apk");
		
	//   driver = new AndroidDriver("http://127.0.0.1:4444/wd/hub",cap);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@Test
	public void testcase1()throws Exception {
	   driver.findElement(By.id("Example")).click();
	  // Assert.assertTrue(driver.findElement(By.id("Example")).isDisplayed));
	  driver.findElement(By.id("Example"));
	}

	@After
	public void testCaseTearDown() {
	   driver.quit();
	}
}
