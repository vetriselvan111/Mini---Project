package com.Project;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Project {
  public static void main(String[] args) throws InterruptedException, IOException {
	System.setProperty("WebDriver.Chrome.Driver", "C:\\Users\\Guru\\eclipse-workspace\\Testing\\Driver");
	WebDriver driver = new ChromeDriver();
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[@class='login']")).click();
	WebElement Email = driver.findElement(By.xpath("(//input[@name='email'][1])"));
	Email.sendKeys("talentedvetri@gmail.com");
	
	 WebElement Password = driver.findElement(By.xpath("(//input[@name='passwd'][1])"));
	 
	 Password.sendKeys("Mithun@123");
	
	driver.findElement(By.id("SubmitLogin")).click();
	
	WebElement tshirt = driver.findElement(By.xpath("(//a[text()='T-shirts'])[2]"));
	
	tshirt.click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	WebElement faded = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
	
	Actions ac = new Actions(driver);
	
	ac.moveToElement(faded).build().perform();
	
	Thread.sleep(3000);
	
	WebElement quickview = driver.findElement(By.xpath("//a[@class='quick-view']"));
	
	ac.click(quickview).build().perform();
	
	Thread.sleep(3000);
	
	WebElement addtocart = driver.findElement(By.xpath("//iframe[@vspace='0']"));
	
	driver.switchTo().frame(addtocart);
	
	WebElement addtoclick = driver.findElement(By.xpath("//button[@class='exclusive']"));
	
	addtoclick.click();
	
	WebDriverWait wait = new WebDriverWait(driver,90); 
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")));
	
	WebElement ptcheckout = driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span"));
	
	ac.moveToElement(ptcheckout).build().perform();
	
	ac.click(ptcheckout).build().perform();
	
	js.executeScript("window.scrollBy(0,500);");
	
	Thread.sleep(5000);
	
	driver.findElement(By.xpath("(//a[@title='Proceed to checkout'])[2]")).click();
	
    js.executeScript("window.scrollBy(0,500);");
	
	Thread.sleep(5000);
	
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    
    Thread.sleep(5000);
    
    driver.findElement(By.id("cgv")).click();
    
    WebElement LastCheckout = driver.findElement(By.xpath("//button[@name='processCarrier']"));
    
    ac.click(LastCheckout).build().perform();
    
    js.executeScript("window.scrollBy(0,500);");
    
    WebElement Pay = driver.findElement(By.xpath("//a[@class='cheque']"));
    
    ac.click(Pay).build().perform();
    
    js.executeScript("window.scrollBy(0,300);");
    
    WebElement order = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
    
    ac.click(order).build().perform();
    
    js.executeScript("window.scrollBy(0,300);");
    
    Thread.sleep(5000);
    
    TakesScreenshot ts = (TakesScreenshot) driver;
    
    File source = ts.getScreenshotAs(OutputType.FILE);
    
    File destination = new File("C:\\Users\\Guru\\eclipse-workspace\\Testing\\Screenshots\\project.png");
    
    FileUtils.copyFile(source, destination);
    
    
	
    
    
    
    
    
    
	//*[@id="category"]
	//a[@class='quick-view']
	
	//*[@id="layer_cart"]/div[1]/div[2]/div[4]/a
	
	
	//*[@id="layer_cart"]/div[1]/div[2]/div[4]/a/span
	
  //span[text()='Proceed to checkout']
	
  //button[@name='processCarrier']
	
	
	
	
}
}
