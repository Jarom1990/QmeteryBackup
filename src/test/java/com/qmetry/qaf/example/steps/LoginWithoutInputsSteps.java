package com.qmetry.qaf.example.steps;

import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

public class LoginWithoutInputsSteps extends WebDriverBaseTestPage<WebDriverTestPage>{

	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}
	@QAFTestStep(description="Enter with {0} and {1}")
	public void loginuser(String username,String password) throws InterruptedException
	{
		sendKeys(username,"txt.username");
		sendKeys(password,"txt.password");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement  buttonlog=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),' LOGIN')]")));
		Actions action = new Actions(driver);
		action.moveToElement(buttonlog).click().build().perform();
		Thread.sleep(4000);
		js.executeScript("arguments[0].click();", buttonlog);
		driver.getAlert().getText();
	}

}
