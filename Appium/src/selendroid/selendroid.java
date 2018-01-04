package selendroid;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class selendroid {

		private static AndroidDriver driver;
		public static void main(String[] args) throws MalformedURLException, InterruptedException {

			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "/Apps/Amazon/");
			File app = new File(appDir, "selendroid-test-app-0.17.0.apk");
		
		//	String path = "C:\\Users\\gopin\\eclipse-workspace\\Appium\\Apps\\Amazon\\selendroid-test-app-0.17.0.apk";
//
			DesiredCapabilities capabilities = new DesiredCapabilities();
//			capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
			capabilities.setCapability("deviceName", "Google Nexus 7");
			capabilities.setCapability("platformVersion", "4.4.4");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("appPackage", "io.selendroid.testapp");
			capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");

			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
			Thread.sleep(2000);
			driver.findElement(By.id("io.selendroid.testapp:id/buttonTest")).click();
			System.out.println(driver.findElement(By.name("This will end the activity")).getText());
			selendroid se = new selendroid();
			se.takescreenshot();
			driver.findElement(By.name("I agree")).click();
			
						driver.quit();

	}
		public void takescreenshot() {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String dirFile = "screenshots";
			new File(dirFile).mkdirs();
			try {
				FileUtils.copyFile(scrFile, new File(dirFile +"/"+"mage1.png"));
				System.out.println(dirFile +"/"+"mage1.png");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

}