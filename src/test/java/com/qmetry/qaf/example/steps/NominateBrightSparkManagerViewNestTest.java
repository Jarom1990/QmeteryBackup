package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.waitForNotVisible;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class NominateBrightSparkManagerViewNestTest extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	@QAFTestStep(description="Enters with {0} and {1}")
	public void loginuser(String username,String password)
	{
		sendKeys(username,"txt.username");
		sendKeys(password,"txt.password");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		
		Actions action = new Actions(driver);
		action.moveToElement(buttonlog).click().build().perform();
	}
	@QAFTestStep(description="Click on the manager views")
	public void ManagerView() throws InterruptedException
	{
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver, 30);
		boolean searchIconPresence = driver.findElement(By.xpath("//label[@class='switch2']//div[@class='slider2 round2']")).isDisplayed();
		boolean searchIconEnabled = driver.findElement(By.xpath("//label[@class='switch2']//div[@class='slider2 round2']")).isEnabled();
     
       if (searchIconPresence==true || searchIconEnabled==true)
       {
               // click on the search button
    	  	  JavascriptExecutor executor = (JavascriptExecutor)driver;
              WebElement searchIcon = driver.findElement(By.xpath("//label[@class='switch2']//div[@class='slider2 round2']"));
              executor.executeScript("arguments[0].click();", searchIcon);    
       }
	}
	@QAFTestStep(description="Click on the R&R Sides Menu")
	public  void RandR() throws InterruptedException
	{
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		//JavascriptExecutor executor=(JavascriptExecutor)driver;
		Actions actions=new Actions(driver);
		WebElement nav=wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//span[@class='left_menu_nav_icon settings_btn1']"))));
		actions.moveToElement(nav).click().build().perform(); 
		wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath("//div[@class='mCSB_dragger_bar']"))));
		WebElement dragger=driver.findElement(By.xpath("//div[@class='mCSB_dragger_bar']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dragger);
		Thread.sleep(5000);
		actions.clickAndHold(dragger).dragAndDropBy(dragger, 0, 5000).release().perform();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//boolean  buttonlog2=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//span[contains(text(),'R & R')]//preceding-sibling::span[1])[1]")));
		WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[contains(text(),'R & R')]//preceding-sibling::span[1])[1]")));
		js.executeScript("arguments[0].click();", buttonlog);
		WebElement  nominate=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Nominate')]")));
		js.executeScript("arguments[0].click();", nominate);	
		Thread.sleep(4000);
	}
	
}
	