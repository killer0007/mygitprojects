package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class temp {
	
	public static void main (String [] arg) throws Exception {
		WebDriver driver;
		System.setProperty("webdriver.firefox.marionette","D:\\SELENIUM\\gekodriver\\geckodriver.exe");
		driver= new FirefoxDriver();
		temp t =new temp();
		System.out.println(t.getObject("name", "uid"));
		System.out.println(driver.findElement(t.getObject("name", "uid")));
//		driver.findElement(t.getObject("name", "uid"));
	}
	private By getObject(String objtype, String ObjValue) throws Exception {
		if (objtype.equalsIgnoreCase("xpath")) {
			return By.xpath(ObjValue);
		}
		else if(objtype.equalsIgnoreCase("name")) {
			return By.name(ObjValue);

		}
		else if(objtype.equalsIgnoreCase("classname")) {
			return By.className(ObjValue);

		}
		else if(objtype.equalsIgnoreCase("linktext")) {
			return By.linkText(ObjValue);

		}
		else if(objtype.equalsIgnoreCase("partialLinkText")) {
			return By.partialLinkText(ObjValue);

		}
		else if(objtype.equalsIgnoreCase("cssSelector")) {
			return By.cssSelector(ObjValue);

		}
		
		else {
			throw new Exception("Wrong object type");
		}
	}

}
