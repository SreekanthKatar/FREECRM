package com.crm.qa.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;


public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest(){
		
		super();		
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	 testutil = new TestUtil();
	 loginpage=new LoginPage();
	 contactspage=new ContactsPage();
	 Thread.sleep(2000);
	 homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	 Thread.sleep(2000);
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() throws InterruptedException{
		Thread.sleep(2000);
		String homePageTitle =homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUsernameTest(){
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testutil.switchToFrame();
		contactspage=homepage.clickOnContactsLink();
		
	}
	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a/i")).click();

		driver.quit();
	}
	
	
	
	

}
