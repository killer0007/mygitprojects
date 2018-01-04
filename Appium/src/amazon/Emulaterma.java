package amazon;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class Emulaterma {
	private static AndroidDriver driver;
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

//		File classpathRoot = new File(System.getProperty("user.dir"));
//		File appDir = new File(classpathRoot, "/Apps/Amazon/");
//		File app = new File(appDir, "in.amazon.mShop.android.shopping.apk");
		File app = new File("D:\\appium\\in.amazon.mShop.android.shopping.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Google Nexus 7");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
		capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		Thread.sleep(10000);
		driver.findElement(By.id("in.amazon.mShop.android.shopping:id/sign_in_button")).click();
//		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[159,295][642,352]']")).sendKeys("gopinathvijay7@gmail.com");
//		driver.findElement(By.xpath("//android.widget.EditText[@bounds='[159,356][642,413]']")).sendKeys("gopiNATHH007");
		//driver.findElement(By.className("android.widget.EditText")).click();
		//android.widget.EditText[@bounds='[159,295][642,352]']
		//android.widget.EditText[@bounds='[159,356][642,413]']
		driver.findElement(By.className("android.widget.Button")).click();
		
		//[159,501][642,556]
		//driver.quit();
}
}
