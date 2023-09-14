package pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class EditStudent {
 
	WebDriver driver;
	
	@FindBy(xpath="//span[normalize-space()='Manage Student']")
	WebElement manage;
	
	@FindBy(xpath="//tbody/tr/td/button")
	List<WebElement> addmission_No;
	
	@FindBy(xpath="//button[normalize-space()='Edit Details']")
	WebElement edit;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='student Id']")
	WebElement Id;
	
	@FindBy(xpath="(//div[@id='demo-simple-select-helper'])[8]")
	WebElement admission;
	
	@FindBy(xpath="(//input[@placeholder='Address'])[1]")
	WebElement address;
	
	@FindBy(xpath="(//div[@role='button'])[19]")
	WebElement bus;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	WebElement confirm;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement alert1;
	
	@FindBy(xpath="//button[@title='Close']")
	WebElement Close;
	
	@FindBy(xpath="//p[normalize-space()='Back']")
	WebElement back;
	
	
	
	 public EditStudent(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
		 
	 }
	 
	 
	 
	 
	 public EditStudent editDetails() throws InterruptedException{
		 manage.click();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(1000,0)","");
		 
		 String value="10003";
		 String No;
		 
	        for(WebElement ele:addmission_No) {
	        	
	        	 No = ele.getText();
	        	 Thread.sleep(2000);
	        	 if(No.contains(value)){
		        		ele.click();
		        		edit.click();
		        		break;
		        		
		        	}
	        	 
	        	 
	        	
	        }
	        
	       Id.sendKeys("10003");
		   lastName.sendKeys("Rathore");
 		   admission.click();
 		
 		   
 		   Thread.sleep(1000);
 		   List<WebElement> addmission_opt=driver.findElements(By.xpath("//li[@role='option']"));
 		   String[] opt_addmission=new String[addmission_opt.size()];
 		   for(int j=0;j<addmission_opt.size();j++) {
 			 opt_addmission[j]=addmission_opt.get(j).getText();
 		   }
 		   Thread.sleep(500);
 		   String addmissionStatus="Admitted";
 		   for(int k=0;k<opt_addmission.length;k++) {
 			  if(addmissionStatus.contains(opt_addmission[k])) {
 				   addmission_opt.get(k).click();
 			   }
 		   }
 		   address.sendKeys("bangalore");
 		   Thread.sleep(2000);
 		   bus.click();
 		   List<WebElement> bus_opt=driver.findElements(By.xpath("//li[@role='option']"));
 		   String[] opt_bus=new String[bus_opt.size()];
 		   for(int i=0;i<bus_opt.size();i++) {
 			  opt_bus[i]=bus_opt.get(i).getText();
 		   }
 		   Thread.sleep(1000);
 		   String busId="BUS BUS NO 05 CG-04MD-0624";
 		   for(int i=0;i<opt_bus.length;i++) {
 			    if(busId.contains(opt_bus[i])) {
 				      bus_opt.get(i).click();
 			     }
 		   }
 	     js.executeScript("arguments[0].scrollIntoView(true);", confirm);
 	     confirm.click();
 	     String alert="Please fill all the mandatory Fields";
 	     String alertOnScreen=alert1.getText();
 	     if(alert.contains(alertOnScreen)) {
 	    	System.out.println("student details not edited sucessfully");
     	     Close.click();
 	     }
         js.executeScript("arguments[0].scrollIntoView(true)", back);
          back.click();
		 return new EditStudent(driver);
		 
	 }
}
