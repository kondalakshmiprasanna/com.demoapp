package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Fb {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.fb.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void verifyTitle()
	{
		
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, "Facebook – log in or sign up");
		
	}
	
	@Test(priority=2)
	public void verifyUrl()
	{
		String actualUrl=driver.getCurrentUrl();	
		Assert.assertEquals(actualUrl, "https://www.facebook.com/");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

}
