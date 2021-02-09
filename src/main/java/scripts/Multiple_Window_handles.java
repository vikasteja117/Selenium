package scripts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Multiple_Window_handles {
	
	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.snapdeal.com");
		WebElement search = driver.findElement(By.xpath("//input[@id='inputValEnter']"));
		search.sendKeys("samsung mobiles");
		search.sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("(//img[@class='product-image '])[2]")).click();
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String ParentWindowID = it.next();
		System.out.println("the parent id is "+ ParentWindowID);
		String ChildWindowID = it.next();
		System.out.println("the child window id is"+ChildWindowID);
		driver.switchTo().window(ChildWindowID);
		System.out.println("the child window titile is "+driver.getTitle());
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(ParentWindowID);
		System.out.println("the parent window titile is "+driver.getTitle());
		Thread.sleep(5000);
		driver.close();
		
	}

}
