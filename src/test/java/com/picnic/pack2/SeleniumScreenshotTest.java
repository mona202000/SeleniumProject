package com.picnic.pack2;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumScreenshotTest {
 
 public static void main(String[] args) throws IOException {

System.setProperty("webdriver.chrome.driver" , "C:\\\\\\\\Users\\\\\\\\mohanapriyas\\\\\\\\eclipse-workspace-selenium\\\\\\\\selenium project\\\\\\\\drivers\\\\\\\\chromedriver.exe");

WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
driver.manage().window().maximize();
driver.get("https://www.google.com/");



 
File source_file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
FileUtils.copyFile(source_file, new File("C:\\Users\\mohanapriyas\\eclipse-workspace-maven_selenium\\seleniumproject\\src\\test\\java\\com\\picnic\\pack2"+".jpg"));
driver.quit();
 }
}

