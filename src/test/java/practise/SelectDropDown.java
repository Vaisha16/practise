package practise;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropDown {

	public static void main(String[] args) {
		System.out.println("Dropdown");
		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.get("https://demoqa.com/select-menu");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(text(),'Select Option')]//parent::div"))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Group 1, option 1')]")))
					.click();

			wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//div[contains(text(),'Select Title')]//parent::div"))).click();

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Mrs.')]")))
					.click();
			
			Select select = new Select(driver.findElement(By.cssSelector("#oldSelectMenu")));
			
			List<WebElement> options = select.getOptions();
			for(WebElement e: options) 
				System.out.println(e.getText());
			
			System.out.println();
			
			select.selectByIndex(0);
			
			WebElement firstSelectedOption = select.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText());
			System.out.println();
			
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			for(WebElement e: allSelectedOptions)
				System.out.println(e.getText());
			System.out.println();
			
			select.selectByValue("10");
			
			System.out.println(select.getFirstSelectedOption().getText());
			
			System.out.println();
			
			select.selectByVisibleText("Black");
			
			List<WebElement> allSelectedOptions2 = select.getAllSelectedOptions();
			for(WebElement e: allSelectedOptions2)
				System.out.println(e.getText());
			System.out.println();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(("//b[contains(text(),'Multiselect drop down')]//parent::p//following-sibling::div//input")))).click();
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Green')]")))
			.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Red')]")))
			.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Black')]")))
			.click();
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Blue')]")))
			.click();
			
			

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			driver.close();

			if(driver!=null)
				driver.quit();
		}

	}

}
