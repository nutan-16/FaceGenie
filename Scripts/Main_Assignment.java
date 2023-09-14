package org.ResoluteAI;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class AssesmentAI {

    public static WebDriver driver;


    @BeforeTest
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Ani\\SeleniumTesting\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize(); //To maximize the window
        driver.get("https://facegenie-ams-school.web.app/");
    }

    @Test(description = "TC_001-verify the login page with  email and password", priority = 1)
    public void loginTest() {

        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.sendKeys("testing@gmail.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement password = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div[2]/div/div[1]/form[2]/div[2]/div/input"));
        password.sendKeys("testing@123");

        WebElement logBtn = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button"));
        logBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[1]/p[1]")));

        String expectedTitle = "Dashboard/ Home";
        String actualTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[1]/p[1]")).getText();

        System.out.println("-------------------");
        System.out.println("Actual Title " + actualTitle);
        System.out.println("Expected Title " + expectedTitle);
        System.out.println("-------------------");
        Assert.assertEquals(actualTitle, expectedTitle, "Not Logged In");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    @Test(description = "TC_002-take a screen shot of the dashboard to verify", priority = 2)
    public void dashboardScreenShot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/" + System.currentTimeMillis()
                + ".png");
        FileUtils.copyFile(sourceFile, destFile);


    }


    @Test(description = "TC_003-Manage Students-ADD and download QR Code", priority = 3)
    public void addStudent() throws IOException, InterruptedException {

        WebElement manageStudents = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/nav/div[4]/div[2]/span"));
        manageStudents.click();

        WebElement addStudent = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[1]/div[1]/button/p"));
        addStudent.click();


        WebElement admissionNo = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[2]/div[1]/div/div/input"));
        admissionNo.sendKeys("20");


        WebElement firstName = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[2]/div[2]/div/div/input"));
        firstName.sendKeys("Test");

        WebElement lastName = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[2]/div[3]/div/div/input"));
        lastName.sendKeys("test1");

        WebElement fatherName = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[1]/div/div/input"));
        fatherName.sendKeys("ashok");


       WebElement clas1= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[2]/div/div/div"));
                clas1.click();



        WebElement clas1a= driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[3]"));
                      clas1a.click();



                      sleep(2000);

        WebElement div1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[3]/div[3]/div/div/div"));
                 div1.click();



        WebElement div1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        div1a.click();

        sleep(2000);

        WebElement gender1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[4]/div[1]/div/div/div"));
        gender1.click();


        WebElement gender1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        gender1a.click();

         WebElement mobileNo=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[4]/div[2]/div/div/input"));
                    mobileNo.sendKeys("1234567898");




        WebElement busNo1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[4]/div[3]/div/div/div"));
        busNo1.click();


        WebElement busNo1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        busNo1a.click();



        WebElement paymentStatus1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[5]/div[2]/div/div/div"));
        paymentStatus1.click();


        WebElement paymentStatus1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        paymentStatus1a.click();






        WebElement registered1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[5]/div[3]/div/div/div"));
        registered1.click();


        WebElement registered1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        registered1a.click();



        WebElement area1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[6]/div[1]/div/div/div"));
        area1.click();


        WebElement area1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        area1a.click();


        WebElement address=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[6]/div[2]/div/div/input"));
             address.sendKeys("New Delhi");


        WebElement studenyId=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[7]/div[1]/div/div/input"));
           studenyId.sendKeys("1234");


        WebElement admissionStatus1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[7]/div[2]/div/div/div"));
        admissionStatus1.click();


        WebElement admissionStatus1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[3]"));
        admissionStatus1a.click();




        WebElement mothersName=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[8]/div[1]/div/div/input"));
        mothersName.sendKeys("Iravati");

        WebElement motherMobileNo=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[8]/div[2]/div/div/input"));
        motherMobileNo.sendKeys("0123456789");

        WebElement hostelDayScholar1=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[8]/div[3]/div/div/div"));
        hostelDayScholar1.click();


        WebElement hostelDayScholar1a=driver.findElement(By.xpath("/html/body/div[2]/div[3]/ul/li[2]"));
        hostelDayScholar1a.click();






       WebElement addStudentDetails= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[1]/form/div/div[9]/button"));
           addStudentDetails.click();


        // Download QR code

        WebElement qrCode=driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/div[1]/button[1]/span[1]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(qrCode).click().perform();

        //actions.contextClick(qrCode).click().perform();



           WebElement confirmStudentData=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[3]/div[2]/div[2]/div[5]/button"));
                   confirmStudentData.click();





        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/"+System.currentTimeMillis()
                +".png");
        FileUtils.copyFile(sourceFile,destFile);

    }

    @Test(description = "TC_004-Search the student from database",priority = 4)
    public void search() throws IOException {
            String s1="Sam Sethy";
        WebElement search= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[2]/div/div/div[1]/div[1]/div/div/input"));
         search.sendKeys(s1);

        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/"+System.currentTimeMillis()
                +".png");
        FileUtils.copyFile(sourceFile,destFile);

    }


    @Test(description = "TC_005-Add new Licenses",priority =5 )
         public void addLicense() throws IOException {
        WebElement manageLicense= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/div/div/nav/div[5]/div[2]/span"));
                  manageLicense.click();


         WebElement addLicense= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[2]/div[1]/div[2]/div[4]/button"));
                 addLicense.click();


        WebElement employeeId= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[1]/div[1]/div/div/input"));
        employeeId.sendKeys("177");


        WebElement firstName= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[1]/div[2]/div/div/input"));
        firstName.sendKeys("Suraj");

        WebElement lastName= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[1]/div[3]/div/div/input"));
          lastName.sendKeys("Singh");


        WebElement phoneNumber= driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[2]/div[1]/div/div/input"));
        phoneNumber.sendKeys("1234567898");


         WebElement busNo=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[2]/div[2]/div/div/input"));
              busNo.sendKeys("WB1234");

        WebElement email=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[2]/div[3]/div/div/input"));
        email.sendKeys("testing@gmail.com");


        WebElement password=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[2]/div[4]/div/div/input"));
                password.sendKeys("testing@123");


                WebElement submitDetails=driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div/main/div[2]/div/div/div/div[3]/div/form/div[5]/button"));
                          submitDetails.click();

        TakesScreenshot ts = (TakesScreenshot)driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("Screenshots/"+System.currentTimeMillis()
                +".png");
        FileUtils.copyFile(sourceFile,destFile);


    }




    @Test(description = "TC_006-verify the Logout function",priority = 6)
    public void loginOut()
    {
        WebElement logOut=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div/div/nav/div[7]/div[2]/span"));
         logOut.click();

         WebElement ok= driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/div/button[2]"));
                   ok.click();

                   String expectedTitle= driver.getTitle();
                   String actualTitle="Rai-Test-Bams";



        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[2]/div/div[1]/form[2]/button")));


        Assert.assertEquals(actualTitle,expectedTitle,"Not Logged Out");



    }




@AfterTest
    public static void end()
{
    driver.quit();
}


    }
