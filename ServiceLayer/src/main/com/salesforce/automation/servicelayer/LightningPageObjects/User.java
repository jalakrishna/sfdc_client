package com.salesforce.automation.servicelayer.LightningPageObjects;


import com.salesforce.automation.servicelayer.LightningPageObjects.Page;
import com.salesforce.automation.servicelayer.utils.UrlUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * This User Object contains WebElement on the User Page
 * Created by rtigulla on 6/8/17.
 */
public class User extends Page{

    @FindBy(xpath = "//div[contains(@title,'User Detail')]")
    private WebElement userDetail;

    @FindBy(xpath = "//iframe[contains(@title,'User')]")
    private WebElement userDetailsIframe;

    @FindBy(name = "login")
    private WebElement userLogin;

    public User(WebDriver driver) {
        super(driver);
    }
    public static User openUserPage(WebDriver driver, String url) throws MalformedURLException {
        driver.get(UrlUtilities.getServerUrlIncludingProtocol(driver.getCurrentUrl()) + "/" + url);
        User user = PageFactory.initElements(driver, User.class);
        user.setDriver(driver);
        return user;
    }
    
    public static User init(WebDriver driver) throws MalformedURLException {
    	User user = PageFactory.initElements(driver, User.class);
    	user.setDriver(driver);
        return user;
    }
    public WebElement getUserDetail() {
        return userDetail;
    }

    public WebElement getUserDetailsIframe() {
        return userDetailsIframe;
    }

    public WebElement getUserLogin() {
        return userLogin;
    }
 

}
