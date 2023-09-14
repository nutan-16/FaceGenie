package pages;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class DashBoard {

	WebDriver driver;
	
	@FindBy(xpath="//*[contains(text(),'Dashboard/ Home')]")
	WebElement dashBoard;
	

	 public DashBoard(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
		 
	 }
	 
	 public DashBoard Verify() throws InterruptedException {
	
	String Expected="Dashboard/ Home";
	 String actual = driver.findElement(By.xpath("//*[contains(text(),'Dashboard/ Home')]")).getText();
	 		 
	 if(actual.contains(Expected)) {
		 System.out.println("DashBoard validated sucessfully");
	 }
          return new DashBoard(driver);
	
}
}
