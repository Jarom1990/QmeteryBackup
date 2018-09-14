package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.waitForNotVisible;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
public class NominateForBrightSparkSteps extends WebDriverBaseTestPage<WebDriverTestPage>{
	
	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	
	public void waitForPageToLoad()
		{
			
			waitForNotVisible("login.loader.loc",20);
		}
		@QAFTestStep(description="Enter with {0} and {1}")
		public void loginuser(String username,String password)
		{
			sendKeys(username,"txt.username");
			sendKeys(password,"txt.password");
			WebDriverWait wait=new WebDriverWait(driver, 30);
			WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
			
			Actions action = new Actions(driver);
			action.moveToElement(buttonlog).click().build().perform();
				
			
//			WebDriverWait wait=new WebDriverWait(driver, 30);
//			JavascriptExecutor js=(JavascriptExecutor)driver;
//			boolean  buttonlog2=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//button[@type='submit']")));
//			WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
//			js.executeScript("arguments[0].click();", buttonlog);
			//buttonlog.click();
		}
		//By slider=By.xpath("//div[@id='mCSB_2_scrollbar_vertical']//div[@id='mCSB_2_dragger_vertical']");
		/*public WebElement findElement(By locator) 
		{
			WebDriverWait wait=new WebDriverWait(driver, 30);
 
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
			}*/
		public WebElement findHiddenElement(By locator) {
			WebDriverWait wait=new WebDriverWait(driver, 30);
			  return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			}
		
		
		@QAFTestStep(description="Click on the R&R Side Menu")
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
			WebElement  brightSpark=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Bright Spark')]")));
			js.executeScript("arguments[0].click();", brightSpark);
			WebElement card=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"addBrightSparkForm\"]/div/div[1]/div[2]/div[1]/img")));
			js.executeScript("arguments[0].click();", card);
			for(int i=0; i<=2;i++){
				try {
			WebElement selNominee=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@ng-disabled='disabled'])[2]")));
			//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(selNominee)));
			js.executeScript("arguments[0].click();", selNominee);
			Actions nomineeaction=new Actions(driver);
			WebElement selNomineeName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text']")));
			WebElement selNominee1=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Virat Kohali')]")));
			nomineeaction.moveToElement(selNomineeName).click().sendKeys("Virat Kohali").sendKeys(selNominee1,Keys.ENTER).perform();
			break;
				}
				catch(Exception e2)
				{
					e2.getMessage();
			Thread.sleep(4000);
				}
			}
			for(int i=0; i<=2;i++){
			try {
			WebElement SelProject=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-disabled='disabled'])[3]")));
			//SelProject.click();
			//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(SelProject)));
			js.executeScript("arguments[0].click();", SelProject);
			Actions nomineeaction2=new Actions(driver);
			WebElement project=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[1]")));
			WebElement projectName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Test Project 2')]")));
			nomineeaction2.moveToElement(project).click().sendKeys("Test Project 2").sendKeys(projectName,Keys.ENTER).perform();
			break;
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			}
			//WebElement SelProject2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@ng-disabled='disabled'])[3]")));
			
			WebElement challSituat=driver.findElement(By.xpath("//textarea[@name='challenging_situations']"));
			challSituat.sendKeys("Self-Improvisation of Communications");
			WebElement soluProvider=driver.findElement(By.xpath("//textarea[@name='solution_provided']"));
			soluProvider.sendKeys("Good to have key skills");
			WebElement benefits=driver.findElement(By.xpath("//textarea[@name='benefits_accrued']"));
			benefits.sendKeys("Allowances");
			WebElement nomination=driver.findElement(By.xpath("//textarea[@name='rational_for_nomination']"));
			nomination.sendKeys("My Collegaues");
			WebElement postbutton=driver.findElement(By.xpath("//button[contains(text(),' Post')] "));
			js.executeScript("arguments[0].click();", postbutton);
			//Actions nomineeaction2=new Actions(driver);
			
			//.sendKeys(projectName, Keys.ENTER).build().perform();
			//selNomineeName.sendKeys("Virat Kohali");
			
			//actions.clickAndHold(dragger).moveByOffset(0,5000).release().perform();
			/*EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
			//eventFiringWebDriver.executeScript("scroll(100,200)");
			eventFiringWebDriver.executeScript("document.getElementById('mCSB_2_dragger_vertical').scrollTop = 200");
			
			//driver.switchTo().frame("IframeData");
			Actions builder = new Actions(driver);
			WebElement slider=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='sliderContainer']")));
			
			//WebElement slider=driver.findElement(By.xpath("//div[@class='sliderContainer']"));
			slider.isDisplayed();
			
			WebElement waitForPres2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='mCSB_2_dragger_vertical']")));
			WebElement slider2=driver.findElement(By.xpath("//div[@id='mCSB_2_dragger_vertical']"));
			builder.moveToElement(slider).moveToElement(waitForPres2).click().dragAndDropBy(waitForPres2,0,5000).build().perform();*/
			//Assert.assertTrue(slider2.isDisplayed());
			//Dimension sliderSize =  slider2.getSize();
			//int xCoord = slider2.getLocation().getX();
			//int sliderWidth = sliderSize.getWidth();
			
			/*WebElement priceSlider = 
					   findElement(slider);
			WebElement priceSlider1 = 
					   findElement(slider2);*/
			
			//builder.moveToElement(slider2).clickAndHold(slider2).moveByOffset(10,5000).release().perform();
			/*builder.moveToElement(slider2).click().dragAndDropBy(slider2,0,5000);*/
			Thread.sleep(4000);
			/*Assert.assertTrue(priceSlider.isEnabled());
			Assert.assertTrue(priceSlider.isDisplayed());
			
			Dimension sliderSize =  priceSlider.getSize();
			int sliderWidth = sliderSize.getWidth();
			
			int xCoord = priceSlider.getLocation().getX();*/
							
			/*Actions builder = new Actions(driver);   
			builder.moveToElement(priceSlider)
				   .click()
				   .dragAndDropBy
				     (priceSlider,xCoord + sliderWidth, 0)
				   .build()
				   .perform();*/
			
			
			
			
			
			
			/*
			//JavascriptExecutor js=(JavascriptExecutor)driver;
			driver.manage().window().maximize();
			WebDriverWait wait=new WebDriverWait(driver, 30);
			JavascriptExecutor jsExec = (JavascriptExecutor) driver;
			jsExec.executeScript("document.getElementById('mCSB_2_scrollbar_vertical').scrollIntoView(true);");

			//WebElement scrollBar=driver.findElement(By.xpath("//div[@id='mCSB_2_dragger_vertical']"));
			//WebElement  buttonlog3=driver.findElement(By.xpath("//li[@class='active parent_li ng-scope']/span[contains(text(),'R & R')]"));		
			
			//action1.moveToElement(sideslider2).clickAndHold().keyDown(Keys.DOWN);
			
			try
		    {     
				WebDriverWait wait=new WebDriverWait(driver, 30);
				int scrollPoints=100;
				Actions action1=new Actions(driver);
				boolean sideslider=wait.until(ExpectedConditions.elementToBeSelected(By.xpath("//div[@id='mCSB_2_scrollbar_vertical']//div[@id='mCSB_2_dragger_vertical']")));
				WebElement sideslider2=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='mCSB_2_scrollbar_vertical']//div[@id='mCSB_2_dragger_vertical']")));
						//(By.xpath("//div[@id='mCSB_2_scrollbar_vertical']//div[@id='mCSB_2_dragger_vertical']")));
				//boolean sideslider3=wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='mCSB_2_scrollbar_vertical']//div[@id='mCSB_2_dragger_vertical']")));
				//WebElement sideslider=driver.findElement(By.xpath("//div[@id='mCSB_2_dragger_vertical']"));
				
		        // drag downwards
		        int numberOfPixelsToDragTheScrollbarDown = 10;
		        for (int i = 10; i < scrollPoints; i = i + numberOfPixelsToDragTheScrollbarDown)
		        {
		        	action1.moveToElement(sideslider2).clickAndHold().moveByOffset(0, numberOfPixelsToDragTheScrollbarDown).release(sideslider2).build().perform();
		        }
		        Thread.sleep(500);
		        return true;
		    }
		    catch (Exception e)
		    {
		        e.printStackTrace();
		        return false;
		    }*/
			
			//js.executeScript("window.scrollBy(0,250)",scrollBar);
			//js.executeScript("arguments[0].scrollIntoView(true);",scrollBar);
			//WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='active parent_li ng-scope']/span[contains(text(),'R & R')]")));			
			//js.executeScript("arguments[0].click();", buttonlog);
			//buttonlog.click();
			//waitForVisible("randrSubmenu");
			//WebElement  buttonlog2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='ng-scope left_menu_close_section']/span[contains(text(),'Nominate')]")));
			//QAFExtendedWebElement SubMenuRandr=new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("randrSubmenu")));
			//buttonlog2.click();

		}

}

