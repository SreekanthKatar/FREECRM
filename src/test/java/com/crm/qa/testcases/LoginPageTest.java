package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		Thread.sleep(2000);
		initialization();
	 loginpage=new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginpage.validateLoginPagetitle();
		Assert.assertEquals("#1 Free CRM software in the cloud for sales and service",title );
		
	}
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginpage.validateCrmInage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() throws InterruptedException{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a/i")).click();

		driver.quit();
	}

}
