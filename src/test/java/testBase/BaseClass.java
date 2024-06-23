package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
	public BaseClass() {

		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/test/java"+"/configuration/config.properties");
			//FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"	+ "/config/config.properties");
		    prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("FF")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		
	}
	
	
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());// time stamp
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+ tname + "_" + timeStamp + ".png";
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}




	

}
