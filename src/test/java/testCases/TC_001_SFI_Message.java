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
public class TC_001_SFI_Message extends BaseClass{
	
	@Test(dataProvider="SFI_Message" ,dataProviderClass=DataProviders.class,groups={"DataDriven"})
	public void Ind_Message(String sBuildUrl,String TextLabel,String EnterValue,String sBuildName,String sControl) {
		logger.info("******starting TC_001_SFI_Message ****");
		try{
			//if(RunFlag=="Yes") {
			SoftAssert sa = new SoftAssert();
			
			driver.get(sBuildUrl);
			logger.info("Survery Form Opened in a Browser");
			IndvControlsPage oIndCtrl = new IndvControlsPage(driver);
			String sActualMsg = oIndCtrl.getSFMessage();
			Assert.assertEquals(TextLabel.trim(), sActualMsg.trim());
			logger.info("Message Control Validation:" + sActualMsg);
			
			oIndCtrl.clickMessageNext();
			logger.info("Next Button Clicked to Submit the form");
			/*
			try {
			driver.close();
			}catch(Exception e) {
				Assert.fail(e.getMessage());
			}
			*/
			
			NavigatetoResponse(sBuildName, driver);
			logger.info("Navigated to Build: " + sBuildName);
			
			VerifySingleCtrlResponse(driver, TextLabel,sControl);
			logger.info("Response Verification completed");
			
			
			
			sa.assertAll();
			//}//If Run Flag
		}catch(Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
}
