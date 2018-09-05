package com.crm.qa.testcases;
//Contact Page Test

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetName="contacts";
	
	public ContactsPageTest(){
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
	 testutil.switchToFrame();
	 contactspage = homepage.clickOnContactsLink();
	 
	}
	
	@Test(priority=1)
	public void verifyContactPagelabel(){
		//homepage.clickOnContactsLink();
		Assert.assertTrue(contactspage.verifyContactsLabel(),"contact label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectContactTest() throws InterruptedException{
		//homepage.clickOnContactsLink();
		contactspage.selectContactsByName("Kiriti Chavva");
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void selectMultipleContactTest() throws InterruptedException{
		homepage.clickOnContactsLink();
		contactspage.selectContactsByName("Kiriti Chavva");
		Thread.sleep(4000);
	}
	
	/*@Test(priority=4)
	public void addContactTest() throws InterruptedException{
		contactspage.addContact();
		
	}*/
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
		
	}
	
	
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void validateCreateNewContactTest(String title,String firstname,String lastname,String company) throws InterruptedException{
		homepage.clickOnNewContactLink();
		Thread.sleep(2000);
		//contactspage.createnewContact("Mr.", "tom", "Peter", "google");
		contactspage.createnewContact(title, firstname, lastname, company);
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException{
		Thread.sleep(1000);
		//driver.findElement(By.xpath("/html/body/table[1]/tbody/tr[2]/td[1]/div/table/tbody/tr/td[4]/a/i")).click();
		driver.quit();
	}

}
