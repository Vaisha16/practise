package practise;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadDownload {

	public static void main(String[] args) {
		System.out.println("File Upload And Download");
		WebDriver driver = null;

		try {
			driver = new ChromeDriver();

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			
			driver.get("https://demoqa.com/upload-download");

			driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\91805\\Desktop\\Vaishnavi_QA_5.4Yrs.pdf");
			
			driver.findElement(By.id("downloadButton")).click();
			
			File f = new File("C:\\Users\\91805\\Downloads\\sampleFile.jpeg");
			
			wait.until(driver1 ->f.exists());
			
			if(f.exists()) {
				System.out.println("success");
			}
			else {
				System.out.println("failure");
			}

			
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
