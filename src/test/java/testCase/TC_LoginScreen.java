package testCase;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.LoginScreen;
import testBase.BaseClass;

@Listeners(utiLities.ExtentReportManager.class)

public class TC_LoginScreen extends BaseClass {
	LoginScreen lp;
	
	public TC_LoginScreen(){
		super();
	}

	

	@BeforeClass
	void setup()  {
		initialization();
		lp = new LoginScreen();
		
	}
	
	
	@Test(priority=1)
	void testlogo() {
		boolean status = lp.logoimage().isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	
	@Test(priority=2,dependsOnMethods={"testlogo"})
	void testappurl() {
		 String url = driver.getCurrentUrl();
		 Assert.assertEquals(url, "https://thriversity.harappa.education/login");
	}
	
	@Test(priority=3,dependsOnMethods={"testlogo"})
	void testHomePageTitle() {
		String title = driver.getTitle();
		//System.out.println("Title of homepage : "+title);
		Assert.assertEquals(title, "Harappa");
	}
	
	@Test(priority=4)
	void testlogin() {
		lp.setusername().sendKeys(prop.getProperty("userName"));
		lp.setPassword().sendKeys(prop.getProperty("password"));
		lp.clickSubmit().click();
		boolean b = lp.headerimage().isDisplayed();
		System.out.println("Presence of Header Image : "+b);
		Assert.assertEquals(b, true);
		
	
	}
	@AfterClass
	void close() {
		driver.quit();
	}

}
