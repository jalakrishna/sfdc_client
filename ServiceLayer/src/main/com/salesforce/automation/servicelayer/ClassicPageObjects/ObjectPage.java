package com.salesforce.automation.servicelayer.ClassicPageObjects;


import com.salesforce.automation.servicelayer.utils.UrlUtilities;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This User Object contains WebElement on the Object Page
 * Created by ishriwastava on 6/09/17.
 */
public class ObjectPage {
	
    
    @FindBy(xpath = "//input[contains(@title,'Edit')]")
    private WebElement edit;
    
    public ObjectPage(WebDriver driver) {
        super(driver);
    }
    
    public static ObjectPage init(WebDriver driver) throws MalformedURLException {
    	ObjectPage object = PageFactory.initElements(driver, ObjectPage.class);
    	object.setDriver(driver);
        return object;
    }
    
    public static ObjectPage openObjectPage(WebDriver driver, String url) throws MalformedURLException {
        driver.get(UrlUtilities.getServerUrlIncludingProtocol(driver.getCurrentUrl()) + "/" + url);
        ObjectPage object = PageFactory.initElements(driver, ObjectPage.class);
        object.setDriver(driver);
        return object;
    }
    

    
    public WebElement getObjectEdit() {
        return edit;
    }
 


}
