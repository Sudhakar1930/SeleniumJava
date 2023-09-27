package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import pageObjects.IndvControlsPage;
import testBase.BaseClass;
public class UtilityCustomFunctions extends IndvControlsPage {

	static List<WebElement> trows;
	static List<WebElement> tcols;
	
	public UtilityCustomFunctions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	

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
	
	}//function end
	public static boolean selectMultiItemfromListBox(WebDriver webDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(webDriver);
		boolean flag = false;
		
		try {
			((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				String arrValues[]=textValue.split(",");
				element.click();
				Thread.sleep(1000);
				List<WebElement> options = element.findElements(By.tagName("li"));
//				System.out.println(arrValues.length);
//				System.out.println("List Item Size:"+options.size());
				for(int i=0;i<arrValues.length;i++) {
					for (WebElement option : options) {
						System.out.println("Option in List Box is : "+option.getText());
						System.out.println("Expected Value to be clicked is: " + arrValues[i]);
						if (arrValues[i].equalsIgnoreCase(option.getText().trim())) {
							
							System.out.println("Inside loop clicked Item is: " + option.getText());
							System.out.println("Inside click loop expected value to clicked is: " + arrValues[i]);
							BaseClass.logger.info("Expected Value:" + arrValues[i]);
							BaseClass.logger.info("DropDown Value:" + option.getText());
							option.click();
							break;
							
						}
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	
	public static boolean selectFromComboBox(WebDriver webDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(webDriver);
		boolean flag = false;
		try {
			((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			if (element.isDisplayed() || element.isEnabled()) {
				List<WebElement> options = element.findElements(By.tagName("option"));
				for (WebElement option : options) {
					if (textValue.equalsIgnoreCase(option.getText().trim())) {
						option.click();
						System.out.println("[" + textValue + "] is selected");
						BaseClass.logger.info("[" + textValue + "] is selected in Dropdown");
						flag = true; break;
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	public static boolean selectOneItemfromListBox(WebDriver webDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(webDriver);
		boolean flag = false;
		
		try {
			((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				Thread.sleep(3000);
				List<WebElement> options = element.findElements(By.tagName("li"));
				System.out.println("List Item Size:"+options.size());
				for (WebElement option : options) {
					if (textValue.equalsIgnoreCase(option.getText().trim())) {
						option.click();
						System.out.println("[" + textValue + "] is selected");
						BaseClass.logger.info("[" + textValue + "] is selected in List");
						flag = true; break;
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
	
	
	
	/**
	 * This method is will performs click action on the element
	 * @param element Holds the Web element
	 * @return return the boolean value
	 * @throws Exception 
	 */
	public static boolean doClick(WebDriver webDriver, WebElement element) throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		boolean isClicked = false;
		try {
			//js.executeScript("arguments[0].scrollIntoView(true);", element);
			//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//js.executeScript("window.scrollBy(0,3000)");
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].click();", element);
			//BaseClass.logger.info("Clicked...." + element.getAttribute("value"));
			//System.out.println("click element name : " + element.getAttribute("innerText"));
			/*
			Actions action = new Actions(webDriver);
			action.moveToElement(element).click().build().perform();
			*/
			isClicked = true;
		}  catch (Exception ex) {
			//Reporter.log("Exception occured while doClick event " + ex.getMessage());
			System.out.println("Exception occured while doClick event " + ex.getMessage());
			throw ex;
		}
		return isClicked;
	}

	/**
	 * This method helps to get text from web element
	 * @param driver The WebDriver
	 * @param element  Holds the web element
	 * 
	 * @return Returns the String
	 * @throws Exception 
	 */
	public static String getValue(WebDriver webDriver, WebElement element) throws Exception{
		String actualValue = null;
		JavascriptExecutor js = (JavascriptExecutor) webDriver;
		try {
			WebDriverWait webWait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
			webWait.until(ExpectedConditions.elementToBeClickable(element));
			webWait.until(ExpectedConditions.visibilityOf(element));
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			actualValue = element.getText();
		}  catch (Exception ex) {
			//Reporter.log("Exception occured while getValue event " + ex.getMessage());
			System.out.println("Exception occured while getValue event " + ex.getMessage());
			//throw ex;
		}
		return actualValue;
	}
	
	
	public static String selectFirstListItem(WebDriver driver, WebElement element) {
		//waitForJQueryToLoad(webDriver);
		String strFirstItem="";

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				Thread.sleep(3000);
				List<WebElement> options = element.findElements(By.tagName("li"));
				System.out.println("List Item Size:"+options.size());
				if(options.size()!=0) {
				for (WebElement option : options) {
						strFirstItem = option.getText();
						option.click();
						System.out.println("[" + option.getText() + "] is selected");
						BaseClass.logger.info("[" + option.getText() + "] is selected in List");
						
						break;
					}//for loop
				}
				else {
					//Select Next Enabled Date
					
					strFirstItem="";
					
				}// if options!=0
				
				}// if isDisp/isEnab
			
				
			
	
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
			Assert.fail("Date Not Selected");
		}
		return strFirstItem;
		
	}//function end
	
	public static String SelectNextAvailDate(WebDriver driver, WebElement WbTblAppointMent,WebElement btnCurrentDate) {
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", WbTblAppointMent);
		String sDateAttribute="";
		String sDay = "";
		List<WebElement> trows = WbTblAppointMent.findElements(By.tagName("tr"));
		
		System.out.println("trows:" + trows.size());
		
		for(WebElement trow: trows) {
			
			List<WebElement> tcols = trow.findElements(By.tagName("td"));
			for(WebElement tcol: tcols) {
				if(tcol.getText().length()<3) {
					System.out.println("Only Dates in Date Selection");
					if(Integer.parseInt(btnCurrentDate.getText())< Integer.parseInt(tcol.getText())) {
						sDateAttribute=tcol.getAttribute("class");
						if(sDateAttribute.contains("disabled")) {
							
						}
						else
						{
							sDay =tcol.getText();
							tcol.click();
							
							break;
						}//td disabled
					}
				}//get Only Dates
				
			}
			}//tcols
		return sDay;
		
	}//trows

    public static void clickDateAndGetslots(WebDriver driver,WebElement eleWbtbl,WebElement eleCurrDate,WebElement element,WebElement eleChooseDate) throws InterruptedException {
		int iSlotcount=0;
		
		tcols = driver.findElements(By.xpath("//table[@role='presentation']/tbody/tr/td"));
		System.out.println("Tcols  " + tcols.size());
//			tcols = eleWbtbl.findElements(By.tagName("td"));
			
			for (int j = 0; j < tcols.size(); j++) {
				tcols = driver.findElements(By.xpath("//table[@role='presentation']/tbody/tr/td"));
				System.out.println("hi");
//				tcols = eleWbtbl.findElements(By.tagName("td"));
				System.out.println("just");
				String sDateAttribute = tcols.get(j).getAttribute("class");
				System.out.println("passed class attri");
				if(tcols.get(j).getText().length()<3) {
					System.out.println("Inside first IF");
					eleCurrDate = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
					System.out.println("today found"+eleCurrDate.getText());
					
				
					if(Integer.parseInt(eleCurrDate.getText())< Integer.parseInt(tcols.get(j).getText())) {
						System.out.println("Inside second IF");
						
						if(sDateAttribute.contains("disabled")) {
//							driver.navigate().refresh();
						}
						else {
							tcols.get(j).click();
							Thread.sleep(1000);
							iSlotcount=getTimeSlots(element);
							
							if(iSlotcount==0) {
								System.out.println("Slot Count: " + iSlotcount);
								eleChooseDate.click();
								Thread.sleep(1000);
								continue;
							}else {
								//getFirstItem
								clickFirstItem(element);
								break;
							}//If slotcount 0 or not

						}// If date disabled

					}//Parsed comparison
                    
					System.out.println("curr date: " +tcols.get(j).getText());
				}//If values only 2 digits Only through Dates
			}
	}
	//ClickDate
    public  static boolean clickDate(String sNextMonthClicked,WebElement eleCurrDate,WebElement eleChooseDate,WebElement eleNextMonth) {
		boolean bIsDateSelected=false;
		if(sNextMonthClicked=="No") {
		eleChooseDate.click();
		}
		List<WebElement> tDateCols = driver.findElements(By.xpath("//table[@role='presentation']/tbody/tr/td"));
		System.out.println("tDateCols  " + tDateCols.size());
		for (int j = 0; j < tDateCols.size(); j++) {
			//tDateCols = driver.findElements(By.xpath("//table[@role='presentation']/tbody/tr/td"));
			String sDateAttribute = tDateCols.get(j).getAttribute("class");
			System.out.println("Attribute:" + sDateAttribute);
			System.out.println("Size:" + tDateCols.get(j).getText().length());
			if(tDateCols.get(j).getText().length()<3) {
				System.out.println("Element Attribute: " + sDateAttribute);
				System.out.println(eleCurrDate.getText() + "Curr Date");
				if(Integer.parseInt(eleCurrDate.getText())<= Integer.parseInt(tDateCols.get(j).getText())) {
					if(sDateAttribute.contains("disabled")) {
//						
					}
					else {
						tDateCols.get(j).click();
						bIsDateSelected = true;
						break;
					}//if disabled
				}//ParseInt 
			}//Only Date
			
		}//For loop
		if(bIsDateSelected==false) {
			eleNextMonth.click();
    
		}
		return bIsDateSelected;
	}	
	
    public static void clickMatchItem(String strItem,WebElement lstLabelDivs) {
		//driver.switchTo().defaultContent();

		//driver.switchTo().frame(iFramePreview);
		List<WebElement> sMatchItems = lstLabelDivs.findElements(By.tagName("label"));
		System.out.println("Match item:" + sMatchItems.size());
		for(WebElement item: sMatchItems) {
			if(strItem.equalsIgnoreCase(item.getText().trim())) {
				System.out.println("Matched item:"+ item.getText());
				item.click();
				break;
			}

		}//for loop
		
		
	}//method
	
    public static boolean clickLinkItems(WebDriver webDriver, WebElement element, String textValue) {
		//waitForJQueryToLoad(webDriver);
    	System.out.println("Expected Link texts: " + textValue);
		boolean flag = false;
		
		try {
			((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
			
			System.out.println("Element:" + element.getTagName());
			if (element.isDisplayed() || element.isEnabled()) {
				String arrValues[]=textValue.split(",");
				
				Thread.sleep(1000);
				List<WebElement> options = element.findElements(By.tagName("li"));
				System.out.println("Linnks count:" + options.size());
				System.out.println("Expected 1Value: " + arrValues[0]);
				for(int i=0;i<arrValues.length;i++) {
					for (WebElement option : options) {
						System.out.println("Option in List Box is : "+option.getText());
						System.out.println("Expected Value to be clicked is: " + arrValues[i]);
						if (arrValues[i].equalsIgnoreCase(option.getText().trim())) {
							
							System.out.println("Inside loop clicked Item is: " + option.getText());
							System.out.println("Inside click loop expected value to clicked is: " + arrValues[i]);
							BaseClass.logger.info("Expected Value:" + arrValues[i]);
							BaseClass.logger.info("DropDown Value:" + option.getText());
							option.click();
							continue;
							
						}
					}
				}
			}
		} catch (Exception e) {
			//Reporter.log("Exception occured while fnSelectFromComboBox event " + e.getMessage());
			System.out.println(e.getMessage());
		}
		return flag;
	}//function end
    public static void setRankMatrix(WebElement eleRMTbl,String sRMValues) {
		List<WebElement> lstRadButtons = eleRMTbl.findElements(By.tagName("button"));
		System.out.println("String:" + lstRadButtons.size());
		String aRMArray[] = sRMValues.split(",");
		for(int i=0;i<aRMArray.length;i++) {
			
		
		for(int j=0;j<lstRadButtons.size();j++) {
			if(aRMArray[i].contentEquals(String.valueOf(j+1))){

				lstRadButtons.get(j).click();

			}

		}//inner for
		}//outer for
    }//method end
    
    
    public static void findAndClick(String strItem, List<WebElement> sLstPicMsgItems) {
    	System.out.println("Match item Inside parameter" + sLstPicMsgItems.size());
 
		List<WebElement> sMatchItems = sLstPicMsgItems;
		System.out.println("Match item:" + sMatchItems.size());
		
		for(WebElement item: sMatchItems) {
			if(strItem.equalsIgnoreCase(item.getText().trim())) {
				System.out.println("Matched item:"+ item.getText());
				item.click();
				break;
			}

		}//for loop
		
		
	}//method
    
}