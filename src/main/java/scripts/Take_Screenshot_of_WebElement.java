package scripts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Take_Screenshot_of_WebElement {

	public static void main(String[] args) throws Throwable {
		
		
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
		WebElement search = driver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		search.sendKeys("samsung A50");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.linkText("Images")).click();
	Thread.sleep(5000);
	WebElement image = driver.findElement(By.xpath("//img[@alt='Samsung Galaxy A50 Review: Finally, A Reasonable Samsung Mid-Ranger -  MySmartPrice']"));
	Thread.sleep(5000);
	File srcfile = image.getScreenshotAs(OutputType.FILE);
	Thread.sleep(5000);
	FileUtils.copyFile(srcfile,new File("./target/Screenshots/picture.jpg"));
	driver.quit();
	}

}
