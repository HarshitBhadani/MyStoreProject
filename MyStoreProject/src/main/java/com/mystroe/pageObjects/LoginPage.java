/**
 * 
 */
package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

/**
 * @author Harshit
 *
 */
public class LoginPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();

	@FindBy(id="email") private WebElement userName;
	@FindBy(id="passwd") private WebElement password;
	@FindBy(id="SubmitLogin") private WebElement signInBtn;
	@FindBy(id="email_create") private WebElement emailForNewAccount;
	@FindBy(id="SubmitCreate") private WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd) {
		actionPage.scrollByVisibilityOfElement(getDriver(), userName);
		actionPage.type(userName, uname);
		actionPage.type(password, pswd);
		actionPage.JSClick(getDriver(), signInBtn);
		actionPage.getSleep(2000);
		return new HomePage();
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) {
		actionPage.scrollByVisibilityOfElement(getDriver(), userName);
		actionPage.type(userName, uname);
		actionPage.type(password, pswd);
		actionPage.click(getDriver(), signInBtn);
		actionPage.getSleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail){
		actionPage.type(emailForNewAccount, newEmail);
		actionPage.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
}
