package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionsPractise {

	public static void main(String[] args) {
		System.out.println("Actions");
		WebDriver driver = null;
		Actions action;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

			action = new Actions(driver);

			driver.get("https://jqueryui.com/menu");
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.tagName("iframe")));

			WebElement electronicsMenu = wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Electronics')]")));

			action.moveToElement(electronicsMenu).build().perform();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Car Hifi')]"))).click();

			driver.get("https://demoqa.com/buttons");

			WebElement doubleBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("doubleClickBtn")));

			action.doubleClick(doubleBtn).perform();

			System.out.println(
					driver.findElement(By.xpath("//p[contains(text(),'You have done a double click')]")).isDisplayed());

			WebElement rightClick = wait.until(ExpectedConditions.elementToBeClickable(By.id("rightClickBtn")));

			action.contextClick(rightClick).perform();

			System.out.println(
					driver.findElement(By.xpath("//p[contains(text(),'You have done a right click')]")).isDisplayed());

			WebElement clickme = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));

			action.click(clickme).perform();

			System.out.println(driver.findElement(By.xpath("//p[contains(text(),'You have done a dynamic click')]"))
					.isDisplayed());

			driver.get("https://jqueryui.com/droppable");

			driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
			WebElement src = driver.findElement(By.xpath("//p[contains(text(),'Drag me to my target')]"));

			WebElement desc = driver.findElement(By.xpath("//p[contains(text(),'Drop here')]"));
			action.dragAndDrop(src, desc).perform();
			
			driver.get("https://demoqa.com/text-box");
			
			driver.findElement(By.id("userName")).sendKeys("Alice", Keys.TAB);
			
			driver.switchTo().activeElement().sendKeys("email@gmail.com", Keys.TAB);
			
			driver.switchTo().activeElement().sendKeys("Chennai", Keys.TAB);
			
			driver.switchTo().activeElement().sendKeys("Permanent Chennai");
			
			WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("submit")));
//			driver.findElement(By.id("submit")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", submitBtn);
			

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
//			driver.close();
//
//			if (driver != null)
//				driver.quit();
		}

	}

}
