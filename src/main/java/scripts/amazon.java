package scripts;


	
	 
	import java.util.ArrayList; 
	import java.util.List; 
	import java.util.concurrent.TimeUnit; 
	 
	import org.openqa.selenium.By; 
	import org.openqa.selenium.JavascriptExecutor; 
	import org.openqa.selenium.Keys; 
	import org.openqa.selenium.WebDriver; 
	import org.openqa.selenium.WebElement; 
	import org.openqa.selenium.chrome.ChromeDriver; 
	import org.testng.annotations.Test; 
	 
	public class amazon { 
		 
		@Test 
		public void test() throws Throwable { 
			System.setProperty("webdriver.chrome.driver","E:\\Oxygen-Workspace\\Maven\\Drivers\\chromedriver.exe"); 
			WebDriver driver = new ChromeDriver(); 
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS); 
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS); 
			driver.manage().deleteAllCookies(); 
			driver.manage().window().maximize(); 
			driver.get("https://www.amazon.in"); 
			WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")); 
			search.sendKeys("himalaya"); 
			search.sendKeys(Keys.ENTER); 
			Thread.sleep(5000); 
			 
			String nextbutton = driver.findElement(By.xpath("//a[text()='Next']")).getAttribute("class"); 
			 
			List<WebElement> products = driver.findElements(By.xpath("//span[contains(@class,'a-size-base-plus a-color')]")); 
			List<String> productnames = new ArrayList<String>(); 
			 for (WebElement names : products) { 
				 productnames.add(names.getText()); 
		            System.out.println(names.getText()); 
		        } 
			 System.out.println("*****************************************************************************************************************************************************"); 
			 
			while(!nextbutton.contains("disabled")) 
			{ 
				Thread.sleep(2000); 
				 driver.findElement(By.xpath("//a[text()='Next']")).click();  
				Thread.sleep(2000); 
				 
				Thread.sleep(2000); 
				 products = driver.findElements(By.xpath("//span[contains(@class,'a-size-base-plus a-color')]")); 
				 for (WebElement names : products) { 
					 productnames.add(names.getText()); 
			            System.out.println(names.getText()); 
			        } 
				 System.out.println("***************************************************************************************************************************************************"); 
				 try { 
				 driver.findElement(By.xpath("//a[text()='Next']")); 
				 }catch (Exception e) { 
					 System.out.println("No more Products"); 
					 break; 
				 } 
			} 
			 System.out.println("********************************************************************************************************************************************************"); 
			 
			 
			System.out.println("my number of products are: "+productnames.size()); 
			 
			driver.quit(); 
			 
			} 
		} 



