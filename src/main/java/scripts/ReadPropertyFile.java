package scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropertyFile {
		static WebDriver driver;
	public static void main(String[] args) throws Throwable {

		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("E:\\Eclipse_Workspace\\Selenium\\src\\main\\java\\scripts\\config.properties");
		prop.load(fis);
		
		String browsername = prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		}else if(browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
		driver.quit();
		
	}

}
