package pageObjects;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import junit.framework.Assert;

public class IndvControlsPage extends BasePage{
	public IndvControlsPage(WebDriver driver) {
		super(driver);
	}
	public static WebElement eleCurrDate;
	
		
		//WebElements
		@FindBy(xpath="//*[@id='rootdiv']/div/h3")
		WebElement lblMessageTitle;
		
		@FindBy(xpath="//*[@id='rootdiv']/p/button/span")
		WebElement btnMessageNext;
		
		//Multi Choice WebElement
		@FindBy(xpath="//*[@id='rootdiv']/div/h3")
		WebElement lblMutiChoiceTitle;
		
	
		@FindBy(xpath="//*[@id='rootdiv']/ul")
		WebElement SelectOneChoice;
		
		
		@FindBy(xpath="//button[normalize-space()='next']")
		WebElement btnGeneralNext;
		
		@FindBy(css="div[class='ql-editor'] h3")
		WebElement lblGeneralTitle;
		
		@FindBy(css="#textquestion_textarea")
		WebElement txtTextQuestionInput;
	
		@FindBy(xpath="	//input[@id='ems_email']")
		WebElement txtEmailInput;
	
		@FindBy(id="phs_phonenumber")
//		@FindBy(xpath="//div[@class='cdk-overlay-container']")
		WebElement txtPhoneNumberInput;
		
		
		@FindBy(xpath="//my[@class='ng-star-inserted']")
		WebElement btnPhoneNumberNext;
		
		@FindBy(xpath="//button[normalize-space()='Book an appointment']")
		WebElement btnBookAppointment;
		
		//span[@class='mat-button-wrapper']//*[name()='svg']

		@FindBy(css="svg")
		WebElement btnApptDateIcon;
		
		
		@FindBy(xpath="//input[@placeholder='Choose Date']")
		WebElement btnChooseDate;
		
		@FindBy(xpath="(//*[name()='path'])[1]")
		WebElement btnSelectDate;
		
		@FindBy(xpath="//*[@id='mat-dialog-0']/app-timelist/div/div[2]/div/mat-datepicker-toggle/button")
		WebElement btnDateAgain;
		
		@FindBy(xpath="//div[contains(@class,'today')]")
		WebElement btnCurrentDate;
		
		@FindBy(xpath="//table[@class='mat-calendar-table']")
		WebElement WbTblAppointMent;
		
		@FindBy(css="button[type='text']")
		WebElement btnAppointmentTime;
		
		//div//button[@type='text']
		
		@FindBy(xpath="//table[@role='presentation']/tbody/tr")
		WebElement eleWbCalendarTbl;

		
		@FindBy(xpath="//div//h3/span")
		WebElement lblSecGenTitle;
		
		@FindBy(xpath="//div//h3")
		WebElement lblThirdGenTitle;
		
		
		@FindBy(xpath="//span[@class='dropdown-btn']")
		WebElement btnMultiSelectDropDown;
		
		//@FindBy(css="ul[class='item2']")
		@FindBy(css="ul[class='item2']")
		WebElement lstMultiSelectValues;
		
		@FindBy(xpath="(//ul)[1]")
		WebElement lstListValue;
		
		@FindBy(xpath="//input[@type='text']")
		WebElement txtListControl;
		
		
		@FindBy(xpath="//input[@id='numbershow']")
		WebElement txtNumberInput;
		
		@FindBy(xpath="//input[@id='rangeinput']")
		WebElement eleRangeSlider;
		
		
		@FindBy(xpath="//div//ul")
		WebElement lstElement;
		
		
		@FindBy(xpath="//iframe[@title='Form preview']")
		WebElement iFramePreview;
		
		
		@FindBy(xpath="//button[@aria-label='Next month']")
		WebElement btnNextMonth;
		
		@FindBy(xpath="//div[@class='msshow-container float']")
		WebElement lstRatingLabels;
		
		
		@FindBy(xpath="//button[@type='button']")
		WebElement btnDateIcon;
		
		
		
		@FindBy(xpath="//div[@id='rootdiv']//input")
		WebElement txtDateInput;
		//FileUpload
		@FindBy(xpath="//div[@class='fileupshow-body-div']")
		WebElement lnkFileUpload;
		
		
		
		@FindBy(xpath="//ul[@class='linkshow-container float']")
		WebElement btnLinksControl;
		
		
		@FindBy(css="div#rootdiv>p>button")
		WebElement btnGo;
		
		
		@FindBy(xpath="//label[@class='picmsgshow-valuelbl']")
		//List<WebElement> sLstPicMsgItems = driver.findElements(By.xpath("//label[@class='picmsgshow-valuelbl']"));
		List<WebElement> sLstPicMsgItems;
		//WebElement lstItemLabels;
		
		@FindBy(xpath="//div[@data-flg='1']")
		WebElement btnYes;
		
		@FindBy(xpath="//div[@data-flg='0']")
		WebElement btnNo;
		
		
		@FindBy(xpath="//span[@id='agreement_txt']")
		WebElement lblAgreementText;
		
		@FindBy(id="agg_check_btn")
		WebElement btnCheckAgreement;
		
		@FindBy(xpath="//table[@class='table-rscss']")
		WebElement btnRankMatrixTbl;
		
		@FindBy(xpath="//i[normalize-space()='mic']")
		WebElement btnVRMic;
		
		@FindBy(xpath="//i[normalize-space()='stop']")
		WebElement btnVRStop;
		
		@FindBy(xpath="//input[contains(@class,'gmshow-input myanimation')]")
		WebElement txtGoogleMapInput;
		
		
		@FindBy(xpath="p[class='ql-align-left'] span")
		WebElement lblSecMsgcontrol;
		
		
		//Get Methods
		public String getSectIndvMsg() {
			String sSFMessage = lblSecMsgcontrol.getText();
			return sSFMessage;
		}
		
		
		public String getAgreementMsg() {
			String sSFMessage = lblAgreementText.getText();
			return sSFMessage;
		}
		public String getSFMessage() {
			String sSFMessage = lblMessageTitle.getText();
			return sSFMessage;
		}
		
		public String getMultiChoiceTitle() {
			String sSFMessage = lblMutiChoiceTitle.getText();
			return sSFMessage;
		}
		public String getGeneralTitle() {
			String sSFMessage = lblGeneralTitle.getText();
			return sSFMessage;
		}
		public String getSecGenTitle() {
			String sSFMessage = lblSecGenTitle.getText();
			return sSFMessage;
		}
		
		public String getThirdGenTitle() {
			String sSFMessage = lblThirdGenTitle.getText();
			return sSFMessage;
		}
		public String getBtnApptMsg() {
			String sSFMessage = btnAppointmentTime.getText();
			return sSFMessage;
		}
		public static int getTimeSlots(WebElement lstElement) {
			List<WebElement> options = lstElement.findElements(By.tagName("li"));
			return options.size();
		}
		public String getDateSelected() {
			return txtDateInput.getAttribute("value");
		}
		
		
	//Click Methods
		public void clickMic() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver,btnVRMic);
		}
		public void clickStop() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver,btnVRStop);
		}
		public void clickYesorNo(String strItem) throws Exception {
			if(strItem.equals("Yes")) {
				utilities.UtilityCustomFunctions.doClick(driver,btnYes);
			}
			else {
				utilities.UtilityCustomFunctions.doClick(driver,btnNo);
			}
		}
		public void clickMatchingLabel(String strItem) throws Exception {
			utilities.UtilityCustomFunctions.clickMatchItem(strItem,lstRatingLabels);
		}
		
		public void clickPictMsgMatchLabel(String strItem) throws Exception {
			System.out.println("Size before calling: " + sLstPicMsgItems.size());
			utilities.UtilityCustomFunctions.findAndClick(strItem,sLstPicMsgItems);
		}
		public void clickThankYouGo() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnGo);
		}
		public void clickMessageNext() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnMessageNext);
		}
		public void clickGeneralNext() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnGeneralNext);
		}
		public void clickPhoneNumberNext() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnPhoneNumberNext);
		}
		public void clickBookAppointment() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnBookAppointment);
		}
		public void clickApptChooseDate() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnChooseDate);
		}
		public void clickApptDateIcon() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnDateAgain);
		}
		public void clickTodayDate() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnCurrentDate);
		}
		public void clickMSDropDown() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, btnMultiSelectDropDown);
		}
		public void clickListInput() throws Exception {
			utilities.UtilityCustomFunctions.doClick(driver, txtListControl);
		}
		public  static void clickFirstItem(WebElement lstElement) throws InterruptedException {
			List<WebElement> Slots = lstElement.findElements(By.tagName("li"));
			System.out.println(Slots.size());
			Thread.sleep(1000);
			for(WebElement Slot: Slots) {
				System.out.println("Time slot selected: " + Slot.getText());
				Slot.click();
				break;
			}
		}
	

		public void setAppointMentDate() throws InterruptedException {
			eleCurrDate = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
			String sTodayStatus = eleCurrDate.getAttribute("class");
			if(sTodayStatus.contains("disabled")) {
				System.out.println(sTodayStatus);
				utilities.UtilityCustomFunctions.clickDateAndGetslots(driver, eleWbCalendarTbl, eleCurrDate, lstElement, btnChooseDate);
			}
			else
			{
				eleCurrDate.click();
				System.out.println("Current Date Selected");
				int itslots = getTimeSlots(lstElement);
				System.out.println("Time Slots: "+ itslots);
				if(itslots==0) {
					btnChooseDate.click();
					utilities.UtilityCustomFunctions.clickDateAndGetslots(driver, eleWbCalendarTbl, eleCurrDate, lstElement, btnChooseDate);
				}
				else {
					clickFirstItem(lstElement);
				}
				
			}
		}
	//Select/Set Values
		public void setGoogleMapAddress(String strAddress) {
			utilities.UtilityCustomFunctions.sendKeys(driver, txtGoogleMapInput, strAddress);
		}
		
		
		@SuppressWarnings("deprecation")
		public void setAgreementCheckBox() {
			if(!btnCheckAgreement.isSelected()){
				Assert.assertEquals("Agreement checkbox checked", "Agreement checkbox Not selected");
				btnCheckAgreement.click();
			}
		}
		public void SelectFiletoUpload(String sFUPath) throws IOException {
			lnkFileUpload.click();
			Runtime.getRuntime().exec("D:\\Automation\\AutoITScript.exe"+ " " + "D:\\NewFile.txt");
		}
		public void selectOneItem(String strItem) throws Exception{
			System.out.println("SelectOneChoice:" + SelectOneChoice);
			utilities.UtilityCustomFunctions.selectOneItemfromListBox(driver, SelectOneChoice, strItem);
		}
		public void selectListItem(String strItem) throws Exception{
			
			utilities.UtilityCustomFunctions.selectOneItemfromListBox(driver, lstListValue, strItem);
		}
		public boolean setDate(String isNextMonthClicked)throws Exception{
			
			return utilities.UtilityCustomFunctions.clickDate(isNextMonthClicked,btnCurrentDate,btnDateIcon, btnNextMonth);
			
		}
		
		public String selectFirstAppointMent() throws Exception{
			return utilities.UtilityCustomFunctions.selectFirstListItem(driver, lstElement);
		}
		public void selectMultiItems(String strValues) throws Exception{
			utilities.UtilityCustomFunctions.selectMultiItemfromListBox(driver, lstMultiSelectValues, strValues);
		}
		public void clickLinks(String strLinks) throws Exception{
			utilities.UtilityCustomFunctions.clickLinkItems(driver, btnLinksControl, strLinks);
		}
		public void setTextAnswer(String sTextQuestion) throws Exception{
			utilities.UtilityCustomFunctions.sendKeys(driver, txtTextQuestionInput, sTextQuestion);
		}
		public void setEmail(String sEmail) throws Exception{
			utilities.UtilityCustomFunctions.sendKeys(driver, txtEmailInput, sEmail);
		}
		public void setPhoneNumber(String sPhoneNumber) throws Exception{
			utilities.UtilityCustomFunctions.sendKeys(driver, txtPhoneNumberInput, sPhoneNumber);
		}
		public String selectNextDate()throws Exception{
		return utilities.UtilityCustomFunctions.SelectNextAvailDate(driver,WbTblAppointMent, btnCurrentDate);
		}
		public void setNumber(String sNumber) throws Exception{
			utilities.UtilityCustomFunctions.sendKeys(driver, txtNumberInput, sNumber);
		}
		public void setRange(int iSliderValue) throws Exception{
			for(int i = 0;i<=iSliderValue;i++) {
				eleRangeSlider.sendKeys(Keys.ARROW_RIGHT);
			}
		}
		public void setRankingMatrix(String sRankValues) throws Exception{
			//setRankMatrix
			utilities.UtilityCustomFunctions.setRankMatrix(btnRankMatrixTbl, sRankValues);
		}
}
