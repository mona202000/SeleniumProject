package com.picnic.examplemavsel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example {
	
	//public static void main(String[] args) throws InterruptedException  {
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\mohanapriyas\\eclipse-workspace-selenium\\selenium project\\drivers\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();//creating an instance for the driver
	//@Test
	public void mavsel() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");//give the url 
		driver.manage().window().maximize(); //to maximize the window 
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");//using sendkeys we passing the string that is Admin
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(3000);
		driver.quit();//closing the browser
	}
	//@Test
	public void fblogin() throws InterruptedException {
		String baseUrl = "http://www.facebook.com/";
		WebDriverManager.chromedriver().setup();
		WebDriver driver =  new ChromeDriver();
		driver.get(baseUrl);
		WebElement txtUsername=driver.findElement(By.id("email"));
		Actions builder=new Actions(driver);
		Action seriesOfActions = builder
				.moveToElement(txtUsername)
				.click()
				.keyDown(txtUsername, Keys.SHIFT)//this will type hello in uppercase
				.sendKeys(txtUsername,"hello")
				.keyUp(txtUsername, Keys.SHIFT)
				.doubleClick(txtUsername)//this will highlight the text hello
				.contextClick() // this will bring up the context menu
				.build();
		seriesOfActions.perform();
	}

}

