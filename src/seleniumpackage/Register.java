package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register {
	
	public WebDriver driver;
	
	@BeforeTest
	public void open() {
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		System.out.println("--Browser Launched--");
		
	}
	
	@BeforeMethod
	public void checkTitle() {
		String expectedTitle = "Facebook – log in or sign up";
		String actualTitle = driver.getTitle();
		System.out.println("The Current title is : "+ actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	
	@Test
	public void register() throws InterruptedException {
		
		driver.findElement(By.name("firstname")).sendKeys("john");
		driver.findElement(By.name("lastname")).sendKeys("doe");
		driver.findElement(By.name("reg_email__")).sendKeys("7838422014");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Pass786");
		
		Select obj1 = new Select(driver.findElement(By.id("day")));
		obj1.selectByVisibleText("28");
//		obj1.selectByIndex(28);
		
		Select obj2 = new Select(driver.findElement(By.id("month")));
		obj2.selectByVisibleText("Aug");
		
		Select obj3 = new Select(driver.findElement(By.id("year")));
		obj3.selectByValue("1995");

		driver.findElement(By.id("u_0_7")).click();
		
		driver.findElement(By.name("websubmit")).click();
		
		Thread.sleep(5000);
		
		
	}
	
	
	@AfterTest
	public void end() {
		System.out.println("--Browser Closed--");
		driver.close();
	}
}
