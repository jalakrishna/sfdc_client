package com.salesforce.automation.servicelayer.ClassicPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * This page object contains all the landing page web elements
 * Created by rtigulla on 6/8/17.
 */
public class SFLogin extends Page{

    @FindBy(name = "username")
    private WebElement UserName;

    @FindBy(name = "pw")
    private WebElement Password;

    @FindBy(name = "Login")
    private WebElement LoginBtn;

    public SFLogin(WebDriver driver) {
        super(driver);
    }  

    public static SFLogin init(WebDriver driver) {
        SFLogin sfLogin = PageFactory.initElements(driver, SFLogin.class);
        sfLogin.setDriver(driver);
        return sfLogin;
    }

    public WebElement getUserName() {
        return UserName;
    }

    public WebElement getPassword() {
        return Password;
    }

    public WebElement getLoginBtn() {
        return LoginBtn;
    }
}
