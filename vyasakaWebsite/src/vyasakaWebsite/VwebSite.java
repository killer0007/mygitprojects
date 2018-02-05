package vyasakaWebsite;

import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class VwebSite {
	
	public WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String actual, String expect) throws Exception {
	 //System.out.println(expect + actual);
	 driver.get("http://"+actual);
	 Thread.sleep(2000);
	 Assert.assertEquals("http://"+expect,driver.getCurrentUrl() );
  }

  @DataProvider (name = "dp")
  public Object [] [] ReadExcel() throws BiffException, IOException {
		String fileName = "C:\\Users\\gopin\\eclipse-workspace\\vyasakaWebsite\\testExcel.xls";
		File fl = new File(fileName);
		Workbook wb = Workbook.getWorkbook(fl);
		Sheet s = wb.getSheet("Sheet1");
		int rows = s.getRows();
		int col = s.getColumns();
	//	System.out.println(rows);
		//System.out.println(col);
		String Inputdata [] [] = new String [rows] [col];
		for (int i=0; i<rows; i++) {
			for (int j=0; j<col; j++) {
				Cell c = s.getCell(j,i);
				Inputdata [i] [j] = c.getContents();
				System.out.println(Inputdata [i] [j]);
			}
		}
		return Inputdata;
			
	};

  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
  driver.quit();
  }
  

}
