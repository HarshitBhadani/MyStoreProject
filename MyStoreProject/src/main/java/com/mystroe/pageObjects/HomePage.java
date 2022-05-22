package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class HomePage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath="//span[text()='My wishlists']") private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']") private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyWishList() {
		return actionPage.isDisplayed(getDriver(), myWishList);
	}
	
	public boolean validateOrderHistory() {
		return actionPage.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() {
		return actionPage.getCurrentURL(getDriver());
	}

}
