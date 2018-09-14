package com.qmetry.qaf.example.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

public class LoginTestSteps extends WebDriverBaseTestPage<WebDriverTestPage>{

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
		buttonlog.click();
		String actualTitle=driver.getTitle();
		Assert.assertTrue(actualTitle.contains("Infostretch NEST"));
		System.out.println("Matched");
	}
}
