package com.salesforce.automation.servicelayer.LightningPageObjects;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
    private static final String SEARCH_ITEM = "//a[@title= '@TABNAME']/span/span/mark";
    
    @FindBy(xpath = "//span[text() = 'App Launcher' and @class = 'slds-assistive-text']/parent::div/parent::button")
    private static WebElement AppLauncher;
    
    @FindBy(xpath = "//img[@class='profileTrigger' and contains(@src,'profilephoto')]")
    private WebElement UserIcon;
 
    @FindBy(linkText = "Switch to Salesforce Classic")
    private static WebElement SwitchToClassicViewLink;

    @FindBy(xpath = ".//input[@placeholder='Find an app or item']")
    private static WebElement HomeOpenAnyTab;
    
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

    public WebElement getUserIcon() {
        return UserIcon;
    }

    public WebElement getSwitchToClassicViewLink() {
        return SwitchToClassicViewLink;
    }
    
    public WebElement getAppLauncher() {
    	return AppLauncher;
    }
    
    public WebElement setHomeOpenAnyTab() {
    	return HomeOpenAnyTab;
    }
    
    public WebElement getSearchItem(String tabName) {
    	String strXpathLocator = (SEARCH_ITEM.replace("@TABNAME", tabName));
    	return driver.findElement(By.xpath(strXpathLocator));
    }
    
}
