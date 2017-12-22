package testcase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import data.ReadData;
import junit.framework.Assert;
import operation.Perform;

public class Test1 {
	WebDriver driver;

	@BeforeTest
	public void start() {
		System.setProperty("webdriver.firefox.marionette", "D:\\SELENIUM\\gekodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	@Test
	public void ts1() throws Exception {
		ReadData excel = new ReadData();
		List<List<String>> exceldata = new ArrayList<List<String>>();
		exceldata = excel.getdata("TestCase.xls", "Sheet1");
		// System.out.println(exceldata);
		Perform op = new Perform(driver);
		// for (int i=2;i<6;i++) {
		// for (int j=1;j<exceldata.get(i).size();j++) {
		// System.out.print(exceldata.get(i).get(j));
		// System.out.print(" ==== ");
		// }
		// System.out.println();
		// }
		//
		for (int i = 0; i < exceldata.size(); i++) {
			if (exceldata.get(i).get(0) == null) {
				// System.out.println(exceldata.get(i).get(1)+"-"+ exceldata.get(i).get(2)
				// +"-"+exceldata.get(i).get(3)+"-"+exceldata.get(i).get(4));
				op.performaction(exceldata.get(i).get(1), exceldata.get(i).get(2), exceldata.get(i).get(3),
						exceldata.get(i).get(4));
				Thread.sleep(2000);
				//continue;
			}
		}
		System.out.println(driver.getTitle());
		Assert.assertEquals("Guru99 Bank Manager HomePage", driver.getTitle());
	}
@AfterTest
public void close() {
	driver.quit();
}
}
