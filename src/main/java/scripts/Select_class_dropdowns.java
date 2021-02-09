package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Select_class_dropdowns {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");
		Select dropdown = new Select(driver.findElement(By.name("adults")));
		dropdown.selectByIndex(6);
		Thread.sleep(10000);
		driver.switchTo().newWindow(WindowType.TAB);// opening new tab in browser 
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@role='button'])[1]")).click();
		Thread.sleep(5000);
		Select dropdown2 = new Select(driver.findElement(By.id("month")));
		dropdown2.selectByVisibleText("Nov");
		Thread.sleep(5000);
		Select dropdown3 = new Select(driver.findElement(By.id("year")));
		dropdown3.selectByValue("2020");
		Thread.sleep(5000);
		driver.quit();
		
	}

}
