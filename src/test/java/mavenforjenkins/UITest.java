package mavenforjenkins;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UITest 
{

	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName) throws InterruptedException
	{
		//System.out.println("Parameter value is "+browserName);
		WebDriver driver=null;
		
		if(browserName.contains("Chrome"))
		{
			//System.out.println("______________ " + browserName);
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "E:\\Practice\\chromedriver.exe");
			//driver=new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver", "E:\\Practice\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else if(browserName.contains("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			 driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		//System.out.println("******************** " + driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Google"), "Title does not match");
		//Thread.sleep(2000);
		driver.quit();
	}
	
	
}
