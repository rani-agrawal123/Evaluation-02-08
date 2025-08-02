package Evaluation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class evaluation {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		WebElement round = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
		
		round.click();
		
		
//		for From
		WebElement form = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1"));
				
		form.click();
		
		Select drop = new Select(form);

		drop.selectByValue("DEL");
	
		
//		for To
		WebElement to = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1"));
		
		to.click();
		
		drop.selectByVisibleText("Bengaluru (BLR)");
		
		
		
		
		
//		for Depart date
		
		driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
		
		while(!driver.findElement(By.className("ui-datepicker-title")).getText().equals("May 2019"))
		{
			driver.findElement(By.className("ui-state-disabled")).click();
		}
		driver.findElement(By.xpath("//a[text()='14']")).click();
		
		
		
		
//		for return date
          driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		
		while(!driver.findElement(By.className("ui-helper-clearfix")).getText().equals("May 2019"))
		{
			driver.findElement(By.xpath("//a[text()='Prev']")).click();
		}
		driver.findElement(By.xpath("//a[text()='10']"));
		
		
		
//		for select senior citizen
		
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
		
//		passenger selection
		driver.findElement(By.id("divpaxinfo")).isDisplayed();
		
		
		
//		for search button
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		
		
		
//		Take Screenshot of the result page  or full page
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		File targetfile = new File("C:\\Users\\rania\\OneDrive\\Desktop\\screenshot\\evaluationPage");
		
		FileUtils.copyFile(sourcefile, targetfile);
		
		
		
	}

}
