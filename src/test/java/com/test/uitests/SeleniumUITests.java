package com.test.uitests;


import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.test.runner.Runner;
import com.testingMeven.myTestMavenMain.utilities.SeleniumUtils;



public class SeleniumUITests {
	
	WebDriver driver;
	
	
	  @BeforeTest
	  public void beforeTest() throws MalformedURLException {
		  System.setProperty("webdriver.chrome.driver","Resource\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
	  }
	  
	  @Test
	  public void testAddOwner() throws InterruptedException 
		{
		  String firstName="TestFirstName_"+SeleniumUtils.getRandomNumber();
		  
		  System.out.println("Test Executing for env="+Runner.env);
		  driver.get(com.testingMeven.myTestMavenMain.utilities.Constants.URL1);
		  SeleniumUtils.waitForPageLoad(driver);
		  driver.findElement(By.xpath("//li/a[text()='Owners']")).click();
		  System.out.println("Clicked on owners tab");
		  SeleniumUtils.explicitWaitForElement(driver, By.xpath("//a [@routerlink='/owners/add']"), 10,"Add link");
		  driver.findElement(By.xpath("//a [@routerlink='/owners/add']")).click();
		  SeleniumUtils.waitForPageLoad(driver);
		  driver.findElement(By.xpath("//*[@id='firstName']")).sendKeys(firstName);
		  System.out.println("First Name="+firstName);
		  driver.findElement(By.xpath("//*[@id='lastName']")).sendKeys("Test Last Name");
		  System.out.println("Last Name Entered");
		  driver.findElement(By.xpath("//*[@id='address']")).sendKeys("Test address");
		  System.out.println("Address Entered");
		  driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Test City");
		  System.out.println("City entered");
		  driver.findElement(By.xpath("//*[@id='telephone']")).sendKeys("12121212");
		  
		  driver.findElement(By.xpath("//button[contains(text(),'Add Owner')]")).click();
		  SeleniumUtils.waitForPageLoad(driver);
		  //Thread.sleep(10000);
		  SeleniumUtils.explicitWaitForElement(driver, By.xpath("//a [contains(text(),'"+firstName+"')]"), 10, "Firt Name");
		  JavascriptExecutor jse = ((JavascriptExecutor) driver);
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  Thread.sleep(2000);
		  
		  /*if(driver.findElement(By.xpath("//a [contains(text(),'"+firstName+"')]")).isDisplayed())
		  {
			  Assert.fail("New Owner not found in the list");
		  }*/
		 driver.findElement(By.xpath("//a [contains(text(),'"+firstName+"')]")).click();
		 SeleniumUtils.waitForPageLoad(driver);
		 Thread.sleep(5000);
		 // Let the user actually see something!
		  
	  }
	  @Test
	  public void testVeterinarians() throws InterruptedException 
		{
		  driver.get(com.testingMeven.myTestMavenMain.utilities.Constants.URL1);
		  SeleniumUtils.waitForPageLoad(driver);
		  driver.findElement(By.xpath("//li/a[text()='Veterinarians']")).click();
		  System.out.println("Clicked on Veterinarians tab");
		//  SeleniumUtils.explicitWaitForElement(driver, By.xpath("/html/body/app-root/div/nav/div/ul/li[3]/ul/li[2]/a/span[2]"), 10,"Add link");
		  driver.findElement(By.xpath("//a[@href='/petclinic/vets/add']/span[contains(text(),'Add New')]")).click();
		  SeleniumUtils.waitForPageLoad(driver);
		  System.out.println("Vet-add works! found");
		  Thread.sleep(5000);
		}
	  @Test
	  public void testPetTypes() throws InterruptedException 
		{
		  driver.get(com.testingMeven.myTestMavenMain.utilities.Constants.URL1);
		  SeleniumUtils.waitForPageLoad(driver);
		  driver.findElement(By.xpath("//span[contains(text(),'Pet Types')]")).click();
		  System.out.println("Clicked on pet types tab");
		  SeleniumUtils.waitForPageLoad(driver);
		//h1 [contains(text(),'Oops! Page not found !')]
		  Thread.sleep(2000);
		  System.out.println("Page not found error occured");
		  Assert.fail("Page not found error occured");
		  
		}
	  
	  @Test
	  public void testSpecialities() throws InterruptedException 
		{
		  driver.get(com.testingMeven.myTestMavenMain.utilities.Constants.URL1);
		  SeleniumUtils.waitForPageLoad(driver);
		  driver.findElement(By.xpath("//span [contains(text(),'Specialties')]")).click();
		  System.out.println("Clicked on Specialities tab");
		  SeleniumUtils.waitForPageLoad(driver);
		  driver.findElement(By.xpath("//*[@id='vets']/tbody/tr[1]/td[3]/button[1]")).click();
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@id='0']")).clear();
		  driver.findElement(By.xpath("//input[@id='0']")).sendKeys("Update Test");
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//button[contains(text(),'Update')]")).click();
		  Thread.sleep(2000);
		 	  System.out.println("Specialist Text updated successfully");
		}
	  @AfterTest
	  public void afterTest() 
	  {
		  driver.quit();
	  }
	  
	  

}
