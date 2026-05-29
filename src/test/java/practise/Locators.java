package practise;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {
	
	public static void main(String[] args) {
		System.out.println("02 Locators");
		WebDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title: " + driver.getTitle());
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']")));
		
		boolean isDashboardDisplayed = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
		
		assertTrue(isDashboardDisplayed);
		
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		
		driver.findElement(By.cssSelector("input.submit-button.btn_action")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Swag Labs')]")));
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());	
		
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			driver.close();
			
			driver.quit();
		}
		
	}

}
