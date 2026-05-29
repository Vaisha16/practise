package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShadowDOM04 {

	WebDriver driver;
	JavascriptExecutor js;

	public void setUp() {
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickMensOuterwear() throws InterruptedException{
		driver.get("https://shop.polymer-project.org/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(d -> js.executeScript("return document.readyState").equals("complete"));

		Thread.sleep(3000); // Polymer hydration

		// Step 1: shop-app shadow root
		WebElement shopApp = driver.findElement(By.tagName("shop-app"));
		SearchContext shopAppShadow = shopApp.getShadowRoot();

		// Step 2: shop-home shadow root
		WebElement shopHome = shopAppShadow.findElement(By.cssSelector("shop-home"));
		SearchContext shopHomeShadow = shopHome.getShadowRoot();

		// Step 3: Find and click the Men's Outerwear link
		WebElement mensOuterwearLink = shopHomeShadow.findElement(By.cssSelector("a[href='/list/mens_outerwear']"));

		js.executeScript("arguments[0].click();", mensOuterwearLink);

		System.out.println("✅ Clicked Men's Outerwear!");
		System.out.println("URL: " + driver.getCurrentUrl());
	}

	public void tearDown() {
		if (driver != null)
			driver.quit();
	}

	public static void main(String[] args) throws InterruptedException{
		ShadowDOM04 test = new ShadowDOM04();
		test.setUp();
		test.clickMensOuterwear();
		test.tearDown();
	}
}