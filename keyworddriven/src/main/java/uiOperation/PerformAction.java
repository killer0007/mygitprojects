package uiOperation;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PerformAction {
	WebDriver driver;

	public PerformAction(WebDriver driver) {
		this.driver = driver;
	}

	public void perform(Properties p, String keyword, String objectName, String objectType, String value)
			throws Exception {
		switch (keyword.toLowerCase()) {
		case "click":
			driver.findElement(this.getobj(p, objectName, objectType)).click();
			break;
		case "gotourl":
			driver.get(p.getProperty(value));
			break;
		case "settext":
			driver.findElement(this.getobj(p, objectName, objectType)).sendKeys(value);
			break;
		}
	}

	private By getobj(Properties p, String objectName, String objectType) throws Exception {
		if (objectType.equalsIgnoreCase("XPATH")) {
			return By.xpath(p.getProperty(objectName));

		}

		else if (objectType.equalsIgnoreCase("CLASSNAME")) {
			return By.className(p.getProperty(objectName));

		} else if (objectType.equalsIgnoreCase("NAME")) {
			return By.name(p.getProperty(objectName));
		} else {
			throw new Exception("Wrong object type");
		}
	}
}
