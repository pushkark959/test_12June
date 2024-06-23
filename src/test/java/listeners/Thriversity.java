package listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.ExtentReportManager.class)

public class Thriversity {
	
	WebDriver driver;
	

	@BeforeClass
	void setup() throws InterruptedException {
	    driver = new ChromeDriver();
		driver.get("https://thriversity.harappa.education/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(3000);
	}
	
	
	@Test(priority=1)
	void testlogo() {
		boolean status = driver.findElement(By.xpath("//img[@src='assets/images/thriversity-logo.png']")).isDisplayed();
		//System.out.println("Status of logo : "+status);
		Assert.assertEquals(status, true);
	}
	
	
	@Test(priority=2)
	void testappurl() {
		 String url = driver.getCurrentUrl();
		 Assert.assertEquals(url, "https://thriversity.harappa.education/");
	}
	
	@Test(priority=3,dependsOnMethods= {"testappurl"})
	void testHomePageTitle() {
		String title = driver.getTitle();
		//System.out.println("Title of homepage : "+title);
		Assert.assertEquals(title, "Harappa");
	}
	
	
	@AfterClass
	void close() {
		driver.quit();
	}

}
