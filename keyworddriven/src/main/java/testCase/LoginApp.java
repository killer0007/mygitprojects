package testCase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataEngine.Exceldata;
import uiOperation.PerformAction;
import uiOperation.Repository;

public class LoginApp {
	WebDriver driver;

	@BeforeTest(enabled = true)
	public void start() {
		String driverpath = "C:\\Users\\gopin\\git\\keyworddriven\\src\\main\\java\\driver\\geckodriver.exe";
		System.setProperty("webdriver.firefox.marionette", driverpath);
		driver = new FirefoxDriver();

	}

	@Test(enabled = true)
	public void login() throws Exception {
		Exceldata excel = new Exceldata();
		List<List<String>> data1 = new ArrayList<List<String>>();
		data1 = excel.getexceldata("datamain.xls", "Sheet1");
		System.out.println(data1);
		Repository object = new Repository();
		Properties allobject = object.getrepo();
		// System.out.println(allobject.getProperty("url"));
		PerformAction action = new PerformAction(driver);
		// action.perform(p, keyword, objectName, objectType, value);
		for (int i = 0; i < data1.size(); i++) {
			if (data1.get(i).get(0) == null) {
				// data1.get(i).get(1),data1.get(i).get(2),data1.get(i).get(3),data1.get(i).get(4)
				action.perform(allobject, data1.get(i).get(1), data1.get(i).get(2), data1.get(i).get(3),data1.get(i).get(4));
				//System.out.println(allobject+"-"+data1.get(i).get(1)+"-"+data1.get(i).get(2)+"-"+data1.get(i).get(3)+"-"+data1.get(i).get(4));
				Thread.sleep(1000);
				continue;
			}

		}
		// action.perform(allobject, "gotourl", null, null, "url");
		Assert.assertEquals("Guru99 Bank Manager HomePage",driver.getTitle());
	}

	@AfterTest(enabled = false)
	public void teardown() {
		driver.quit();
	}
}
