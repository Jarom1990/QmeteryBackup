package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class LogOutFunctionalityTestSteps extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	//Login With Valid Credentials into InfoStretch
	
		@QAFTestStep(description="Enter with {0} and {1}")
		public void loginuser(String username,String password) throws InterruptedException
		{
			sendKeys(username,"txt.username");
			sendKeys(password,"txt.password");
			WebDriverWait wait=new WebDriverWait(driver, 30);
			WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//class[@type='submit']")));
			buttonlog.click();
			Thread.sleep(4000);
		}
		@QAFTestStep(description="Clicking on LogOut Button")
		public void loginOut()
		{
			 
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(100,TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 30);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			//wait.until(ExpectedConditions.invisibilityOfElementLocated("//div[@class='loader-div loader ng-isolate-scope']"));
			WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@class='settings_btn1'])[1]")));
			executor.executeScript("arguments[0].click();", buttonlog);
			/*WebElement logout=driver.findElement(By.xpath("(//img[@class='settings_btn1'])[1]"));
			logout.click();*/
		}
		@QAFTestStep(description="Verify Login Page after LogOut")
		public void loginDefault()
		{
			String actualTitle=driver.getTitle();
			Assert.assertTrue(actualTitle.contains("Infostretch NEST"));
			System.out.println("Matched");
		}
}
