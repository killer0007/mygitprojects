package operation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Perform {
	WebDriver driver;
	public Perform(WebDriver driver){
		this.driver = driver;
	}

public void performaction(String action, String ObjValue, String objtype,String value) throws Exception {
	if(action.equalsIgnoreCase("CLICK")) {
		driver.findElement(this.getObject(objtype,ObjValue)).click();
	}
	else if(action.equalsIgnoreCase("settext")) {
		driver.findElement(this.getObject(objtype,ObjValue)).sendKeys(value);
	}
	else if (action.equalsIgnoreCase("gotourl")) {
		driver.get(value);
	}
	else if(action.equalsIgnoreCase("gettext")) {
		driver.findElement(this.getObject(objtype,ObjValue)).getText();
	}
	else {
		throw new Exception("invalid action");
	}
	
	

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
