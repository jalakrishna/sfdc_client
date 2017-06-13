package com.salesforce.automation.servicelayer.ClassicPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.automation.servicelayer.utils.UrlUtilities;

import java.net.MalformedURLException;

/**
 * This Page Object is for the common classic page elements
 * Created by rtigulla on 6/8/17.
 */
public class Page  {
    private WebDriver driver;
    private static final String HOME_OPEN_ANY_TAB = "//a[text()='@TABNAME' and img[contains(@title,'@TABNAME')]]";
    
    @FindBy(name= "login")
    private WebElement homeLogin;
    
    @FindBy(id = "userNavLabel")
    private WebElement UserName;

    @FindBy(linkText = "Switch to Lightning Experience")
    private WebElement SwitchToLightningViewLink;
    
    @FindBy(linkText = "Log Out")
    private WebElement ClassicPageLogoutOption;
    
    @FindBy(xpath = "//input[contains(@title,'Edit')]")
	private WebElement edit;

    @FindBy(xpath = HOME_OPEN_ANY_TAB)
	private WebElement homeOpenAnyTab;

    @FindBy(xpath = "//a[img[contains(@src,'s.gif') and @class='allTabsArrow' and @title='All Tabs']]")
	private WebElement homeAllTabs;
    
    public Page(WebDriver driver) {
        this.driver = driver;
    }

    protected void setDriver(WebDriver driver) {
        this.driver = driver;
    }
    protected WebDriver getDriver() {
        return driver;
    }

    public static Page init(WebDriver driver) throws MalformedURLException {
        Page page = PageFactory.initElements(driver, Page.class);
        page.setDriver(driver);
        return page;
    }

    public WebElement getUserName() {
        return UserName;
    }

    public WebElement getSwitchToLightningViewLink() {
        return SwitchToLightningViewLink;
    }  

    public static Page openPage(WebDriver driver,String url) throws MalformedURLException {
        driver.get(UrlUtilities.getServerUrlIncludingProtocol(driver.getCurrentUrl()) + "/" + url);
        Page page = PageFactory.initElements(driver, Page.class);
        page.setDriver(driver);
        return page;
    }

    public WebElement getHomeLogin() {
        return homeLogin;
    }
    
    public WebElement getHomeAllTabs() {
		return homeAllTabs;
	}

    public WebElement getClassicPageLogoutOption() {
        return ClassicPageLogoutOption;
    }
    
    public WebElement getObjectEdit() {
		return edit;
	}
    
    public WebElement getHomeOpenAnyTab(String tabName,WebDriver driver) {
		String strXpathLocator = (HOME_OPEN_ANY_TAB.replace("@TABNAME", tabName));
		homeOpenAnyTab = driver.findElement(By.xpath(strXpathLocator));
		return homeOpenAnyTab;
    }
}
