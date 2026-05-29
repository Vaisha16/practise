package practise;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitConcepts03 {

	public static void main(String[] args) {
		System.out.println("02 Alert");
		WebDriver driver = null;
		Alert alert;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();
			
			driver.get("https://demoqa.com/alerts");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
//			WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#alertButton")));
//			btn.click();
//			
//			wait.until(ExpectedConditions.alertIsPresent());
//			
//			alert = driver.switchTo().alert();
//			
//			alert.accept();
//			
//			btn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#timerAlertButton")));
//			btn.click();
//			
//			wait.until(ExpectedConditions.alertIsPresent());
//			
//			alert = driver.switchTo().alert();
//			
//			alert.accept();
//			
//			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirmButton"))).click();
//			
//			wait.until(ExpectedConditions.alertIsPresent());
//			
//			alert = driver.switchTo().alert();
//			
//			alert.dismiss();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#promtButton"))).click();
			
			wait.until(ExpectedConditions.alertIsPresent());
			
			alert = driver.switchTo().alert();
			
			alert.sendKeys("alertSampleDemoqa");
			alert.accept();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			driver.close();

			if(driver!=null)
				driver.quit();
		}

	}

}
