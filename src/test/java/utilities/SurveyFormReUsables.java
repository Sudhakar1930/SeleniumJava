package utilities;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import utilities.ExcelUtility;


import pageObjects.IndvControlsPage;
import testBase.BaseClass;
import testCases.TC_004_SF_ResponseValidation;

public class SurveyFormReUsables{
	public static SoftAssert sAssertinFn = new SoftAssert();
	public static void sendKeys(WebDriver webDriver, WebElement element, String keyValue) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) webDriver;
			//js.executeScript("arguments[0].scrollIntoView();", element);
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			Actions action = new Actions(webDriver);
			action.moveToElement(element).doubleClick().build().perform();
			element.sendKeys(keyValue);
		}
		catch(Exception e){
			System.out.println(e.getStackTrace());
		}
	}
	
	public static void fLaunchUrl(WebDriver driver,String sUrl) {
		try {
		driver.get(sUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		}catch (Exception e) {
			Assert.fail("Browser Launch failed");
		}
	}
	
	public static void fVerifyValue(String sActValue, String sExpValue,String sMessage) {
		try {
			Assert.assertEquals(sActValue.trim(), sExpValue.trim(),sMessage);
			
		}catch(Exception e) {
			Assert.fail(sMessage + " Failed");
		}
	}
	
	public static void SelectMultiValues (String sChoiceValues) {
		sChoiceValues.split(",");
	}
	
//	for(int i=1; i<=23; i++)
//	{
//	    String xPathWithVariable = "(//div[@class='className'])" + "[" + i + "]";
//	    driver.FindElement(By.XPath(xPathWithVariable)).Click();
//	}
	public static void ValidateIndvAllResponse() throws IOException {
		String slPath=".\\testData\\" + "SFI_All_Tbl_ExpValues" + ".xlsx" ;
		ExcelUtility xlRespObj = new ExcelUtility(slPath);
		int iRespRowCount = xlRespObj.getRowCount("Sheet1");
		System.out.println("Response values count: " + iRespRowCount);
		System.out.println("Resp columns count: " + xlRespObj.getCellData("Sheet1", 1,1));
		
		for(int i=1;i<=iRespRowCount;i++) {
		
			
			
			System.out.println(xlRespObj.getCellData("Sheet1", i, 1));
		}
		
		
	}
	
	public static void ValidateAllIndResp(WebDriver driver,boolean bQuestion,String sExpValue,int iXpathIndex,String sValMessage) throws InterruptedException {
		System.out.println("Inside ValidateAllResp function");
		
		String sActRespVal="";
		String xPathWithVariable="";
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@title='Form preview'])[1]"));
		driver.switchTo().frame(iframe1);
		if(bQuestion==true) {
			System.out.println("Inside If true");
			 xPathWithVariable = "(//label[@class='epsf-ans-myqlbl'])" + "[" + iXpathIndex + "]";
			
			Thread.sleep(1000);
			sActRespVal = driver.findElement(By.xpath(xPathWithVariable)).getText();
			System.out.println("Actual value is: " + sActRespVal);
		}
		else
		{
			System.out.println("Inside If false");
			 xPathWithVariable = "(//label[@class='epsf-ans-ans'])" + "[" + iXpathIndex + "]";
			sActRespVal = driver.findElement(By.xpath(xPathWithVariable)).getText();
			
		}
		WebElement element = driver.findElement(By.xpath(xPathWithVariable));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		BaseClass.logger.info(sValMessage + " Expected Value:" + sExpValue + " Actual Value: " + sActRespVal );
		System.out.println(xPathWithVariable);
		
		driver.switchTo().defaultContent();
		
		sAssertinFn.assertEquals(sActRespVal, sExpValue,sValMessage);
		
		
	}
	
}
