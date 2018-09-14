package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.waitForVisible;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.example.components.SideBarComponents;

public class VerifyTravelRequestsTestSteps extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	/*@FindBy(locator="lnk.travel")
 private List<SideBarComponents> travelsidebar;*/
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
      @QAFTestStep(description="Check on travel requests")
      public void travelRequests() throws InterruptedException
      {
      boolean searchtravelPresence=driver.findElement(By.xpath("(//span[@title='Travel']//img[@class='settings_btn1'])[2]")).isDisplayed();
      boolean searchtravelEnabled=driver.findElement(By.xpath("(//span[@title='Travel']//img[@class='settings_btn1'])[2]")).isEnabled();
      boolean waitTravelVisible=driver.findElement(By.xpath("(//span[@title='Travel']//img[@class='settings_btn1'])[2]")).isPresent();
      
      if (searchtravelPresence==true && searchtravelEnabled==true && waitTravelVisible==true)
      {
    	  driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	  WebDriverWait wait=new WebDriverWait(driver, 30);
    	  JavascriptExecutor executor = (JavascriptExecutor)driver;
    	 
    	  //WebElement searchIcon2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu\"]/li[25]/span[2]")));
    	  //WebElement searchIcon2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@title='Travel']//img[@class='settings_btn1'])[2]")));
    	 WebElement searchIcon2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@title='Travel']//img[@class='settings_btn1'])[2]")));
          //WebElement searchIcon2 = driver.findElement(By.xpath("//span[@title='Travel']/child::img[1]"));
          executor.executeScript("arguments[0].click();", searchIcon2);
          JavascriptExecutor executor2 = (JavascriptExecutor)driver;
          WebElement travelRequestsIcon=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Travel Requests']")));
          executor2.executeScript("arguments[0].click();", travelRequestsIcon);
          Thread.sleep(3000);
          //Finding the Number of Rows
          /*List<WebElement> tableRows=driver.findElements(By.tagName("tr"));
          int rowSize=tableRows.size();
          //Finding the Number of Datas in the Available Rows
          List<WebElement> tableDatas=tableRows.get(rowSize).findElements(By.tagName("td"));
          int tableSize=tableDatas.size();
          for(int i=1;i<tableSize;i++)
          {
        	  String datas=tableDatas.get(i).getText();*/
          {
        	 WebElement table=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody/tr[2]/td[2]")));
        	 String tableRow= driver.findElement(By.xpath("//table//tbody/tr[2]/td[2]")).getText();
        	 String expRow="AutomationTest";
        	 if(tableRow.equalsIgnoreCase(expRow))
        	 {
        		 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
        		 WebElement table2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table//tbody/tr[2]/td[2]")));
        		 WebElement data=driver.findElement(By.xpath("//table//tbody/tr[2]/td[2]"));
        		 executor3.executeScript("arguments[0].click();", data);
        		 JavascriptExecutor executor4 = (JavascriptExecutor)driver;
        		 WebElement approve=driver.findElement(By.xpath("//button[contains(text(),' Approve')]"));  
        		 executor4.executeScript("arguments[0].click();", approve);	
        		 Thread.sleep(4000);
        		 
        		// driver.switchTo().window("Approval Comments");
           	  driver.findElement(By.xpath("//textarea[@placeholder='Write Comment']")).sendKeys("Travel Request Approval Done");
           	  driver.findElement(By.xpath("//button[@type='submit']")).submit();
           	  Thread.sleep(4000);
        	 }
        	 //WebElement rowText=tableRow.getText();
        	  
        	  /*Select actionDrop=new Select(tableRow);
        	  actionDrop.selectByIndex(1);
        	  driver.switchTo().window("Approval Comments");
        	  driver.findElement(By.xpath("//textarea[@placeholder='Write Comment']")).sendKeys("Travel Request Approval Done");
        	  driver.findElement(By.xpath("//button[@type='submit']"))*/;
        	  
          }
         
      }
      }
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement slidebutton3 = driver.findElement(By.xpath("//label[@title='Switch to Manager View']"));
		executor.executeScript("arguments[0].click();", slidebutton3);
		
		
       List< WebElement> slidebutton = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//label[@title='Switch to Manager View']")));
       for(int i=0;i<=slidebutton.size();i++)
       {
    	   slidebutton.get(i).click();
       }*/
	}


