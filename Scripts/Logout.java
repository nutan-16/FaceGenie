package pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceGenieLogOut {
	
	WebDriver driver;
	
	 @FindBy(xpath = "//div[@class='MuiListItemText-root css-1tsvksn']//span[normalize-space()='Log Out']")  
	    WebElement Logout;
	 
	 public FaceGenieLogOut(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
		 
	 }
	 
	 public FaceGenieLogOut Logout() throws InterruptedException {
			/*Actions actions = new Actions(driver);
			actions.moveToElement(Logout).click().build().perform();
		   Logout.click();
		 System.out.println("logged out successfully");*/
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", Logout);
		Thread.sleep(1000);
		WebElement sure=driver.findElement(By.xpath("//button[normalize-space()='Ok']"));
		sure.click();
		 return new FaceGenieLogOut(driver);
	 }
	 
	
	
}
