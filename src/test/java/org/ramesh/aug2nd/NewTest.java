package org.ramesh.aug2nd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/*import com.relevantcodes.extentreports.LogStatus;
import com.wd.utils.ReportUtil;*/

public class NewTest {
	
WebDriver driver;
	@Test
	public void login() {
		System.out.println("changed firstly");
		System.out.println("changed secondly");
		System.out.println("commiting to Remote repositories");
		System.out.println("commiting to Remote repositories 2nd time");
		System.out.println("commited in github");
		System.out.println("commited back to github");
		System.out.println("commited back to github to check jenkins-github integration");
		
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://opensource.demo.orangehrmlive.com");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();

	}

	@Test(dependsOnMethods = "login")
	public void addEmployee() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(.,'PIM')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add Emp')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id=\"firstName\"]")).sendKeys("sel12");
		driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("sel1");
		driver.findElement(By.xpath("//input[@id='btnSave']")).click();
		driver.close();
	}

	@AfterClass
	public void closeApplication() {
		//ohrm.closeApplication();
		driver.close();
	}
}
