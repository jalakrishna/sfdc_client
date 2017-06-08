package com.salesforce.automation.servicelayer.LightningPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * This Page Object is for the common Lightning page elements
 * Created by rtigulla on 6/8/17.
 */
public class Page {
    private WebDriver driver;

    @FindBy(xpath = "//img[@class='profileTrigger' and contains(@src,'profilephoto')]")
    private WebElement UserIcon;

    @FindBy(linkText = "Switch to Salesforce Classic")
    private WebElement SwitchToClassicViewLink;

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

    public WebElement getUserIcon() {
        return UserIcon;
    }

    public WebElement getSwitchToClassicViewLink() {
        return SwitchToClassicViewLink;
    }
}
