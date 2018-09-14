package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class NominateBrightSparkManagerView extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	@QAFTestStep(description="Enter with {0} and {1}")
	public void loginuser(String username,String password)
	{
		sendKeys(username,"txt.username");
		sendKeys(password,"txt.password");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//class[@type='submit']")));
		buttonlog.click();
	}
	@QAFTestStep(description="Click on manager view")
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
	@QAFTestStep(description="Click on View Other Requests")
	public void ViewRequests() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, 130);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement viewRequests=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Other')]")));
		js.executeScript("arguments[0].click();", viewRequests);
		WebElement viewAll=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@title='View Details'])[1]")));
		js.executeScript("arguments[0].click();", viewAll);
		Thread.sleep(4000);
		WebElement brighSpark=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tbody/tr/td[3])[1]")));
		js.executeScript("arguments[0].click();", brighSpark);
		Thread.sleep(4000);
		WebElement Element=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),' Approve')]")));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		js.executeScript("arguments[0].click();", Element);
		Thread.sleep(4000);
		WebElement appComments=driver.findElement(By.xpath("//textarea[@placeholder='Write Comment']"));
		appComments.sendKeys("Approved Successfully");
		WebElement submitbutton=driver.findElement(By.xpath("//button[contains(text(),'Submit')]"));
		js.executeScript("arguments[0].click();", submitbutton);
		Thread.sleep(4000);
	}

}
