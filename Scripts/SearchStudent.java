package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchStudent {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[normalize-space()='Manage Student']")  
    	WebElement manageStudent;
	
	@FindBy(xpath="(//div[@aria-haspopup='listbox'])[1]")
	WebElement Class;
	
	@FindBy(xpath="(//div[@aria-haspopup='listbox'])[2]")
	WebElement section;
	
	@FindBy(xpath="(//div[@aria-haspopup='listbox'])[4]")
	WebElement admissionStatus;
	
	@FindBy(xpath="//tbody/tr")
	 List<WebElement> ListofStudents;
	
	@FindBy(xpath="//li[@class='MuiMenuItem-root MuiMenuItem-gutters Mui-selected MuiButtonBase-root css-10vfc4x']")
	WebElement ClassClear;
	 public SearchStudent(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 public SearchStudent Sel() throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("arguments[0].click()", manageStudent);
		 //js.executeScript("arguments[0].click()", Class);
		 Thread.sleep(1000);
		Class.click();
		 List<WebElement> optionList=driver.findElements(By.xpath("//li[@role='option']"));
		    String[] classes=new String[optionList.size()];
		    for(int i=0;i<optionList.size();i++) {
		    	classes[i]=optionList.get(i).getText();
		    }
		    String Sel_class="CLASS 7";
		    for(int i=0;i<classes.length;i++) {
		    	if(Sel_class.contains(classes[i])){
		    		optionList.get(i).click();
		    	}
		    }
		    //js.executeScript("arguments[0].click()", section);
		    Thread.sleep(1000);
		    section.click();
			  List<WebElement> sectionList=driver.findElements(By.xpath("//li[@role='option']"));
			    String[] sec=new String[sectionList.size()];
			    for(int i=0;i<sectionList.size();i++) {
			    	sec[i]=sectionList.get(i).getText();
			    }
			    String Sel_sec="E";
			    for(int i=0;i<sec.length;i++) {
			    	if(Sel_sec.contains(sec[i])){
			    		sectionList.get(i).click();
			    	}
			    }
			    //js.executeScript("arguments[0].click()", admissionStatus);
			   admissionStatus.click();
				   List<WebElement> AdStatus=driver.findElements(By.xpath("//li[@role='option']"));
				    String[] ad=new String[AdStatus.size()];
				    for(int i=0;i<AdStatus.size();i++) {
				    	ad[i]=AdStatus.get(i).getText();
				    }
				    String Sel_ad="Admitted";
				    for(int i=0;i<ad.length;i++) {
				    	if(Sel_ad.contains(ad[i])){
				    		AdStatus.get(i).click();
				    	}
				    }
				    
				    String[] students=new String[ListofStudents.size()];
				    for(int i=0;i<ListofStudents.size();i++) {
				    	System.out.println(students[i]=ListofStudents.get(i).getText());
				    }
				   Class.click();
				  ClassClear.click();
				  driver.navigate().refresh();
				    return new SearchStudent(driver);
			    
		    
	 }
	 
	

}
