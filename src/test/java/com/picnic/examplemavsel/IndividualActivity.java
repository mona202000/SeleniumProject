package com.picnic.examplemavsel;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import java.util.List;
	import java.util.NoSuchElementException;
	import java.util.concurrent.TimeUnit;
	import org.openqa.selenium.chrome.ChromeDriver;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.testng.annotations.Test;
    import io.github.bonigarcia.wdm.WebDriverManager;

	public class IndividualActivity {
		@Test
		public void selenium1() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.saucedemo.com/");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			//Login
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			Thread.sleep(2000);
			WebElement login= driver.findElement(By.name("login-button"));
			login.click();
			Thread.sleep(2000);
			//Assertion
			WebElement logo=driver.findElement(By.className("app_logo"));
			System.out.println("IS SWAG LAB logo is present?"+logo.isDisplayed());
			Object wait;
			//Adding product
			WebElement addcart= driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
			addcart.click();
			Thread.sleep(2000);
			WebElement addcart1= driver.findElement(By.id("shopping_cart_container"));
			addcart1.click();
			Thread.sleep(2000);
			//checkout
			WebElement checkot= driver.findElement(By.id("checkout"));
			checkot.click();
			Thread.sleep(2000);
			//name
			WebElement ffn= driver.findElement(By.id("first-name"));
			ffn.click();
			ffn.sendKeys("Mona");
			Thread.sleep(2000);
			WebElement lln= driver.findElement(By.id("last-name"));
			lln.click();
			lln.sendKeys("Priya");
			Thread.sleep(2000);
			WebElement lln1= driver.findElement(By.id("postal-code"));
			lln1.click();
			lln1.sendKeys("600123");
			Thread.sleep(2000);
			WebElement he1= driver.findElement(By.id("continue"));
			he1.click();
			Thread.sleep(2000);
			WebElement finn= driver.findElement(By.id("finish"));
			finn.click();
			Thread.sleep(2000);
			WebElement goback= driver.findElement(By.id("back-to-products"));
			goback.click();
			Thread.sleep(2000);
			WebElement logt= driver.findElement(By.id("react-burger-menu-btn"));
			logt.click();
			Thread.sleep(2000);
			WebElement logt1= driver.findElement(By.id("logout_sidebar_link"));
			logt1.click();
			Thread.sleep(2000);
			
			driver.quit(); 
		}
	}

	

		 



