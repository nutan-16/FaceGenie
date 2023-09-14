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

public class ManageStudent {

	WebDriver driver;
	 
	
	@FindBy(xpath = "//span[normalize-space()='Manage Student']")  
	    WebElement manageStudent;
	 
	 @FindBy(xpath="//p[normalize-space()='Add student using Form']")
	 WebElement addForm;
	 
	 @FindBy(xpath="(//input[@placeholder='Admission No'])[1]")
	 WebElement Addmission_no;
	 
	 @FindBy(xpath="//input[@placeholder='First Name']")
	 WebElement First_Name;
	 
	 @FindBy(xpath="//input[@placeholder='Last Name']")
	 WebElement Last_Name;
	 
	 @FindBy(xpath="//input[@placeholder='Father Name']")
	 WebElement Father_name;
	 
	 @FindBy(xpath="(//div[contains(@role,'button')])[15]")
	 WebElement Class_name;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[6]")
	  WebElement division;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[7]")
	 WebElement gender;
	 
	 @FindBy(xpath="//input[@placeholder='Mobile No']")
	 WebElement mobile;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[8]")
	 WebElement bus_no;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[9]")
	 WebElement payment;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[10]")
	 WebElement register;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[11]")
	 WebElement Area;
	 
	 @FindBy(xpath="//input[@name='address']")
	 WebElement Address;
	 
	 @FindBy(xpath="//input[@name='studentId']")
	 WebElement Student_Id;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[12]")
	 WebElement Add_status;
	 
	 @FindBy(xpath="//input[@name='admissionDate']")
	 WebElement add_date;
	 
	 @FindBy(xpath="//input[@name='motherName']")
	 WebElement mother_name;
	 
	 @FindBy(xpath="//input[@name='motherMobileNo']")
	 WebElement mother_mobile;
	 
	 @FindBy(xpath="(//div[@id='demo-simple-select-helper'])[13]")
	 WebElement hostelDaySch;
	 
	 @FindBy(xpath="//p[contains(text(),'Add Student Details')]")
	 WebElement add_student;
	 
	 @FindBy(xpath="//p[normalize-space()='Confirm Add student Details']")
	 WebElement confirm_student;
	 
	 @FindBy(xpath="(//div[contains(@class,'MuiAlert-message css-1xsto0d')])[1]")
	 WebElement confirm;
	 
	 @FindBy(xpath="(//div[@aria-haspopup='listbox'])[1]")
		WebElement Class1;
	 
	 
	 
	 public ManageStudent(WebDriver driver) {
		 this.driver = driver;  
		 PageFactory.initElements(driver, this); 
	 }
	 
	 
	 
	 public ManageStudent Open() {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", manageStudent);
			Thread.holdsLock(1000);
		 return new ManageStudent(driver);
	 }
	 
	 
	 public ManageStudent AddForm() throws InterruptedException {
		 
		 addForm.click();
		 Thread.sleep(2000);
		 Addmission_no.sendKeys("101324");
		 First_Name.sendKeys("Girme");
		 Last_Name.sendKeys("Abhi");
		 Father_name.sendKeys("RajaLingam");
		
		 
		 Class_name.click();
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
		    
		    Thread.sleep(2000);
		    division.click();
		    Thread.sleep(1000);
		    List<WebElement> div_opt=driver.findElements(By.xpath("//li[@role='option']"));
		    String[] sel_div=new String[div_opt.size()];
		    for(int i=0; i<div_opt.size();i++) {
		    	sel_div[i]=div_opt.get(i).getText();
		    }
		    String div="G";
		    for(int i=0; i<sel_div.length;i++) {
		    if(div.contains(sel_div[i])) {
		    	div_opt.get(i).click();;
		    }
		    }
		    
		    
		    gender.click();
		    
		    List<WebElement> gender_opt=driver.findElements(By.xpath("//li[@role='option']"));
			  String[] opt_gender=new String[gender_opt.size()];
			  for(int i=0; i<gender_opt.size();i++) {
				  opt_gender[i]=gender_opt.get(i).getText();
			  }
			  String Gender="M";
			  for(int i=0;i<opt_gender.length;i++) {
				  if(Gender.contains(opt_gender[i])) {
					  gender_opt.get(i).click();
				  }
			  }
			  
			  mobile.sendKeys("9876543210");
			  
			  
			  Thread.sleep(2000);
			  bus_no.click();
			  List<WebElement> bus_opt=driver.findElements(By.xpath("//li[@role='option']"));
				 String[] opt_bus=new String[bus_opt.size()];
				 for(int i=0;i<bus_opt.size();i++) {
					 opt_bus[i]=bus_opt.get(i).getText();
				 }
				 String busId="BUS BUS NO 05 CG-04MD-0624";
				 for(int i=0;i<opt_bus.length;i++) {
					 if(busId.contains(opt_bus[i])) {
						 bus_opt.get(i).click();
					 }
				 }
				 
				 
				 payment.click();
				 Thread.sleep(1000);
				 List<WebElement> pay=driver.findElements(By.xpath("//li[@role='option']"));
				 String[] pay_opt= new String[pay.size()];
				 for(int i=0;i<pay.size();i++) {
					 pay_opt[i]=pay.get(i).getText();
				 }
				 String opt_pay="Yes";
				 for(int i=0;i<pay_opt.length;i++) {
					 if(opt_pay.contains(pay_opt[i])){
						 pay.get(i).click();
					 }
				 }
				 
				 
				 
				 JavascriptExecutor js = (JavascriptExecutor) driver;
			     WebElement doB = driver.findElement(By.cssSelector("[name='dateOfBirth']"));
			     js.executeScript("arguments[0].scrollIntoView(true);",doB);
			     doB.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
			     doB.sendKeys("04/26/1999");
			     
			     
			     register.click();
			     List<WebElement> reg_opt=driver.findElements(By.xpath("//li[@role='option']"));
			     String[] opt_reg=new String[reg_opt.size()];
			     for(int i=0;i<reg_opt.size();i++) {
			  		 opt_reg[i]=reg_opt.get(i).getText();
			  	 }
			  	 String reg="Yes";
			  	 for(int i=0;i<opt_reg.length;i++) {
			  		 if(reg.contains(opt_reg[i])){
			  			 reg_opt.get(i).click();
			  		 }
			  	 }
			  	 
			  	 
			  	 
			  	Area.click();
				 List<WebElement> area=driver.findElements(By.xpath("//li[@role='option']"));
				   String[] area_opt=new String[area.size()];
				   for(int i=0;i<area.size();i++) {
						 area_opt[i]=area.get(i).getText();
					 }
					 String AreA="MARUTI HEIGHTS";
					 for(int i=0;i<area_opt.length;i++) {
						 if(AreA.contains(area_opt[i])){
							 area.get(i).click();
						 }
					 }
					 
					 Address.sendKeys("Hyderabad, maruthi nagar, 45-236-125");
					 Student_Id.sendKeys("404469");
					 
					 Add_status.click();
					 List<WebElement> add_opt=driver.findElements(By.xpath("//li[@role='option']"));
					   String[] opt_add=new String[add_opt.size()];
					   for(int i=0;i<add_opt.size();i++) {
							 opt_add[i]=add_opt.get(i).getText();
						 }
						 String add_status="Studying";
						 for(int i=0;i<opt_add.length;i++) {
							 if(add_status.contains(opt_add[i])){
								 add_opt.get(i).click();
							 }
						 }
						 
						 
						 add_date.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
					     add_date.sendKeys("04/26/2023");
					     mother_name.sendKeys("alia");
					     
					     mother_mobile.sendKeys("9873216540");
					     
					     
					     hostelDaySch.click();
						 List<WebElement> dayhstl_opt=driver.findElements(By.xpath("//li[@role='option']"));
						   String[] opt_dayhstl=new String[dayhstl_opt.size()];
						   for(int i=0;i<dayhstl_opt.size();i++) {
								 opt_dayhstl[i]=dayhstl_opt.get(i).getText();
							 }
							 String dayhstl="DaysScholar";
							 for(int i=0;i<opt_dayhstl.length;i++) {
								 if(dayhstl.contains(opt_dayhstl[i])){
									 dayhstl_opt.get(i).click();
								 }
							 }
							 add_student.click();
							 js.executeScript("arguments[0].scrollIntoView(true);",confirm_student);
							 confirm_student.click();
							 String con=confirm.getText();
							 System.out.println(con);
							 String ExpectedCon="Student has been added succesfully";
							 if(ExpectedCon.contains(con)) {
								 System.out.println("student added succesfully");
								Thread.sleep(1000);
							 }
							 js.executeScript("window.scrollBy(1000,0)", "");
							 js.executeScript("arguments[0].scrollIntoView()",Class1 );
		 return new ManageStudent(driver);
		 
	 }
	 
	 
}
