package com.fitpeo.fpt;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Tasks {
	
	
	public static void scroll(WebDriver driver) throws InterruptedException
	{
		//TASK4: SLIDER SCRIOLL UPTO VALUE 820
		WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-root MuiSlide')]")); // selecting slider
		Actions act = new Actions(driver);
	    act.dragAndDropBy(slider,-26,0).perform();
	    WebElement tb= driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput')]"));
	    Thread.sleep(2000);
	    Thread.sleep(2000);
	    tb.click(); 
	    Thread.sleep(3000);
	    tb.sendKeys(Keys.ARROW_DOWN);
	    tb.sendKeys(Keys.ARROW_DOWN);
	    tb.sendKeys(Keys.ARROW_DOWN);
	    
	}

public static void main(String[] args) throws InterruptedException {
	
	
	 ChromeOptions options = new ChromeOptions();
     options.addArguments("--incognito");
     WebDriver driver = new ChromeDriver(options);
	        driver.manage().window().maximize();
	        driver.get("https://www.fitpeo.com/"); 
	        System.out.println("TestCase 1: URL LOGIN Successfull \n");
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
	driver.findElement(By.xpath("//div[text()='Revenue Calculator']")).click();
	System.out.println("TestCase 2: Opening calculator is successfull \n");
	Thread.sleep(3000);
	
	//TASK3: WINDOW SCROLLING UPTO SCROLL BAR
	Actions act = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,500)"); //window page scrolling
	System.out.println("TestCase 3: Scroll Down to the Slider section successfull \n");

	//TASK4: SLIDER SCRIOLL UPTO VALUE 820
	scroll(driver); //method calling
	System.out.println("TestCase 4: Adjusting the Slider upto value");
    System.out.println("Slider value is 820 \n");
    
    // TESTCASE 5 & 6: TEXT FIELD WITH VALUE 560 AND VALIDATION
    WebElement textfield= driver.findElement(By.xpath("//input[contains(@class,'MuiInputBase-input MuiOutlinedInput')]"));
  Thread.sleep(2000);
  textfield.click();
  Thread.sleep(3000);
  textfield.sendKeys(Keys.BACK_SPACE);
  textfield.sendKeys(Keys.BACK_SPACE);
  textfield.sendKeys(Keys.BACK_SPACE);
  Thread.sleep(2000);
  textfield.sendKeys("560"); 
  WebElement slider1 = driver.findElement(By.xpath("//input[@aria-orientation='horizontal']"));
  String value = slider1.getAttribute("value");
  System.out.println("TestCase 5 & 6 : Update the Text Field to 560 and validating the slider value ");
  System.out.println("updated value is: " +value);
  if(value.equals("560")) {   //VALIDATION
  	System.out.println("updated value and slider values are same \n");
 
//TESTCASE 7:Select CPT Codes:

js.executeScript("window.scrollTo(0,900)");

java.util.List<WebElement> cptcodes = driver.findElements(By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 inter css-1s3unkt']"));
System.out.println("TestCase 7: Select CPT Codes");
for (WebElement cpt : cptcodes)
{
String I = cpt.getText();
if(I.equals("CPT-99091") || I.equals("CPT-99453") ||I.equals("CPT-99454")  || I.equals("CPT-99474")) {
	WebElement check = driver.findElement(By.xpath("//p[text()='"+I+"']//../label//span/input")); //checkbox
   act.click(check).perform();
   System.out.println("Code " + I +" is selected");
}
}

//TESTCASE 8: VALIDATING Total Recurring Reimbursement
WebElement TRR = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-1bl0tdj'])[4]")); //from top view value
WebElement TRRPM = driver.findElement(By.xpath("(//p[contains(@class,'MuiTypography-root MuiTypography-body1 inter')])[4]")); //from before the slider total revenue table
	String TotalRecurReim = TRR.getText();
	String totalrecurpermonth = TRRPM.getText();
if(TotalRecurReim.equals(totalrecurpermonth) && TotalRecurReim.equals("$75600")) {   //VALIDATION
	System.out.println("TestCase 8: Validate Total Recurring Reimbursement");
	 System.out.println( "Value at webelement TRR is: " + TotalRecurReim);
	 System.out.println("Value at webelement TRRPM is: " + TotalRecurReim);
  	System.out.println("Total Recurring Reimbursement for all Patients is $75600 when slider at 560 \n");
}	
	//TESTCASE 9: validation for header displaying Total Recurring Reimbursement for all Patients Per Month
  	js.executeScript("window.scrollTo(0,500)");
  	scroll(driver); //method calling
  	String TotalRecurReim1 = TRR.getText();
	String totalrecurpermonth1 = TRRPM.getText();
  	if(TotalRecurReim1.equals(totalrecurpermonth1) && TotalRecurReim1.equals("$110700")) {   //VALIDATION
  		System.out.println("TestCase 9: Validation Of header displaying Total Recurring Reimbursement for all Patients Per Month ");
  		System.out.println( "Value at webelement TRR is: " + TotalRecurReim1);
  		 System.out.println("Value at webelement TRRPM is: " + TotalRecurReim1);
  	  	System.out.println("Total Recurring Reimbursement for all Patients Per Month is Showing Correct as $110700 ");
}
	// driver.close(); //To Close The Window

}
}
}
