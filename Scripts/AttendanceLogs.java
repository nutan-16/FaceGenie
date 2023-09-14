package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AttendanceLogs {

	WebDriver driver;
	
	 @FindBy(xpath = "//span[normalize-space()='Attendance Logs']")  
	    WebElement attendance;
	 public  AttendanceLogs(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public AttendanceLogs attendance_Over() throws InterruptedException {
		 /*WebDriverWait wait= new WebDriverWait(driver, 100);
		 wait.until(ExpectedConditions.elementToBeClickable(attendance));
		 attendance.click();*/
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", attendance);
		Thread.sleep(1000);
		 
		 return new AttendanceLogs(driver);
	 }
	 
	
}
