package com.picnic.pack2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GaRefCode {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,30);
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
      //Login
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#txtUsername"))).sendKeys("Admin");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=txtPassword]"))).sendKeys("admin123");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.button"))).click();
    	//PIM
    
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewPimModule"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_addEmployee"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("formInputText"))) .sendKeys("ipl");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))) .sendKeys("match1");
    	WebElement e1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='employeeId']")));
    	String s1 = e1.getAttribute("value");
    	System.out.println("empid : "+s1);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btnSave']"))).click();
       	Thread.sleep(2000);
      //EMPLOYEE SEARCH
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewEmployeeList"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("empsearch[employee_name][empName]"))).sendKeys("ipl match1");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("empsearch[id]"))).sendKeys(s1);
     	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBtn"))).click();
       	//ADMIN
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_viewAdminModule"))).click();   	
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_admin_UserManagement"))).click();
    	//ADD
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAdd"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_employeeName_empName"))).sendKeys("ipl match1");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_userName"))).sendKeys("j2345679");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_password"))).sendKeys("iplmatch2000");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("systemUser_confirmPassword"))).sendKeys("iplmatch2000");
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave"))).click();
    	//ADDSearch
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchSystemUser_userName"))).sendKeys("j2345679");
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchSystemUser_employeeName_empName"))).sendKeys("ipl match1");
    	Thread.sleep(2000);
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBtn"))).click();
    	     	
     	//LOGOUT
      	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Welcome Julie"))).click();
    	wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click();
     //wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Paul"))).click();

	}

}

