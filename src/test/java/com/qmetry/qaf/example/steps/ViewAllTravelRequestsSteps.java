package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class ViewAllTravelRequestsSteps extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	//Login With Valid Credentials into InfoStretch
	
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
			/*By locator=By.xpath("//label[@class='switch2']//div[@class='slider2 round2']");
			WebElement el = driver.findElement(locator);    
			  Actions builder = new Actions(driver);    
			  builder.moveToElement( el ).click( el );    
			  builder.perform();    
			Thread.sleep(2000);*/
		boolean searchIconPresence = driver.findElement(By.xpath("//label[@class='switch2']//div[@class='slider2 round2']")).isDisplayed();
	     boolean searchIconEnabled = driver.findElement(By.xpath("//label[@class='switch2']//div[@class='slider2 round2']")).isEnabled();
	     
	   //*[@id="menu"]/li[25]/span[1]/img
	     /*boolean searchtravelPresence=driver.findElement(By.xpath("//span[@title='Travel']/child::img[1]")).isDisplayed();
	     boolean searchtravelEnabled=driver.findElement(By.xpath("//span[@title='Travel']/child::img[1]")).isEnabled();
	     boolean waitTravelVisible=driver.findElement(By.xpath("//span[@title='Travel']/child::img[1]")).isPresent();
	     */
	      if (searchIconPresence==true || searchIconEnabled==true)
	     {
	               // click on the search button
	    	  	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	              WebElement searchIcon = driver.findElement(By.xpath("//label[@class='switch2']//div[@class='slider2 round2']"));
	              executor.executeScript("arguments[0].click();", searchIcon);
	              /*Actions builder = new Actions(driver);    
	    		  builder.moveToElement( searchIcon ).click( searchIcon );    
	    		  builder.perform(); */
	    		  //Thread.sleep(3000);
	    		  /*WebElement travel=driver.findElement(By.xpath("//*[@id=\"menu\"]/li[25]/span[2]"));
	    		  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu\"]/li[25]/span[2]")));
	               travel.click();
	               Thread.sleep(5000);*/
	              
	       }
		}
		@QAFTestStep(description="ViewAll Requests")
		public void viewAllRequests() throws InterruptedException {
			WebDriverWait wait=new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='tab_title m-r-40'])[3]")));
			 JavascriptExecutor executor2 = (JavascriptExecutor)driver;
			WebElement viewAllele=driver.findElement(By.xpath("(//span[@class='tab_title m-r-40'])[3]"));
			executor2.executeScript("arguments[0].click();", viewAllele);
			Thread.sleep(4000);
			//driver.findElement(By.xpath(("//span[contains(text(),'Travel')])[1]"))).click();
			 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
			WebElement viewAllLink=driver.findElement(By.linkText("View All"));
			executor3.executeScript("arguments[0].click();", viewAllLink);
			Thread.sleep(4000);

		}

}
