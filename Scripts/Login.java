package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FaceGenieLogin {

	WebDriver driver;
	
	 @FindBy(xpath = "//input[@id='email']")  
	    WebElement usernameTextBox;
	 
	 @FindBy(xpath= "//input[@id='password']")
	 WebElement Password;
	 
	 @FindBy(xpath= "//button[@type='submit']")
	 WebElement Login;
	 
	 
	 public FaceGenieLogin(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public FaceGenieLogin LogIn() {
		
		 usernameTextBox.sendKeys("test101@gmail.com");
		 Password.sendKeys("Test@101");
		 Login.click();
		 WebDriverWait wait1= new WebDriverWait(driver, 100);
		 wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'test101@gmail.com')]")));
		 String Expect="test101@gmail.com";
		 String actual1 = driver.findElement(By.xpath("//*[contains(text(),'test101@gmail.com')]")).getText();
		 if(actual1.contains(Expect)) {
			 System.out.println("User Validated");
		 }
	  return new FaceGenieLogin(driver);
	 }
	 
	 
}
