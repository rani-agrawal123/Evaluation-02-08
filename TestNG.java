package Evaluation;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG {

	WebDriver driver;
	
  	@BeforeMethod
	void Launch() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		driver.manage().window().maximize();
		Thread.sleep(3000);		
	}
	
	@Test
	void Calendar() throws InterruptedException {
      driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		while(!driver.findElement(By.className("ui-datepicker-title")).getText().equals("May 2019"))
		{
			driver.findElement(By.className("ui-state-disabled")).click();
		}
		driver.findElement(By.xpath("//a[text()='14']")).click();
		
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	void Checkboxes() throws InterruptedException {
		WebElement form = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));	
		form.click();
		Select drop = new Select(form);
		drop.selectByValue("DEL");
		
		
		
		
		
		
        WebElement round = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));	
		round.click();
		Thread.sleep(3000);
		driver.close();
	}
	
	@Test
	 void Screenshot() throws IOException, InterruptedException {
      TakesScreenshot ts = (TakesScreenshot)driver;
		
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File("C:\\Users\\rania\\OneDrive\\Desktop\\screenshot\\evaluationPage");
		
		FileUtils.copyFile(sourcefile, targetfile);
		Thread.sleep(3000);
		driver.close();
	}
	
	
	
}
