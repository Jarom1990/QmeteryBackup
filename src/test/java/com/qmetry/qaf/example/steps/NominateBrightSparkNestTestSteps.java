package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

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

public class NominateBrightSparkNestTestSteps extends WebDriverBaseTestPage<WebDriverTestPage> {

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
		WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		
		Actions action = new Actions(driver);
		action.moveToElement(buttonlog).click().build().perform();
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
		WebElement projectName=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Nest Test')]")));
		Thread.sleep(4000);
		nomineeaction2.moveToElement(project).click().sendKeys("Nest Test").sendKeys(projectName,Keys.ENTER).perform();
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
		Thread.sleep(4000);
	}
}
