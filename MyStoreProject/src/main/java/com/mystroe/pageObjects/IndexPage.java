package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class IndexPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath = "//a[@class='login']") private WebElement signInBtn;
	@FindBy(xpath = "//img[@class='logo img-responsive']")	private WebElement myStoreLogo;
	@FindBy(id="search_query_top") private WebElement searchProductBox;
	@FindBy(name="submit_search") private WebElement searchButton;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public LoginPage clickOnSignIn() {
		actionPage.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public Boolean validateLogo() {
		return actionPage.isDisplayed(getDriver(), myStoreLogo);
	}
	
	public String getMyStroeTitle() {
		return getDriver().getTitle();
	}
	
	public SearchResultPage searchProduct(String searchProduct) {
		actionPage.type(searchProductBox, searchProduct);
		actionPage.click(getDriver(), searchButton);
		return new SearchResultPage();
	}
}
