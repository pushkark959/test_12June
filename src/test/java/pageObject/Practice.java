package pageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Practice {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://thriversity.harappa.education/login");
//		driver.get("https://www.fb.com");
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("pushkar.kumar@harappa.education");
//		driver.findElement(By.xpath("//input[@id='password-field']")).sendKeys("harappa123");
//		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
//		String text = driver.findElement(By.xpath("//h1[@class='hero-section__title mg-b10']")).getText();
//		System.out.println(text);
//		driver.findElement(By.xpath("//span[@class='sidebar__menu-title'][normalize-space()='My Certificates']")).click();
//		Thread.sleep(3000);
//		driver.navigate().back();
//		Thread.sleep(3000);
//		driver.navigate().forward();
//		
//		Actions act = new Actions (driver);
//		WebElement rightclick = driver.findElement(By.xpath("//h1[@class='hero-section__title mg-b10']"));
//		//act.contextClick(rightclick).perform();
//		List<WebElement> link = driver.findElements(By.tagName("span"));
//		System.out.println(link.size());

		boolean status = driver.findElement(By.xpath("//img[@src='assets/images/thriversity-logo.png']")).isDisplayed();
		System.out.println("Status of logo : "+status);
		
				
		Thread.sleep(3000);
		driver.close();
		
		
		
		
		
}

}
