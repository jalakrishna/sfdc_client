package com.salesforce.automation.servicelayer.utils;

import com.salesforce.automation.servicelayer.ClassicPageObjects.Page;
import com.salesforce.automation.servicelayer.Exception.NonSupportedPlatformException;
import com.salesforce.automation.servicelayer.config.SupportedPlatforms;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

/**
 * This class contains all UI related Utilites class
 * Created by rtigulla on 6/7/17.
 */
public class UIUtilities {

    /**
     * This method is used to switch to classic view when user is not in classic view
     * @param driver
     * @return successfully switched to classview WebDriver
     * @throws MalformedURLException
     * @throws InterruptedException
     */
    public static WebDriver SwitchToClassicView(WebDriver driver) throws MalformedURLException, InterruptedException, NonSupportedPlatformException {
        try {
            if (SupportedPlatforms.CLASSIC != UrlUtilities.CheckUserPlatform(driver)) {
                System.out.println("Click on User Icon Link");
                com.salesforce.automation.servicelayer.LightningPageObjects.Page page = com.salesforce.automation.servicelayer.LightningPageObjects.Page.init(driver);
                page.getUserIcon().click();
                Thread.sleep(3000);
                System.out.println("Click on 'Switch to Classic View' Link");
                page.getSwitchToClassicViewLink().click();
                Thread.sleep(3000); //Replace with Wait until lightning view is loaded using fluient waits
            }
        }catch(NoSuchElementException nex){
            System.out.println("No Such Element Exception, " + nex.getMessage());
            nex.printStackTrace();
            throw nex;

        }catch(Exception ex){
            System.out.println("Exception, " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        return driver;
    }

    /**
     * This method is used to switch to Lightning view when user is not in Lightning view
     * @param driver
     * @return successfully switched to classview WebDriver
     * @throws MalformedURLException
     * @throws InterruptedException
     */
    public static WebDriver SwitchToLightningView(WebDriver driver) throws MalformedURLException, InterruptedException, NonSupportedPlatformException {
        try{
            if (SupportedPlatforms.LIGHTNING != UrlUtilities.CheckUserPlatform(driver)){
                System.out.println("Click on User Name Link");
                com.salesforce.automation.servicelayer.ClassicPageObjects.Page page = com.salesforce.automation.servicelayer.ClassicPageObjects.Page.init(driver);
                page.getUserName().click();
                Thread.sleep(3000);
                System.out.println("Click on 'Switch to Lightning Experience' Link");
                page.getSwitchToLightningViewLink().click();
                Thread.sleep(3000); //Replace with Wait until lightning view is loaded using fluient waits
            }
        }catch(NoSuchElementException nex){
            System.out.println("No Such Element Exception, " + nex.getMessage());
            nex.printStackTrace();
            throw nex;

        }catch(Exception ex){
            System.out.println("Exception, " + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
        return driver;
    }
}
