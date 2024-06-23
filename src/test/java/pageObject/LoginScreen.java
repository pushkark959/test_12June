package pageObject;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;



public class LoginScreen extends BaseClass{
	
	public LoginScreen() {
		PageFactory.initElements(driver, this);
	}
	
	//Element
	
		@FindBy(xpath = "//input[@id='inputEmail']")
		WebElement txtusername;
		
		@FindBy(xpath= "//input[@id='password-field']")
		WebElement txtpassword;
		
		@FindBy(xpath = "//button[@class=\"btn btn--round btn-primary\"]")
		WebElement btnsubmit;
		
		@FindBy(xpath = "//img[@src='assets/images/thriversity-logo.png']")
		WebElement logoheader;
		
		@FindBy(xpath = "//div[@class='hero-section__video intro-video-image']")
		WebElement imgheader;
		

		
		

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
		
		public WebElement logoimage() {
			return logoheader;	
		}
		
		public WebElement headerimage() {
			return imgheader;
		}

    
}
