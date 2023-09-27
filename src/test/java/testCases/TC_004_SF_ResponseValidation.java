package testCases;


import org.testng.annotations.Test;

import pageObjects.IndvControlsPage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.SurveyFormReUsables;


public class TC_004_SF_ResponseValidation extends BaseClass{
	
	
	@Test
	public void Test_Response_Val() {
		
		SurveyFormReUsables a = new SurveyFormReUsables();
		
		logger.info("Response Navigation started");
		try {
		
		String sPath=".\\testData\\" + "SFI_All_Tbl" + ".xlsx" ;
		ExcelUtility xlObj = new ExcelUtility(sPath);
		IndvControlsPage IndvObj = new IndvControlsPage(driver);
		
		logger.info("Excel file Utility instance created");
		int iRowCount = xlObj.getRowCount("Sheet1");
		System.out.println("Total rows: " + iRowCount);
		logger.info("Row Count is: " + iRowCount);
		
		int iColCount = xlObj.getCellCount("Sheet1", iRowCount);
		System.out.println("Cols: " + iColCount);
		logger.info("Col Count is: " + iColCount);
					
		logger.info("Extracting DataSheet Values started...");
		String sExpBuildUrl = xlObj.getCellData("Sheet1", 1, 0);
		String sExpBuildName = xlObj.getCellData("Sheet1", 1, 1);
		String sExpExcelFileName = xlObj.getCellData("Sheet1", 1, 2);
		String sExpTxtMessageTitle = xlObj.getCellData("Sheet1", 1, 3);
		System.out.println("MC title"+sExpTxtMessageTitle);
		String sExpMC_Title = xlObj.getCellData("Sheet1", 1, 4);
		String sExpMC_Value = xlObj.getCellData("Sheet1", 1, 5);
		String sExpXQ_Title = xlObj.getCellData("Sheet1", 1, 6);
		String sExpXQ_Value = xlObj.getCellData("Sheet1", 1, 7);
		String sExpEM_Title = xlObj.getCellData("Sheet1", 1, 8);
		String sExpEM_Value = xlObj.getCellData("Sheet1", 1, 9);
		String sExpPN_Title = xlObj.getCellData("Sheet1", 1, 10);
		String sExpPN_Value = xlObj.getCellData("Sheet1", 1, 11);
		String sExpAP_Title = xlObj.getCellData("Sheet1", 1, 12);
		
		String sExpAP_Value = xlObj.getCellData("Sheet1", 1, 13);
		
		String sExpMS_Title = xlObj.getCellData("Sheet1", 1, 14);
		String sExpMS_Value = xlObj.getCellData("Sheet1", 1, 15);
		String sExpLS_Title = xlObj.getCellData("Sheet1", 1, 16);
		String sExpLS_Value = xlObj.getCellData("Sheet1", 1, 17);
		String sExpNM_Title = xlObj.getCellData("Sheet1", 1, 18);
		String sExpNM_Value = xlObj.getCellData("Sheet1", 1, 19);
		String sExpRG_Title = xlObj.getCellData("Sheet1", 1, 20);
		String sExpRG_Value = xlObj.getCellData("Sheet1", 1, 21);
		String sExpRT_Title = xlObj.getCellData("Sheet1", 1, 22);
		String sExpRT_Value = xlObj.getCellData("Sheet1", 1, 23);
		String sExpOS_Title = xlObj.getCellData("Sheet1", 1, 24);
		String sExpOS_Value = xlObj.getCellData("Sheet1", 1, 25);
		String sExpDT_Title = xlObj.getCellData("Sheet1", 1, 26);
		String sExpDT_Value = xlObj.getCellData("Sheet1", 1, 27);
		String sExpUF_Title = xlObj.getCellData("Sheet1", 1, 28);
		String sExpUF_Value = xlObj.getCellData("Sheet1", 1, 29);
		String sExpLK_Title = xlObj.getCellData("Sheet1", 1, 30);
		String sExpLK_Value = xlObj.getCellData("Sheet1", 1, 31);
		String sExpTQ_Title = xlObj.getCellData("Sheet1", 1, 32);
		String sExpTQ_Value = xlObj.getCellData("Sheet1", 1, 33);
		String sExpPM_Title = xlObj.getCellData("Sheet1", 1, 34);
		String sExpPM_Value = xlObj.getCellData("Sheet1", 1, 35);
		String sExpYN_Title = xlObj.getCellData("Sheet1", 1, 36);
		String sExpYN_Value = xlObj.getCellData("Sheet1", 1, 37);
		String sExpAG_Title = xlObj.getCellData("Sheet1", 1, 38);
		String sExpAG_Value = xlObj.getCellData("Sheet1", 1, 39);
		String sExpRM_Title = xlObj.getCellData("Sheet1", 1, 40);
		String sExpRM_Value = xlObj.getCellData("Sheet1", 1, 41);
		String sExpVR_Title = xlObj.getCellData("Sheet1", 1, 42);
		String sExpVR_Value = xlObj.getCellData("Sheet1", 1, 43);
		String sExpGM_Title = xlObj.getCellData("Sheet1", 1, 44);
		String sExpGM_Value = xlObj.getCellData("Sheet1", 1, 45);
		String sExpSC_Title = xlObj.getCellData("Sheet1", 1, 46);
		String sExpSC_Value = xlObj.getCellData("Sheet1", 1, 47);
		
		
		logger.info("Extracting DataSheet Values Completed...");

		NavigatetoResponse(sExpBuildName, driver);
		logger.info("Navigated to Build: " + sExpBuildName);
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpTxtMessageTitle,1,"Message Control Header");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpMC_Title,2,"MultiChoice Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpMC_Value,1,"MultiChoice Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpXQ_Title,3,"Text Question Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpXQ_Value,2,"Text Question Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpEM_Title,4,"Email Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpEM_Value,3,"Email Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpPN_Title,5,"Phone Number Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpPN_Value,4,"Phone Number Control Answer");
		
		sExpAP_Value = xlObj.getCellData("Sheet1", 1, 13);
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpAP_Title,6,"Appointment Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpAP_Value,5,"Appointment Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpMS_Title,7,"MultiChoice Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpMS_Value,6,"MultiChoice Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpLS_Title,8,"List Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpLS_Value,7,"List Control Values");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpNM_Title,9,"Number Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpNM_Value,8,"Number Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpRG_Title,10,"Range Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpRG_Value,9,"Range Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpRT_Title,11,"Rating Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpRT_Value,10,"Rating Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpOS_Title,12,"Opinion Scale Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpOS_Value,11,"Opinion Scale Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpDT_Title,13,"Date Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpDT_Value,12,"Date Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpUF_Title,14,"FileUpload Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpUF_Value,13,"FileUpload Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpLK_Title,15,"Link Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpLK_Value,15,"Link Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpTQ_Title,17,"Thank You Control Question");
		//utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpTQ_Value,16,"Thank You Control Answer");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpPM_Title,18,"Picture Message Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpPM_Value,17,"Picture Message Control Question");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpPM_Title,18,"Picture Message Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpPM_Value,17,"Picture Message Control Question");
		
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,true,sExpYN_Title,19,"Yes or No Control Question");
		utilities.SurveyFormReUsables.ValidateAllIndResp(driver,false,sExpYN_Value,18,"Yes or No Control Question");
		
		
		
		
		a.sAssertinFn.assertAll();
		
		}catch (Exception e) {
			e.getCause();
		}
	}
	
}
