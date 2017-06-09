package com.salesforce.automation.servicelayer.ClassicPageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
		private WebDriver driver;
		
		private static final String HOME_OPEN_ANY_TAB = "//a[text()='@TABNAME' and img[contains(@title,'@TABNAME')]]";
		
		@FindBy(id = "userNavLabel")
		private WebElement UserName;

		@FindBy(linkText = "Switch to Lightning Experience")
		private WebElement SwitchToLightningViewLink;
	    
	    @FindBy(xpath = HOME_OPEN_ANY_TAB)
		private WebElement homeOpenAnyTab;
	    
	    @FindBy(xpath = "//a[img[contains(@src,'s.gif') and @class='allTabsArrow' and @title='All Tabs']]")
		private WebElement homeAllTabs;
	    
	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    protected void setDriver(WebDriver driver) {
	        this.driver = driver;
	    }
	    protected WebDriver getDriver() {
	        return driver;
	    }
	    
	    public static HomePage init(WebDriver driver) throws MalformedURLException {
	        HomePage page = PageFactory.initElements(driver, HomePage.class);
	        page.setDriver(driver);
	        return page;
	    }

	    public WebElement getUserName() {
	        return UserName;
	    }

	    public WebElement getSwitchToLightningViewLink() {
	        return SwitchToLightningViewLink;
	    }
	    
	    public WebElement getHomeAllTabs() {
			return homeAllTabs;
		}
	    
	    public void setHomeOpenAnyTab(String tabName,WebDriver driver) {
			String strXpathLocator = (HOME_OPEN_ANY_TAB.replace("@TABNAME", tabName));
			homeOpenAnyTab = driver.findElement(By.xpath(strXpathLocator));
		}
	    
	    public WebElement getHomeOpenAnyTab() {
			return homeOpenAnyTab;
		}
	    
}
