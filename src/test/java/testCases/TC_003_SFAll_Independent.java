package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.IndvControlsPage;
import testBase.BaseClass;
import utilities.ExcelUtility;
import utilities.SurveyFormReUsables;

public class TC_003_SFAll_Independent extends BaseClass{
	
	@Test
	public void testAllControls() throws Exception {
	
		//driver = new ChromeDriver();
		logger.info("******starting TC_003_SFAll_Independent ****");
		try{
			
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
//			Launch Url
			SurveyFormReUsables.fLaunchUrl(driver, sExpBuildUrl);
			logger.info("Survey Form Url Launched..");
			
			String sActTxtMessageTitle = IndvObj.getSFMessage();
			//Validation of Message Title
			SurveyFormReUsables.fVerifyValue(sActTxtMessageTitle,sExpTxtMessageTitle,"Message Control Title");
			logger.info("Validation of Message Control Title") ;
			
//			Click Message Next
			IndvObj.clickMessageNext();
			
//			MultiChoice Control Validation
			
			String sActMC_Title = IndvObj.getMultiChoiceTitle();
			logger.info(sActMC_Title +"Actual Title ");
			System.out.println(sActMC_Title);
			
			SurveyFormReUsables.fVerifyValue(sActMC_Title,sExpMC_Title,"MultiChoice Control Title");
			logger.info("Validation of MultiChoice Control Title") ;
			IndvObj.selectOneItem(sExpMC_Value);
			logger.info("MultiChoice Item Selected");
			IndvObj.clickGeneralNext();
			logger.info("MultiChoice Next Clicked");
			//TextQuestion Validation
			String sActXQ_Title = IndvObj.getGeneralTitle();
			SurveyFormReUsables.fVerifyValue(sActXQ_Title,sExpXQ_Title,"TextQuestion Control Title");
			logger.info("Validation of TextQuestion Control Title") ;
			
			IndvObj.setTextAnswer(sExpXQ_Value);
			logger.info("Text Entered in TextAnswer Control") ;
			IndvObj.clickGeneralNext();
			logger.info("Text Question Next Clicked") ;
			
			//Email Validation
			String sActEM_Title = IndvObj.getGeneralTitle();
			SurveyFormReUsables.fVerifyValue(sActEM_Title,sExpEM_Title,"Email Control Title");
			logger.info("Validation of Email Control Title") ;
			
			IndvObj.setEmail(sExpEM_Value);
			logger.info("Email Id Entered") ;
			IndvObj.clickGeneralNext();
			logger.info("Email Next Clicked") ;
			
			//Phone Number Validation
			String sActPN_Title = IndvObj.getGeneralTitle();
			SurveyFormReUsables.fVerifyValue(sActPN_Title,sExpPN_Title,"Phone Number Control Title");
			logger.info("Validation of PhoneNumber Control Title") ;
			
			IndvObj.setEmail(sExpEM_Value);
			IndvObj.setPhoneNumber(sExpPN_Value);
			logger.info("Phone Number Entered");
			IndvObj.clickPhoneNumberNext();
			logger.info("PhoneNumber Next Clicked") ;
			
			//Appointment
			String sActAP_Title = IndvObj.getGeneralTitle();
			SurveyFormReUsables.fVerifyValue(sActAP_Title,sExpAP_Title,"Appointment Control Title");
			logger.info("Validation of Appointment Control Title") ;
			
			String sAppFullTime="";
			IndvObj.clickBookAppointment();
			logger.info("Appointment Clicked");
			IndvObj.clickApptChooseDate();
			//IndvObj.clickTodayDate();
			
			IndvObj.setAppointMentDate();
			/*
			String sAppointmentTime = IndvObj.selectFirstAppointMent();
			
			
			if(IndvObj.selectFirstAppointMent()!=""){
				sAppFullTime = IndvObj.getBtnApptMsg();
				xlObj.setCellData("Sheet1", 1, 13, sAppFullTime);
				logger.info("Appointment Updated to Datasheet");
				System.out.println(sAppointmentTime);

			}
			else {
				Thread.sleep(1000);
				System.out.println("No dates Available");
				IndvObj.clickApptDateIcon();
				System.out.println("Date Icon clicked");
				Thread.sleep(2000);
//				IndvObj.clickApptChooseDate();
				String sAvailableday = IndvObj.selectNextDate();
				System.out.println(sAvailableday);
				sAppointmentTime = IndvObj.selectFirstAppointMent();
				sAppFullTime = IndvObj.getBtnApptMsg();
				xlObj.setCellData("Sheet1", 1, 13, sAppFullTime);
				logger.info("Appointment Updated to Datasheet");
				System.out.println(sAppFullTime);
				logger.info("Appointment Time Selected in Next Date");
			}
			*/
			Thread.sleep(1000);
			sAppFullTime = IndvObj.getBtnApptMsg();
			xlObj.setCellData("Sheet1", 1, 13, sAppFullTime);
			logger.info("Appointment Updated to Datasheet");
			System.out.println(sAppFullTime);
			
			
			
			sExpAP_Value = sAppFullTime;
			logger.info("Appointment Time Captured in Expected Value");
			Thread.sleep(1000);
			IndvObj.clickGeneralNext();
			logger.info("Appointment Next Button clicked");
			
			//MultiChoice
			String sActMS_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActMS_Title,sExpMS_Title,"MultiSelect Control Title");
			logger.info("Validation of MultiSelect Control Title") ;
			
			IndvObj.clickMSDropDown();
			System.out.println(sExpMS_Value);
			IndvObj.selectMultiItems(sExpMS_Value);
			logger.info("MultiSelect Value Selected") ;
			//IndvObj.clickMSDropDown();
			
			IndvObj.clickGeneralNext();
			//List
			String sActLS_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActLS_Title,sExpLS_Title,"List Control Title");
			logger.info("Validation of List Control Control Title") ;
			
			IndvObj.clickListInput();
			Thread.sleep(1000);
			IndvObj.selectListItem(sExpLS_Value);
			logger.info("List Item Selected " + sExpLS_Value);
			IndvObj.clickGeneralNext();
			logger.info("List Next Clicked");
			
			//Number
			String sActNM_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActNM_Title,sExpNM_Title,"Number Control Title");
			logger.info("Validation of Number Control Control Title") ;
			
			IndvObj.setNumber(sExpNM_Value);
			logger.info("Number Selected " + sExpNM_Value);
			IndvObj.clickGeneralNext();
			logger.info("Number Next Clicked");
			
			//Range
			String sActRG_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActRG_Title,sExpRG_Title,"Range Control Title");
			logger.info("Validation of Range Control Control Title") ;
			
			IndvObj.setRange(Integer.parseInt(sExpRG_Value));
			logger.info("Range Selected " + sExpRG_Value);
			IndvObj.clickGeneralNext();
			logger.info("Range Next Clicked");
			
			//Rating
			String sActRT_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActRT_Title,sExpRT_Title,"Rating Control Title");
			logger.info("Validation of Rating Control Control Title") ;

			IndvObj.clickMatchingLabel(sExpRT_Value);
			logger.info("Rating Value: " + sExpRT_Value + "Clicked");
			Thread.sleep(1000);
			IndvObj.clickGeneralNext();
			logger.info("Rating Next Clicked");
			
			//Opinion scale
			String sActOS_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActOS_Title,sExpOS_Title,"Opinion Scale Control Title");
			logger.info("Validation of Opinion Scale Control Title") ;
			
			IndvObj.selectOneItem(sExpOS_Value);
			logger.info("Opinion Scale : " + sExpOS_Value + "Clicked");
			IndvObj.clickGeneralNext();
			logger.info("Opinion Scale Next Clicked");
			
			//Select Date
			
			String sActDT_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActDT_Title,sExpDT_Title,"Date Control Title");
			logger.info("Validation of Date Control Title") ;
			
		
			 boolean bDateReturnValue = false;
			 bDateReturnValue = IndvObj.setDate("No");
			 if(bDateReturnValue=false) {
				 bDateReturnValue = IndvObj.setDate("Yes");
			 }
			 
			 String sDateSelected = IndvObj.getDateSelected();
			 sExpDT_Value = sDateSelected;
			 xlObj.setCellData("Sheet1", 1, 27, sDateSelected);
			 logger.info("Date Value Updated to DataSheet");
		     System.out.println(sDateSelected);
				
			 IndvObj.clickGeneralNext();
			 logger.info("Date Next Clicked");
			 
			 //Upload file
			 String sActUF_Title = IndvObj.getSecGenTitle();
			 SurveyFormReUsables.fVerifyValue(sActUF_Title,sExpUF_Title,"File Upload Title");
			 logger.info("Validation of File Upload Control Title") ;

			 IndvObj.SelectFiletoUpload(sExpUF_Value);
			 Thread.sleep(3000);
			 IndvObj.clickGeneralNext();
			 logger.info("FileUpload Next Clicked");
//			 
			 
			 //Links Validation
			 Thread.sleep(1000);
			 String sActLK_Title = IndvObj.getSecGenTitle();
			 SurveyFormReUsables.fVerifyValue(sActLK_Title,sExpLK_Title,"Link Control Title");
			 logger.info("Validation of Link Control Title" + sActLK_Title) ;
			 
			 System.out.println("Link Value:" +sExpLK_Value);
			 //IndvObj.clickLinks(sExpLK_Value);
			 logger.info("Multiple Links Clicked") ;
				
			 IndvObj.clickGeneralNext();
			 logger.info("Links Next Clicked");
			 
			 //Thank You
		
//			 sExpTQ_Value
			 
			 String sActTQ_Title = IndvObj.getGeneralTitle();
			 SurveyFormReUsables.fVerifyValue(sActTQ_Title,sExpTQ_Title,"ThankYou Control Title");
			 logger.info("Validation of ThankYou Control Title" + sActTQ_Title) ;
			 
			 IndvObj.clickThankYouGo();
			 logger.info("ThankYou Next Clicked");
			 
			 //Picture Message Control
			 Thread.sleep(1000);
			 String sActPM_Title = IndvObj.getGeneralTitle();
			 SurveyFormReUsables.fVerifyValue(sActPM_Title,sExpPM_Title,"Picture Message Control Title");
			 logger.info("Validation of Picture Message Control Title" + sActPM_Title) ;
			 
			
			// 
			 
			 IndvObj.clickPictMsgMatchLabel(sExpPM_Value);
			 logger.info("Picture Message Seleted:" + sExpPM_Value);
			 Thread.sleep(1000);
			 IndvObj.clickGeneralNext();
			 logger.info("Picture Message Next Clicked");
			 
			//Yes or No
			 Thread.sleep(1000);
			 String sActYN_Title = IndvObj.getGeneralTitle();
			 SurveyFormReUsables.fVerifyValue(sActYN_Title,sExpYN_Title,"Yes or No Control Title");
			 logger.info("Validation of YesorNo Control Title" + sActYN_Title) ;
			 
			 IndvObj.clickYesorNo(sExpYN_Value);
			 IndvObj.clickGeneralNext();
			 logger.info("YesorNo Next Clicked");
			 
			 //Agreement Control
			 Thread.sleep(1000);
			 String sActAG_Title = IndvObj.getSecGenTitle();
			 SurveyFormReUsables.fVerifyValue(sActAG_Title,sExpAG_Title,"Agreement Control Title");
			 logger.info("Validation of Agreement Control Title" + sActAG_Title) ;
			 
			String sActAG_Text = IndvObj.getAgreementMsg();
			SurveyFormReUsables.fVerifyValue(sActAG_Text,sExpAG_Value,"Agreement Text");
			logger.info("Validation of Agreement Text" + sActAG_Text) ;
			
//			IndvObj.setAgreementCheckBox();
//			logger.info("Agreement CheckBox Clicked");
			IndvObj.clickGeneralNext();
			logger.info("Agreement Next Clicked");
			 
			//Ranking Matrix
			Thread.sleep(1000);
			String sActRM_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActRM_Title,sExpRM_Title,"Ranking Matrix Control Title");
			logger.info("Validation of Agreement Control Title" + sActRM_Title) ;
			
			
			IndvObj.setRankingMatrix(sExpRM_Value);
			logger.info("Ranking Matrix Values Selected");
			IndvObj.clickGeneralNext();
			logger.info("Ranking Matrix Next Clicked");
			
			//VR
			Thread.sleep(1000);
			String sActVR_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActVR_Title,sExpVR_Title,"Voice Record Control Title");
			logger.info("Validation of Voice Record Control Title" + sActVR_Title) ;
			
			//Record & PlayBack
			IndvObj.clickMic();
			Thread.sleep(5000);
			IndvObj.clickStop();
			
			logger.info("Voice Recorded");
			IndvObj.clickGeneralNext();
			logger.info("Voice Record Next Clicked");
			
			//Google Map
			Thread.sleep(1000);
			String sActGM_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActGM_Title,sExpGM_Title,"Voice Record Control Title");
			logger.info("Validation of Google Map Control Title" + sActGM_Title) ;
			
			IndvObj.setGoogleMapAddress(sExpGM_Value);
			logger.info("Address Entered in Google Map");
			IndvObj.clickGeneralNext();
			logger.info("Google Map Next Clicked");
			
			//Google Map
			Thread.sleep(1000);
			String sActSC_Title = IndvObj.getSecGenTitle();
			SurveyFormReUsables.fVerifyValue(sActSC_Title,sExpSC_Title,"Section Control Title");
			logger.info("Validation of Section Control Title" + sActSC_Title) ;
			
			IndvObj.clickGeneralNext();
			logger.info("Section UI Next Clicked");
			
		
		}
	catch(Exception e) {
			System.out.println(e.getCause());
			Assert.fail(e.getMessage());
		}
	}
	
}
