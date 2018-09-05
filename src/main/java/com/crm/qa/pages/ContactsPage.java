package com.crm.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//*[@id='vContactsForm']/table/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement contactslabel;
	
//	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/a")
//	WebElement contactsTab;
//	
//	@FindBy(xpath="//*[@id='navmenu']/ul/li[4]/a")
//	WebElement newContact;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement latName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel(){
		return contactslabel.isDisplayed();
		
	}
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();		
	}
	
	/*public void addContact() throws InterruptedException{
		
		//driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/a"))).build().perform();
		driver.findElement(By.xpath("//*[@id='navmenu']/ul/li[4]/ul/li[1]/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("first_name")).sendKeys("Soumya");
		driver.findElement(By.id("surname")).sendKeys("Cheruku");
		Thread.sleep(2000);
		driver.findElement(By.id("company_position")).sendKeys("Manager");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='contactForm']/table/tbody/tr[1]/td/input[2]")).click();
		Thread.sleep(2000);

		
	}*/
	
	public void createnewContact(String title,String ftname,String ltName,String comp) throws InterruptedException{
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftname);
		latName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		Thread.sleep(2000);
		
	}
	
	
	
		
	}


