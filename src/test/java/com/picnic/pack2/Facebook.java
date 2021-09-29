package com.picnic.pack2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {
	public static void main(String[] args) {
		String baseUrl = "http://www.facebook.com/";
		//WebDriver driver =  new FirefoxDriver();
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
