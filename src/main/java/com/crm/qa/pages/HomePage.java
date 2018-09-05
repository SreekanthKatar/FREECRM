package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Soumya Cheruku')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/a")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")
	WebElement newContact;
	
	@FindBy(xpath="//a[contains(text(),'Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'tasks']")
	WebElement tasksLink;
	
	
	
	//Initializing the page Objects
		public HomePage(){
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
			return driver.getTitle();
		}
		
		public boolean verifyCorrectUserName(){
			return userNameLabel.isDisplayed();
		}
		
		public ContactsPage clickOnContactsLink(){
			contactsLink.click();
			return new ContactsPage();
		}
		
		public DealsPage clickOnDealsLink(){
			dealsLink.click();
			return new DealsPage();
		}
		
		public TasksPage clickOnTasksLink(){
			tasksLink.click();
			return new TasksPage();
		}
		
		public void clickOnNewContactLink(){
			Actions action = new Actions(driver);
			action.moveToElement(contactsLink).build().perform();
			newContact.click();
			
		}
		
		
	

}
