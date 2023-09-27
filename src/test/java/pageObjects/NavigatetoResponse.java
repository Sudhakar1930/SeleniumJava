package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigatetoResponse extends BasePage{

	public NavigatetoResponse(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//WebElements
	@FindBy(xpath="//input[@placeholder='E-Mail']")
	WebElement txtLoginEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtLoginPwd;
	
	@FindBy(css="button[type='submit']")
	WebElement btnSubmitLogin;
	
	@FindBy(xpath="//span[@title='Clear all']")
	WebElement btnClearAll;
	
	@FindBy(xpath="//*[@id='formList']/div/div/div[2]/input")
	WebElement txtBuildName;
	
	@FindBy(css="i.material-icons.gap.rotate.comman.down")
	WebElement btnBuildSideBar;
	
	@FindBy(css="i.material-icons.gap.rotate.comman2")
	WebElement btnSideBarResult;
	
	@FindBy(xpath="//span[normalize-space()='Responses']")
	WebElement btnSideItemResponses;
	
	@FindBy(css="button.resp-filter-x")
	WebElement btnRefreshResponse;
	
	@FindBy(xpath="(//i[@class='material-icons sidebar-icon resp-page-icon ng-star-inserted'])[1]")
	WebElement lnkFirstResponse;
	
	//Set Text
	public void setEmailId(String strEmailId) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtLoginEmail, strEmailId);
	}
	
	public void setPassword(String strPassword) {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtLoginPwd, strPassword);
	
	}
	//Click Action
	
	public void clickSubmit() throws Exception {
		utilities.UtilityCustomFunctions.doClick(driver, btnSubmitLogin);
	}
	
	public void clickClearAll() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnClearAll);
		btnClearAll.click();
	}
	
	public void clickSideBarBldBtn() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnBuildSideBar);
		btnBuildSideBar.click();
		
	}
	
	public void clickSideBarResult() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnSideBarResult);
		btnSideBarResult.click();
	}
	public void clickSideItemResp() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnSideItemResponses);
		btnSideItemResponses.click();
	}
	public void clickRefreshResponse() throws Exception {
		//utilities.UtilityCustomFunctions.doClick(driver, btnRefreshResponse);
		btnRefreshResponse.click();
	}
	public void clickFirstResponse() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", lnkFirstResponse);
	}
	
	//Set Methods
	public void setBuildName(String strBuildName) throws Exception {
		utilities.UtilityCustomFunctions.sendKeys(driver, txtBuildName, strBuildName);
	}
	
	public void KeyEnterBuildName() throws Exception {
		txtBuildName.sendKeys(Keys.ENTER);
		//utilities.UtilityCustomFunctions.sendKeys(driver, txtBuildName, "Keys.ENTER");
	}
	
	
	
	
	
	
	
	
	
	
		

}
