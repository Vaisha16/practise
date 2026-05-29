package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Frames {

	public static void main(String[] args) {
		System.out.println("Frames");
		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("https://demoqa.com/frames");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));

			System.out.println(driver.findElement(By.cssSelector("#sampleHeading")).getText());
			
//			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();

			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame2")));

			System.out.println(driver.findElement(By.cssSelector("#sampleHeading")).getText());
			
			driver.switchTo().newWindow(WindowType.TAB);
			driver.get("https://demoqa.com/nestedframes");
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("frame1")));

			System.out.println(driver.findElement(By.tagName("body")).getText());
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe")));
			
			System.out.println(driver.findElement(By.tagName("p")).getText());

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			driver.close();

			if (driver != null)
				driver.quit();
		}

	}

}
