package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Right_click_options {
	
	
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.automationtestinginsider.com/");
	Actions action = new Actions(driver);
	action.contextClick(driver.findElement(By.xpath("//a[text()='SELENIUM Q/A']"))).perform();
	
	}
	
}
