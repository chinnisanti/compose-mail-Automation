package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class mailComposing {

	@Test
	public void mailCompose() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://yahoo.com");
		Thread.sleep(5000);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id=\"ysignin\"]/div")).click();
		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.elementToBeClickable(By.id("login-username"))).sendKeys("username");
		
		driver.findElement(By.name("signin")).click();
		new WebDriverWait(driver,10)
		.until(ExpectedConditions.elementToBeClickable(By.id("login-passwd"))).sendKeys("password");
//		 
		driver.findElement(By.id("login-signin")).click();
		driver.findElement(By.xpath("//*[@class=\"icon mail\"]")).click();
		
		driver.findElement(By.xpath("//*[@data-test-id=\'compose-button\']")).click();
		
		driver.findElement(By.id("message-to-field")).sendKeys("send@gmail.com");
		
		driver.findElement(By.xpath("//*[@data-test-id='compose-subject']")).sendKeys("incubyte");
//	 
		new WebDriverWait(driver, 10)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@data-test-id='compose-editor-container']"))).sendKeys("Automation QA test for Incubyte");
		 
		driver.findElement(By.xpath("//*[@data-test-id='compose-send-button']")).click();
		
		
		  
	}
}
