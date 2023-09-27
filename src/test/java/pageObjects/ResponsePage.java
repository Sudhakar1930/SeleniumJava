package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResponsePage extends BasePage {
	public ResponsePage(WebDriver driver) {
		super(driver);
	}
	//WebElements
	@FindBy(xpath="(//label[@class='epsf-ans-myqlbl'])[1]")
	WebElement lblRespMsg;
	
	@FindBy(xpath="//button[contains(@class,'fp-close')]")
	WebElement lnkCloseResponse;

	@FindBy(xpath="//*[@id='ssIFrame_google']")
	WebElement iFrameForClose;
	
	//MultiChoiceResponseQuestion1
	@FindBy(css="label[class='epsf-ans-myqlbl']")
	WebElement lblMultiChoiceTitle;
			
	//MultiChoiceResponseQuestion1
	@FindBy(xpath="//label[@class='epsf-ans-ans']")
	WebElement lblMultiChoiceAnswer;
			
			
	
			
	
	public void setFrametossIFrame(WebDriver driver) {
		driver.switchTo().frame(iFrameForClose);
	}
	
	
	//get Methods
	public String getResponseTitle1() {
		String sMCMsg = lblMultiChoiceTitle.getText();
		return sMCMsg;
	}
	
	public String getResponseAnswer1() {
		String sResponseAnswer1 = lblMultiChoiceAnswer.getText();
		return sResponseAnswer1;
	}
	public String getRespMsg1() {
		String sRespMsg = lblRespMsg.getText();
		return sRespMsg;
	}
	
	public void fCloseResponse()
	{
		lnkCloseResponse.click();
	}
	
}
