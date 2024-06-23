package testCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObject.LoginPageThriversity;
import testBase.BaseClass;

public class TC_LoginPageThriversity extends BaseClass {
	LoginPageThriversity lpt;
	
	public TC_LoginPageThriversity() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialization();
		lpt = new LoginPageThriversity();
	}
	
	@Test(priority=1)
	public void EnterUserName() throws InterruptedException {
		lpt.setusername().sendKeys(prop.getProperty("userName"));
		Thread.sleep(3000);
	}
	
	@Test(priority=2,dependsOnMethods= {"EnterUserName"})
		public void EnterPassword() throws InterruptedException {
		lpt.setPassword().sendKeys(prop.getProperty("password"));
		Thread.sleep(3000);	
	}
		
	@Test(priority=3,dependsOnMethods= {"EnterUserName"})
	public void clickSubmitButton() throws InterruptedException {
		lpt.clickSubmit().click();
		Thread.sleep(3000);
	}
	
	@Test(priority=4)
	public void checkHeaderImage() {
		lpt.setusername().sendKeys(prop.getProperty("userName"));
		lpt.setPassword().sendKeys(prop.getProperty("password"));
		lpt.clickSubmit().click();
		boolean b = lpt.headerimage().isDisplayed();
		System.out.println("Presence of Header Image : "+b);
		Assert.assertEquals(b, true);
		
	}
	
	@AfterClass
	public void exit() {
		driver.close();
	}

}
