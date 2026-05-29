package practise;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling {

	public static void main(String[] args) {
		System.out.println("WindowHandling");
		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("https://demoqa.com/browser-windows");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());

			String parentWindow = driver.getWindowHandle();

			wait.until(ExpectedConditions.elementToBeClickable(By.id("tabButton"))).click();

			Set<String> windowIds = driver.getWindowHandles();

			if (windowIds.size() > 0 && windowIds.size() < 3)
				for (String id : windowIds)
					if(!id.equals(parentWindow))
						driver.switchTo().window(id);

			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());

			driver.switchTo().window(parentWindow);
			System.out.println(driver.getCurrentUrl());

			wait.until(ExpectedConditions.elementToBeClickable(By.id("windowButton"))).click();

			windowIds = driver.getWindowHandles();

			if (windowIds.size() > 0 && windowIds.size() < 2)
				for (String id : windowIds)
					driver.switchTo().window(id);

			System.out.println(driver.getTitle());

			driver.switchTo().window(parentWindow);
			
			wait.until(ExpectedConditions.elementToBeClickable(By.id("messageWindowButton"))).click();

			windowIds = driver.getWindowHandles();

			if (windowIds.size() > 0 && windowIds.size() < 2)
				for (String id : windowIds)
					driver.switchTo().window(id);

			System.out.println(driver.getTitle());

			driver.switchTo().window(parentWindow);

			System.out.println();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			driver.close();

			if (driver != null)
				driver.quit();
		}

	}

}
