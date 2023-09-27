package testCases;

import java.time.Duration;
import utilities.UtilityCustomFunctions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
public class AppointmentSelection {

	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver =new ChromeDriver();
		driver.get("https://rthree.live/showform?formid=721143&nurams=bot1");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//driver.findElement(By.cssSelector("button[type='text']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='Book an appointment']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Choose Date']")).click();
		
		WebElement eleWbtbl = driver.findElement(By.xpath("//table[@role='presentation']"));
		Thread.sleep(1000);
		
		
	
		WebElement eleCurrDate = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
		System.out.println("Today:" + eleCurrDate.getText());
//		eleCurrDate.click();
//		WebElement element = driver.findElement(By.xpath("//div//ul"));
//		List<WebElement> options = element.findElements(By.tagName("li"));
//		System.out.println("Time Listed is:  "+options.size());
//		utilities.UtilityCustomFunctions.selectFirstListItem(driver, element);
		
		
//		List<WebElement> eleDatesEnabled = driver.findElements(By.xpath("//div[not(contains(@class,'mat-calendar-body-disabled'))]"));
//		System.out.println("Enabled Dates" + eleDatesEnabled.size());
		
//		WebElement eleCurrDate = driver.findElement(By.xpath("//div[contains(@class,'today')]"));
		
		String sDateAttribute="";
		boolean bDateAvailable=false;
		List<WebElement> trows = eleWbtbl.findElements(By.tagName("tr"));
		System.out.println(trows.size());
		for(WebElement trow: trows) {
			List<WebElement> tcols = trow.findElements(By.tagName("td"));
			System.out.println(tcols.size());
			for(WebElement tcol: tcols) {
				if(tcol.getText().length()<3) {
					if(Integer.parseInt(eleCurrDate.getText())< Integer.parseInt(tcol.getText())) {
						//if(tcol.getAttribute("class").contains() {
						sDateAttribute=tcol.getAttribute("class");
							if(sDateAttribute.contains("disabled")) {
							
							}
							else {
								System.out.println("Tag Name: " + tcol.getTagName() +"value is: "+tcol.getText());
								bDateAvailable = true;
								tcol.click();
								break;
							}
					}
				}//if td Date<3

			}//all td cols
			//driver.findElement(By.xpath("//button[@aria-label='Next month']")).click();
			}
		}
		
		
		
//		for(WebElement trow: trows) {
//			List<WebElement> tcols = trow.findElements(By.tagName("td"));
//			
//			for(WebElement tcol: tcols) {
//				
//				//System.out.println("    ");
//				String strCellClass = tcol.getAttribute("class");
//				if(strCellClass.contains("mat-calendar-body-disabled")) {
//					
//					continue;
//				}
//				else {
//					System.out.print(tcol.getText());
//					tcol.click();
//					break;
//				}
//			}
//			System.out.println();
//		}
		
		

	}

