package scripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert_class {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver","E:\\Eclipse_Workspace\\Selenium\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("(//img[@alt='continue'])[1]")).click();
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();
		driver.quit();
		
		
	}

}
