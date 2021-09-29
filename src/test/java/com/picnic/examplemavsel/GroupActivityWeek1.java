package com.picnic.examplemavsel;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
 
public class GroupActivityWeek1 {
 
WebDriver driver;
 
/**
* This function will execute before each Test tag in testng.xml
* @param browser
* @throws Exception
*/
@BeforeTest // which will be executed first before all the test methods
@Parameters("browser") //@Parameter is used to pass the values
public void setup(String browser) throws Exception{
//Check if parameter passed from TestNG is 'firefox'
if(browser.equalsIgnoreCase("firefox")){
//create firefox instance
System.setProperty("webdriver.gecko.driver","C:\\\\Users\\\\mohanapriyas\\\\eclipse-workspace-selenium\\\\selenium project\\\\drivers\\\\geckodriver.exe");
driver = new FirefoxDriver();
}
 
//Check if parameter passed as 'chrome'
else if (browser.equalsIgnoreCase("chrome")){
//set path to chromedriver.exe
System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\mohanapriyas\\\\eclipse-workspace-selenium\\\\selenium project\\\\drivers\\\\chromedriver.exe");
driver = new ChromeDriver();
 
}

else{
//If no browser passed throw exception
throw new Exception("Browser is not correct");
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
 
@Test
public void testParameterWithXML() throws Exception{
	driver.get("https://opensource-demo.orangehrmlive.com/");   

	driver.manage().window().maximize();//to maximize the window
	WebDriverWait wait = new WebDriverWait(driver,40);//window will be wait for 40 secs 
	
	//Assertion
		WebElement logo=driver.findElement(By.tagName("img"));
		System.out.println("Is orange logo is present?"+logo.isDisplayed());
		
	//Login
    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input#txtUsername"))).sendKeys("Admin");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[name=txtPassword]"))).sendKeys("admin123");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input.button"))).click();
	
	//PIM
    
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewPimModule"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_addEmployee"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.className("formInputText"))) .sendKeys("Shriramsv");
	
	//Assertion  
		WebElement name= driver.findElement(By.className("formInputText"));
		System.out.println("The textfield is enabled " + name.isEnabled());
		
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("middleName"))) .sendKeys("MohanaPriyas");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))) .sendKeys("Mouleeswaranb");
	Thread.sleep(4000);
	WebElement e1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='employeeId']")));
	String s1 = e1.getAttribute("value");
	System.out.println("empid : "+s1);
	
	//Assertion
	boolean isEnabled = driver.findElement(By.xpath("//input[@id='btnSave']")).isEnabled();
	boolean isDisplayed = driver.findElement(By.xpath("//input[@id='btnSave']")).isDisplayed();
	if (isEnabled) {
	System.out.println("btn is Enabled");
	}else {
	System.out.println("Btn is Not Enabled");
	}
	if (isDisplayed) {
	System.out.println("Btn is Displayed");
	}else {
	System.out.println("Btn is Not Displayed");
	}


	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btnSave']"))).click();
   	Thread.sleep(5000);
   	
   	//PIM ADD_> this part of code is to validate whether we are able to create an employee details andsave it
   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewEmployeeList"))).click();
   Thread.sleep(4000);
   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ohrmList_chkSelectRecord_28"))) .click();
   Thread.sleep(8000);
     
   wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnAdd"))).click();
   Thread.sleep(4000);
   	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstName"))) .sendKeys("Shriram");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("middleName"))) .sendKeys("MohanaPriya");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("lastName"))) .sendKeys("Mouleeswaran");
	Thread.sleep(4000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
	Thread.sleep(4000);
	
	
	//Edit
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpFirstName"))).clear();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpFirstName"))) .sendKeys("Shri");
	
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpMiddleName"))).clear();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpMiddleName"))) .sendKeys("Mona");
	
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpLastName"))).clear();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtEmpLastName"))) .sendKeys("Moulee");
	
	Thread.sleep(3000);
	
	
	//licno
	 WebElement license_no=driver.findElement(By.name("personal[txtLicenNo]"));
	 license_no.sendKeys("ABC12345");
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtLicenNo"))) .sendKeys("ABC12345");
	 
	 //gender
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_optGender_1"))).click();
	//calendar
	WebElement selectDate = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[2]/li[4]/img"));
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/form/fieldset/ol[2]/li[4]/img"))).click();
	Thread.sleep(4000);
	//date
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtLicExpDate"))).clear();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_txtLicExpDate"))) .sendKeys("2000-03-07");		
	Thread.sleep(3000);
	
	//Dropdown
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_cmbNation"))).click();
	WebElement drpCountrOfCitizenship = driver.findElement(By.id("personal_cmbNation"));  
	Select dropdown = new Select(drpCountrOfCitizenship);  
	dropdown.selectByVisibleText("Indian");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_cmbNation"))).click();

	Thread.sleep(3000);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("personal_cmbNation"))).click();
	//Select drpNationality=new Select(driver.findElement(By.name("personal[cmbNation]n")));
	//drpCountry = new Select (driver.findElement(By.name("personal[cmbNation]n")));
	//country.selectByValue("82");
	//drpNationality.selectByVisibleText("Indian");
	//Thread.sleep(3000);
	//country.selectByIndex(82);
	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
	//screenshot
	takeSnapShot(driver, "D:\\SELENIUM\\edit.png") ;
	Thread.sleep(6000);
	
	
	 //EMPLOYEE SEARCH
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewEmployeeList"))).click();
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("empsearch[employee_name][empName]"))).sendKeys("Steve");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.name("empsearch[id]"))).sendKeys(s1);
	Thread.sleep(5000);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("searchBtn"))).click();
	Thread.sleep(6000);
	
	
    //My INFO
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewMyDetails"))).click();
	Thread.sleep(4000);
	
	//Href
	driver.findElement(By.linkText("Contact Details")).click();
	Thread.sleep(4000);
	
	//Edit
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_street1"))).clear();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_street1"))) .sendKeys("ABCDEFGHIJK Street");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_street2"))).clear();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_street2"))) .sendKeys("LMOPQRSTUVWXYZ Street");	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_city"))).clear();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_city"))) .sendKeys("CHENNAI");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_province"))).clear();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_province"))) .sendKeys("TAMIL NADU");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_zipcode"))).clear();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_zipcode"))) .sendKeys("600123");
	
	
	//dropdown2
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_country"))).click();
		WebElement drpCountrOfCitizenship1 = driver.findElement(By.id("contact_country"));  
		Select dropdown1 = new Select(drpCountrOfCitizenship1);  
		dropdown1.selectByVisibleText("India");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_country"))).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_hm_telephone"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_hm_telephone"))) .sendKeys("04412345678");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_mobile"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_mobile"))) .sendKeys("9876543210");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_oth_email"))).clear();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("contact_emp_oth_email"))) .sendKeys("abc@lol.com");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
		//contact
		    //driver.findElement(By.linkText("Emergency Contacts")).click();
			driver.findElement(By.partialLinkText("ergen")).click();
			Thread.sleep(4000);
		//dependents
			driver.findElement(By.linkText("Dependents")).click();
			
			Thread.sleep(4000);
		//immigration
			driver.findElement(By.linkText("Immigration")).click();
			Thread.sleep(4000);
		//job
			driver.findElement(By.linkText("Job")).click();
			Thread.sleep(4000);
		//salary
			driver.findElement(By.partialLinkText("Sal")).click();
			//driver.findElement(By.linkText("Salary")).click();
			Thread.sleep(4000);
		//Href
			driver.findElement(By.linkText("Tax Exemptions")).click();
			Thread.sleep(4000);
		//Href
			driver.findElement(By.linkText("Report-to")).click();
			Thread.sleep(4000);
		//Href
			driver.findElement(By.linkText("Qualifications")).click();
			Thread.sleep(4000);
		//Href
			driver.findElement(By.linkText("Memberships")).click();
			Thread.sleep(4000);
		 //My INFO
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_viewMyDetails"))).click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("tiptip"))).click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("photofile"))).click();
		//WebElement addFile = driver.findElement(By.xpath(".//input[@type='photofile']"));
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("photofile"))).click();
		//Href
		WebElement ChooseFile = driver.findElement(By.id("photofile"));
		ChooseFile.sendKeys("D:\\dp.png");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave"))).click();
		//Thread.sleep(6000);
		takeSnapShot(driver, "D:\\SELENIUM\\upload.png") ;
		Thread.sleep(6000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.id("menu_dashboard_index"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("Welcome"))).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Logout"))).click(); 
	    Thread.sleep(3000);
	    
	    //Tag
	    List <WebElement> list = driver.findElements(By.tagName("a"));
	    System.out.println("Number of links: "+list.size());
	    //for(int i=0;i<list.size();i++) {
	    	//System.out.println(list.get(i).getText());
	    
	    
	
	    driver.quit();
}


public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	//Convert web driver object to TakeScreenshot
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	//Call getScreenshotAs method to create image file
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	//Move image file to new destination
	File DestFile=new File(fileWithPath);
	//Copy file at destination
	FileUtils.copyFile(SrcFile, DestFile);

	}
}
