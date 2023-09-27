package testCases;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.IndvControlsPage;
import testBase.BaseClass;
import utilities.DataProviders;
public class TC_002_SFI_MultiChoice extends BaseClass{
	
	@Test(dataProvider="SFI_MultiChoice" ,dataProviderClass=DataProviders.class,groups={"DataDriven"})
	public void Ind_Message(String sBuildUrl,String TextLabel,String SelectValue,String sBuildName,String sControl) {
		logger.info("******starting TC_002_SFI_MultiChoice ****");
		try{
			//if(RunFlag=="Yes") {
			SoftAssert sa = new SoftAssert();
			
			driver.get(sBuildUrl);
			logger.info("Survey Form Opened in a Browser");
			IndvControlsPage oIndCtrl = new IndvControlsPage(driver);
			String sActualMsg = oIndCtrl.getMultiChoiceTitle();
		
			Assert.assertEquals(TextLabel.trim(), sActualMsg.trim());
			logger.info("Multi Choice Lable Validation:" + sActualMsg);
			//Select Item
			oIndCtrl.selectOneItem(SelectValue);
			logger.info("MultiChoice Item Selected is: " + SelectValue);
			oIndCtrl.clickGeneralNext();
			logger.info("Next Button Clicked to Submit the form");
			
			
			NavigatetoResponse(sBuildName, driver);
			logger.info("Navigated to Build: " + sBuildName);
			
			SingleQandAVerification(driver, TextLabel,SelectValue,sControl);
			logger.info("Response Verification completed");
			
			sa.assertAll();
			//}//If Run Flag
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
}
