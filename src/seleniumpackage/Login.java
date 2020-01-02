package seleniumpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	
	public WebDriver driver;
	
	@BeforeTest
	public void open() {
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/login/");
		System.out.println("--Browser Launched--");
		
	}
	
	@BeforeMethod
	public void checkTitle() {
		String expectedTitle = "Log in to Facebook | Facebook";
		String actualTitle = driver.getTitle();
		System.out.println("The Current title is : "+ actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test
	public void VerifyLogin() throws InterruptedException {
						
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("chiranjeev1@gmail.com");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys("root321");
		
		WebElement signIn = driver.findElement(By.name("login"));
		signIn.click();
		
		Thread.sleep(2000);
		
		System.out.println("Logged In Succesfully");
		
	}
	
	
	@AfterMethod
	public void homepage() {
		driver.get("https://www.facebook.com");
	}
	
	@AfterTest
	public void end() {
		System.out.println("--Browser Closed--");
		driver.close();
	}
}
