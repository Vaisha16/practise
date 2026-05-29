package practise;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDOM5 {

	public static void main(String[] args) throws InterruptedException{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://uitestingplayground.com/shadowdom");
		
		driver.findElement(By.xpath("//button[contains(text(),'Advanced')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'unsafe')]")).click();
		
		WebElement host = driver.findElement(By.cssSelector("guid-generator"));
		
		SearchContext root = host.getShadowRoot();
		
		root.findElement(By.cssSelector("#editField")).sendKeys("sample");
		
		
		
		
	}
}