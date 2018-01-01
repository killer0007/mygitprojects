package testCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import dataEngine.Exceldata;
import uiOperation.PerformAction;
import uiOperation.Repository;

public class tempclass {
	
	public String  login() throws Exception {
		Exceldata excel = new Exceldata();
		List<List<String>> data2 = new ArrayList<List<String>>();
		data2 = excel.getexceldata("datamain.xls", "Sheet2");
		String op=null;
		System.out.println(data2);
		for(int i=1;i<data2.size();i++) {
			if(data2.get(i).get(1).equalsIgnoreCase("YES")) {
				System.out.println(data2.get(i).get(0)+"="+"passed");
			op=data2.get(i).get(0);
			}
			
		
		}
		
		return op;
	}

}
