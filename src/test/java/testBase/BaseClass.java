package testBase;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pageObjects.NavigatetoResponse;
import pageObjects.ResponsePage;


public class BaseClass {
	public static WebDriver driver;
	public static Logger logger;
	public ResourceBundle rb;
	
	//@BeforeClass(groups= {"Sanity","Regression","Master"})
	@BeforeClass(alwaysRun = true)
	@Parameters("browser")
	public void setup(String br)
	{
		
		rb = ResourceBundle.getBundle("config");//Read config.properties.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch(br) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			
			options.addArguments("--start-maximized");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-infobars");
			options.addArguments("--disable-extensions");
			
			options.addArguments("-–disable-notifications");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("autofill.profile_enabled", false);
			
			prefs.put("profile.default_content_setting_values.media_stream_mic", 1); 
			prefs.put("profile.default_content_setting_values.media_stream_camera", 1);
			prefs.put("profile.default_content_setting_values.geolocation",1); 
			prefs.put("profile.default_content_setting_values.notifications",1); 
			
			options.setExperimentalOption("prefs", prefs);
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			options.merge(capabilities);
			
			driver=new ChromeDriver(options);
			break;
		case "edge":
			EdgeOptions eoptions = new EdgeOptions();
			
			eoptions.addArguments("--start-maximized");
			eoptions.addArguments("--remote-allow-origins=*");
			eoptions.addArguments("--disable-infobars");
			Map<String, Object> eprefs = new HashMap<String, Object>();
			eprefs.put("autofill.profile_enabled", false);
			
			eoptions.setExperimentalOption("prefs", eprefs);
			capabilities.setCapability(EdgeOptions.CAPABILITY, eoptions);
			eoptions.merge(capabilities);
			driver= new EdgeDriver(eoptions);
			break;
		default:
			//driver = new ChromeDriver();
			
		}
		
		logger = LogManager.getLogger(this.getClass());
		
		
		//WebDriverManager.chromedriver().setup();
		
		
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		/*
		options.addArguments("--disable-autofill");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("-–disable-notifications");
		
		*/
		//options.AddUserProfilePreference("autofill.profile_enabled", false);
		
		
		/*
		prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);
		prefs.put("disable-popup-blocking", true);
		prefs.put("disable-infobars", true);
		*/
		
		
		// To remove the message "Your browser is controlled by automated software."
		//prefs.put("excludeSwitches", new String[] {"enable-automation"});
		//options.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		// To disable the auto save page password popup.
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(rb.getString("appURL"));
		
		
		//driver.manage().window().maximize();
	}
	//@AfterClass(groups= {"Sanity","Regression","Master","DataDriven"})
	
	/*
	@AfterMethod
	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}
	
	*/
	public String randomeString() {
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}

	public String randomeNumber() {
		String generatedString2 = RandomStringUtils.randomNumeric(10);
		return (generatedString2);
	}
	
	public String randomAlphaNumeric() {
		String st = RandomStringUtils.randomAlphabetic(4);
		String num = RandomStringUtils.randomNumeric(3);
		
		return (st+"@"+num);
	}
	
	public void NavigatetoResponse(String strBuildName,WebDriver driver) throws Exception {
		logger.info("Navigation started");
		//driver.close();
		//driver = new ChromeDriver();
		NavigatetoResponse obj = new NavigatetoResponse(driver);
		driver.get("https://rthree.live/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		obj.setEmailId("rbot.live@gmail.com");
		obj.setPassword("12345678");
		logger.info("Login details Entered");
		obj.clickSubmit();
		logger.info("Chat bot Logged In");
		Thread.sleep(15000);
		logger.info("Hard wait for 15 secs");
		obj.clickClearAll();
		logger.info("clear all button clicked on listbox");
		obj.setBuildName(strBuildName);
		logger.info("Build Name entered in List Box");
		Thread.sleep(3000);
		logger.info("Waited for 3 secs");
		obj.KeyEnterBuildName();
		logger.info("Enter Key applied on ListBox");
		Thread.sleep(1000);
		logger.info("Hard Wait for 1 sec");
		obj.clickSideBarBldBtn();
		logger.info("clicked side bar Build button once");
		Thread.sleep(1000);
		logger.info("Hard Wait for 1 sec");
		/*
		obj.clickSideBarBldBtn();
		logger.info("clicked side bar Build button twice");
		
		Thread.sleep(1000);
		
		logger.info("Hard Wait for 1 sec");
		*/
		obj.clickSideBarResult();
		logger.info("clicked side bar Result");
		obj.clickSideItemResp();
		logger.info("Side Item Response clicked");
		obj.clickRefreshResponse();
		logger.info("clicked refresh Response");
		obj.clickRefreshResponse();
		logger.info("clicked refresh Response Again");
		Thread.sleep(3000);
		obj.clickFirstResponse();
		logger.info("Clicked first Response");
	}
	public void VerifySingleCtrlResponse(WebDriver driver,String strExpLabel1,String sControl) {
		try {
		ResponsePage robj =new ResponsePage(driver);
		logger.info("Validation for Single Control response started ");
		WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@title='Form preview'])[1]"));
		driver.switchTo().frame(iframe1);
		
		System.out.println("Control Name: " + sControl);
		
		
		Thread.sleep(1000);
		logger.info("Switched to iframe Form Preview");
		String strActLabel1 = robj.getRespMsg1(); 
		System.out.println("Actual Lable is: " + strActLabel1);
		Assert.assertEquals(strActLabel1,strExpLabel1);
		
		logger.info("Validated, Expected Label 1: " + strExpLabel1);
		Thread.sleep(1000);
		driver.switchTo().defaultContent();
		logger.info("Focus to Main window");
		
		
		
		System.out.println("before closing");
		robj.fCloseResponse();
		
		System.out.println("after closing");
		logger.info("Response page closed");
		
		}catch (Exception e) {
			Assert.fail(e.getMessage());
		}
		
	}
	
	public void SingleQandAVerification(WebDriver driver,String sControlLabel,String SelectValue, String sControl) {
		try {
			ResponsePage robj =new ResponsePage(driver);
			logger.info("Validation for Single Control response started ");
			WebElement iframe1 = driver.findElement(By.xpath("(//iframe[@title='Form preview'])[1]"));
			driver.switchTo().frame(iframe1);
			logger.info("Switched to iframe Form Preview");
			String strResponseQ1 = robj.getResponseTitle1();
			System.out.println("Actual Lable is: " + strResponseQ1);
			Assert.assertEquals(strResponseQ1,sControlLabel);
			logger.info(sControl + " Title Validated");
			String strResponseAns1 = robj.getResponseAnswer1();
			Assert.assertEquals(SelectValue,strResponseAns1);
			logger.info(sControl + " Response Answer Validated");
			Thread.sleep(1000);
			driver.switchTo().defaultContent();
			logger.info("Focus to Main window");
			System.out.println("before closing");
			robj.fCloseResponse();
			System.out.println("after closing");
			logger.info("Response page closed");
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			Assert.fail(e.getMessage());
		}
	}
	
	
	public String captureScreen(String tname) throws IOException, InterruptedException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		Thread.sleep(1000);		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;

	}
}
