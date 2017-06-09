package com.salesforce.automation.servicelayer.ClassicPageObjects;

import com.salesforce.automation.servicelayer.utils.UrlUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.MalformedURLException;

/**
 * This Home Object is for the Home Page and User WebElement in Classic view
 * Created by rtigulla on 6/8/17.gog
 */
public class Home extends Page {

    @FindBy(name= "login")
    private WebElement homeLogin;

    public Home(WebDriver driver) {
        super(driver);
    }

    public static Home init(WebDriver driver) throws MalformedURLException {
        Home home = PageFactory.initElements(driver, Home.class);
        home.setDriver(driver);
        return home;
    }

    public static Home openUserPage(WebDriver driver,String url) throws MalformedURLException {
        driver.get(UrlUtilities.getServerUrlIncludingProtocol(driver.getCurrentUrl()) + "/" + url);
        Home home = PageFactory.initElements(driver, Home.class);
        home.setDriver(driver);
        return home;
    }

    public WebElement getHomeLogin() {
        return homeLogin;
    }
}
