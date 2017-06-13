package com.salesforce.automation.servicelayer.LightningPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.salesforce.automation.servicelayer.utils.UrlUtilities;

import java.net.MalformedURLException;

/**
 * This Page Object is for the common Lightning page elements
 * Created by rtigulla on 6/8/17.
 */
public class Page {
    private WebDriver driver;
    private static final String SEARCH_ITEM = "//a[@title= '@TABNAME']/span/span/mark";
    
    @FindBy(xpath = "//img[@class='profileTrigger' and contains(@src,'profilephoto')]")
    private WebElement UserIcon;

    @FindBy(linkText = "Switch to Salesforce Classic")
    private WebElement SwitchToClassicViewLink;
      
    @FindBy(xpath = "//a[contains(@title,'Edit')and @class='forceActionLink']")
    private WebElement edit;
    
    @FindBy(xpath = "//a[contains(@title,'Show more actions for this record')]")
    private WebElement showMoreAction;
    
    @FindBy(xpath = "//a[contains(@title,'Edit')]")
    private WebElement dropdownEdit;
    
    @FindBy(xpath = "//span[text() = 'App Launcher' and @class = 'slds-assistive-text']/parent::div/parent::button")
    private static WebElement AppLauncher;
    
    @FindBy(xpath = "//input[@placeholder='Find an app or item']")
    private static WebElement HomeOpenAnyTab;
    
    @FindBy(xpath = "//a[@title='Details' and @class='tabHeader']")
    private static WebElement OpenDetailTab;
    
    @FindBy(linkText = "Logout")
    private WebElement LightningPageLogoutOption;
    
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

    public static Page openPage(WebDriver driver, String url) throws MalformedURLException {
        driver.get(UrlUtilities.getServerUrlIncludingProtocol(driver.getCurrentUrl()) + "/" + url);
        Page object = PageFactory.initElements(driver, Page.class);
        object.setDriver(driver);
        return object;
    }
  
    public WebElement getLightningPageLogoutOption() {
        return LightningPageLogoutOption;
    }
    
    public WebElement getUserIcon() {
        return UserIcon;
    }

    public WebElement getSwitchToClassicViewLink() {
        return SwitchToClassicViewLink;
    }
       
    public WebElement getObjectEdit() {
        return edit;
    }
   
    public WebElement getshowMoreAction() {
        return showMoreAction;
    }
    
    public WebElement getDropdownEdit() {
        return dropdownEdit;
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
    
    public WebElement openDetailTab() {
    	return OpenDetailTab;
    } 
}
