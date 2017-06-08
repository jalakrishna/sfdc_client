package com.salesforce.automation.servicelayer.ClassicPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * This Page Object is for the common classic page elements
 * Created by rtigulla on 6/8/17.
 */
public class Page  {
    private WebDriver driver;

    @FindBy(id = "userNavLabel")
    private WebElement UserName;

    @FindBy(linkText = "Switch to Lightning Experience")
    private WebElement SwitchToLightningViewLink;


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
}
