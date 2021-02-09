package scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action_Class_MouseOverActions {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.yatra.com/");
		WebElement mouseover = driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[2]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(mouseover).build().perform();
		
		try {
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Talk to us']"))).click();
		}catch(TimeoutException e) {
			driver.findElement(By.xpath("(//a[@class='appendBottom5 blackText'])[5]")).click();
			System.out.println("as per expected element clicked");
		}finally{
			System.out.println("finally element clicked");
			
		}
		
		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}