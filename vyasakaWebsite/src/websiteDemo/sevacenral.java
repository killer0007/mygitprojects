package websiteDemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class sevacenral {
	public WebDriver driver;
	public String  base = "http://www.sevacentral.in";
  @Test (priority=1)
  public void home() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/portal?homePage']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.sevacentral.in/portal?homePage");
  }
  @Test (priority=2)
  public void blogs() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='custom-collapse']/ul/li[6]/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.sevacentral.in/Blogs");
  }
  
  @Test (priority=3)
  public void blogsTNGO() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='custom-collapse']/ul/li[2]/a")).click();
		Assert.assertEquals(driver.getCurrentUrl(), base+"/Profiles?ngosList");
  }
  @Test	(priority=4)
  public void blogsaddNGO() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/Profiles?addNGO']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), base+"/Profiles?addNGO#/");
  }
  @Test	(priority=5)
  public void blogsbrows() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/Profiles?browseNGOs']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), base+"/Profiles?browseNGOs#/");
  }
  @Test (priority=6)
  public void blogslist() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/Blogs?listing']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), base+"/Blogs?listing");
  }
  @Test	(priority=7)
  public void login() throws InterruptedException {
	  Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href=' /portal?signIn']")).click();
		Assert.assertEquals(driver.getCurrentUrl(), base+" /portal?signIn");
  }
 
  @BeforeTest
  public void beforeTest() {
	  driver = new FirefoxDriver();
	  String URL = "http://www.sevacentral.in/";
		driver.get(URL);
  }

  @AfterTest
  public void afterTest() {
  driver.close();
  }

}
