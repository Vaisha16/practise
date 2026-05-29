package practise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserLaunchAndNavigation {
	
	public static void main(String[] args) {
		System.out.println("Browser Launch and Navigation");
		WebDriver driver = null;
		
		try {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com");
		
		System.out.println("Current URL: " + driver.getCurrentUrl());
		System.out.println("Title: " + driver.getTitle());
		
		driver.navigate().to("https://www.amazon.in/");
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		driver.navigate().forward();
		
		driver.navigate().refresh();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			driver.close();
			
			driver.quit();
		}
		
	}

}
