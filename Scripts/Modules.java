package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facegenie_modules 
{
	@FindBy(xpath="(//div[contains(@class,'MuiListItemButton-root')])[2]")
	private WebElement attendance;
	
	@FindBy(xpath="(//div[contains(@class,'MuiListItemButton-root')])[3]")
	private WebElement analytics;
	
	@FindBy(xpath="(//div[contains(@class,'MuiListItemButton-root')])[4]")
	private WebElement students; 
	
	@FindBy(xpath="(//div[contains(@class,'MuiListItemButton-root')])[5]")
	private WebElement licenses;
	
	@FindBy(xpath="(//div[contains(@class,'MuiListItemButton-root')])[6]")
	private WebElement settings;
	
	public Facegenie_modules(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void Attendance_logs()
	{
		attendance.click();
	}
	
	public  void Analytics_reports()
	{
		analytics.click();
	}
	
	public void Manage_students()
	{
		students.click();
	}
	
	public void Manage_licenses()
	{
		licenses.click();
	}
	
	public void Settings()
	{
		settings.click();
	}
}
