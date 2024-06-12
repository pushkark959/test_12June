package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class LoginPageThriversity extends BaseClass{
	
	
	
	//Element
	
	@FindBy(xpath = "//input[@id='inputEmail']")
	WebElement txtusername;
	
	@FindBy(xpath= "//input[@id='password-field']")
	WebElement txtpassword;
	
	@FindBy(xpath = "//button[@class=\"btn btn--round btn-primary\"]")
	WebElement btnsubmit;
	
	@FindBy(xpath = "//div[@class='hero-section__video intro-video-image']")
	WebElement imgheader;
	
	public LoginPageThriversity() {
		PageFactory.initElements(driver, this);
	}
	
	

	//Action
	public WebElement setusername() {
		return txtusername;
	}
	
	public WebElement setPassword() {
		return txtpassword;
	}
	
	public WebElement clickSubmit() {
		return btnsubmit;
	}
	
	public WebElement headerimage() {
		return imgheader;
		
	}

}
